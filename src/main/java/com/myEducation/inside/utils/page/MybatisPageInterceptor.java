package com.myEducation.inside.utils.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

/**
 * 该拦截器用于对mybatis的所有分页查询进行拦截 1.为要执行的sql语句添加分页查询 2.查询出数据的总条数 注：
 * 要实现分页查询，mybatis的参数必须为page
 * 
 * @author Jat
 *
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class MybatisPageInterceptor implements Interceptor {
	// 数据库类型
	private String dbType;

	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();

		// 通过反射获取到当前RoutingStatementHandler对象的delegate属性
		StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
		BoundSql boundSql = delegate.getBoundSql();
		// 拿到当前绑定Sql的参数对象，就是我们在调用对应的Mapper映射语句时所传入的参数对象
		Object obj = boundSql.getParameterObject();
		// 这里我们简单的通过传入的是Page对象就认定它是需要进行分页操作的。
		if (obj instanceof Page) {
			Page<?> page = (Page<?>) obj;
			// 通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
			MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
			// 拦截到的prepare方法参数是一个Connection对象
			Connection connection = (Connection) invocation.getArgs()[0];
			// 获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句
			String sql = boundSql.getSql();
			// 给当前的page参数对象设置总记录数
			this.setTotalCount(page, mappedStatement, connection);
			// 获取分页Sql语句
			String pageSql = this.getPageSql(page, sql);
			// 利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句
			ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
		}
		return invocation.proceed();
	}

	/**
	 * 拼接分页查询语句
	 * 
	 * @param page
	 * @param sql
	 * @return
	 */
	public String getPageSql(Page<?> page, String sql) {
		StringBuffer sb = new StringBuffer();
		sb.append(sql);
		if (dbType.equals("mysql")) {
			//// 计算第一条记录的位置，Mysql中记录的位置是从0开始的。
			// int offset = (page.getPageNo() - 1) * page.getPageSize();
			sb.append(" limit ").append(page.getStart()).append(",").append(page.getLength());
		} else if (dbType.equals("oracle")) {

		} else {
			// 计算第一条记录的位置，Mysql中记录的位置是从0开始的。
			sb.append(" limit ").append(page.getStart()).append(",").append(page.getLength());
		}
		// System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 * 给page对象设置当前查询的总条数
	 * 
	 * @param page
	 * @param statement
	 * @param connection
	 */
	public void setTotalCount(Page<?> page, MappedStatement statement, Connection connection) {
		// 获取对应的BoundSql，这个BoundSql其实跟我们利用StatementHandler获取到的BoundSql是同一个对象。
		// delegate里面的boundSql也是通过mappedStatement.getBoundSql(paramObj)方法获取到的。
		BoundSql boundSql = statement.getBoundSql(page);
		// 获取到我们自己写在Mapper映射语句中对应的Sql语句
		String sql = boundSql.getSql();
		// 通过查询Sql语句获取到对应的计算总记录数的sql语句
		String countSql = this.getCountSql(sql);
		// 通过BoundSql获取对应的参数映射
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		// 利用Configuration、查询记录数的Sql语句countSql、参数映射关系parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。
		BoundSql countBoundSql = new BoundSql(statement.getConfiguration(), countSql, parameterMappings, page);
		// 通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象
		ParameterHandler parameterHandler = new DefaultParameterHandler(statement, page, countBoundSql);
		// 通过connection建立一个countSql对应的PreparedStatement对象。
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(countSql);
			// 通过parameterHandler给PreparedStatement对象设置参数
			parameterHandler.setParameters(pstmt);
			// 之后就是执行获取总记录数的Sql语句和获取结果了。
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int totalRecord = rs.getInt(1);
				// 给当前的参数page对象设置总记录数
				page.setRecordsFiltered(totalRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String getCountSql(String sql) {
		return "select count(*) from ("+sql+") t";
//		if(sql.indexOf("group by") >= 0){
//			return "select count(*) " + sql.substring(sql.toLowerCase().lastIndexOf("from"),sql.toLowerCase().lastIndexOf("group by"));
//		}
//		return "select count(*) " + sql.substring(sql.toLowerCase().lastIndexOf("from"),sql.toLowerCase().lastIndexOf("order by"));
	}

	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0, this);
	}

	public void setProperties(Properties arg0) {
		this.dbType = arg0.getProperty("dbType");
	}
	
}
