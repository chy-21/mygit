package com.myEducation.common.shiro;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.myEducation.inside.model.User;
import com.myEducation.inside.service.PremissionService;
import com.myEducation.inside.service.RoleService;
import com.myEducation.inside.service.UserRoleService;
import com.myEducation.inside.service.UserService;
import com.myEducation.inside.utils.Constant;
import com.myEducation.inside.utils.MD5Utils;


/**
 * 自定义用户认证类
 * @author Jat
 *
 */
public class MyAuthorizingRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private PremissionService premissionService;
	@Autowired
	private RoleService roleService;
	
	private String defaultPwd;
	
	private String siteName;
	
	/**
	 * 获取用户权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getSession().getAttribute(Constant.LOGIN_USER);
		if("admin".equals(user.getUsername())){
			info.addStringPermission("*");
			return info;
		}
		
		List<Integer> roles = this.userRoleService.selectByUserId(user.getId());
		if(roles != null && roles.size() > 0){
			List<String> premissions = this.premissionService.getByRole(roles);
			info.addStringPermissions(premissions);
			for (int i = 0; i < roles.size(); i++) {
				info.addRole(roles.get(i)+"");
			}
		}
		
		
		return info;
	}

	/**
	 * 用户登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authToken; 
		
		User user = this.userService.getByName(token.getUsername());
		if(user == null){
			throw new UnknownAccountException("找不到用户");
		}
		if(!user.getPassword().toUpperCase().equals(MD5Utils.md5(new String(token.getPassword())).toUpperCase())){
			throw new IncorrectCredentialsException("密码错误");
		}else{
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), new String(token.getPassword()),user.getUsername());
			Subject currentUser = SecurityUtils.getSubject();  
	        if(null != currentUser){  
	            Session session = currentUser.getSession();  
	            if(null != session){  
	                session.setAttribute(Constant.LOGIN_USER,user); 
	                session.setAttribute(Constant.USER_ROLE_NAME,this.roleService.selectNameByUserId(user.getId()));
	                session.setAttribute("siteName",getSiteName());
	                if(user.getPassword().equals(MD5Utils.md5(getDefaultPwd()))){
	                	session.setAttribute("isDefaultPwd",true);
	                }
	            }  
	        }  
	        return authcInfo;
		}
	}

	public String getDefaultPwd() {
		return defaultPwd;
	}

	public void setDefaultPwd(String defaultPwd) {
		this.defaultPwd = defaultPwd;
	}

	public String getSiteName() {
		try {
			return new String(siteName.getBytes("iso-8859-1"),"utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	

}
