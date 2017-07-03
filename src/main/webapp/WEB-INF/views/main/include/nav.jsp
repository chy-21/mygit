<%@ page contentType="text/html;charset=UTF-8" %>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">
            <img style="margin: 0 auto; vertical-align: middle;width: 104px;height: 50px;" src="${pageContext.request.contextPath}/static/main/images/knowledge.jpg" alt="" title="首页">
        </a>
    </div>
    <!-- Top Menu Items -->
  	<ul class="nav navbar-right top-nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${sessionScope.session_user.username} <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li>
                    <a href="${pageContext.request.contextPath}/main/manager/user/..."><i class="fa fa-fw fa-envelope"></i> 修改密码</a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="${pageContext.request.contextPath}/logout"><i class="fa fa-fw fa-power-off"></i> 退出</a>
                </li>
            </ul>
        </li>
    </ul>
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav">
<%--             <li ${param.menu_id == 1?'class="active"':''}> --%>
			<li>
                <a href="${pageContext.request.contextPath}/main"><i class="glyphicon glyphicon-king"></i>主界面</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/main/business/school"><i class="glyphicon glyphicon-home"></i>学校管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/main/business/teacher"><i class="glyphicon glyphicon-user"></i>教师管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/main/business/student"><i class="glyphicon glyphicon-pencil"></i>学生管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/main/manager/user"><i class=" glyphicon glyphicon-eye-open"></i>用户管理</a>
            </li>
        </ul>
    </div>
</nav>