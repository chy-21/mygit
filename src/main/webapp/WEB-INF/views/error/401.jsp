<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>权限异常</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main/css/error.css">
<%--     <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/main/images/favicon.ico" type="image/x-icon"/> --%>
    <script src="${pageContext.request.contextPath}/static/global/js/jquery.js"></script>
</head>
<body>
<div class="container-401">
    <div class="box">
        <h2>抱歉，你的权限不能进行此项操作。</h2>
        <p>请联系系统管理员。</br><span id="times">5</span> 秒后,返回 <a href="${pageContext.request.contextPath}/"> 首页</a></p>
    </div>
</div>
</body>
</html>
<script>
    $(function(){
        var s = 5;
        var timer = null;
        timer = setInterval(function(){
            if(s>0){
                --s;
                $('#times').html(s);
            }else{
                clearInterval(timer);
                location.href = "${pageContext.request.contextPath}/";
            }
        },1000)
    })
</script>