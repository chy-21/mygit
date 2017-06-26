<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>这里是。。。：请登录</title>
<%-- 	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/global/css/bootstrap.css"> --%>
<%--     <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main/css/common.css"> --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main/css/login.css">
</head>
<body>
<div class="warp">
	<div class="header">
		<div class="bg">
			<div class="logo">
				<img alt="" src="${pageContext.request.contextPath}/static/main/images/logo.jpg">
			</div>
			<div class="title">
				欢迎来到。。。
			</div>
		</div>
	</div>
	<div class="section">
		<div class="loginBox">
			<form id="loginform" class="form-horizontal" name="form" action="${pageContext.request.contextPath}/login" method="post">
				<div class="info has-error">
                    <div id="login-alert" style="display: none;">
                    </div>
                </div>
                <div class="form-group">
					<label for="username">账号：</label>
					<div class="col-sm-8"> 
						<input type="text" id="username" name="username" class="form-control" placeholder="亲输入用户名"><br>
					</div>
				</div>
				<div class="form-group">
					<div>
					<label for="username">密码：</label>
					</div>
					<div class="col-sm-8">
					<input type="password" id="password" name="password" placeholder="请出入密码" class="form-control"><br>
					</div>
				</div>
				<div class="form-group">
			         <div class="col-sm-offset-2 col-sm-4">
			             <div class="checkbox">
			                 <label>
			                     <input type="checkbox"> 记住密码
			                 </label>
			             </div>
			         </div>
			         <div class="col-sm-6">
			             <button type="submit" class="btn btn-block btn-login">登录</button>
			             <a href="#">注册</a>
			         </div>
			     </div>
			</form>
	     </div>
     </div>
</div>
<script src="${pageContext.request.contextPath}/static/global/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/global/js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/static/global/js/plugins/validation/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/static/global/js/plugins/validation/localization/messages_zh.min.js"></script>
<script src="${pageContext.request.contextPath}/static/main/js/common.js"></script>

<script type="text/javascript">
    $(function () {
        $("#loginform").validate({
            rules: {
                name: "required",
                pwd: "required"
            },
            messages: {
                name: {
                    required: "请输入用户名"
                },
                pwd: {
                    required: "请输入密码"
                }
            }
        });
        $('#loginform').ajaxForm({
            beforeSubmit: function () {
                return $('#loginform').valid();
            },
            dataType:'json',
            success: function (data) {
                console.log(data);
                if (!data.status) {
                    window.location.href = 'main';
                } else {
                    $('#login-alert').html(data.status == 10001 ? data.content : data.msg).show();
                }
            }
        });
    });
</script>
</body>
</html>