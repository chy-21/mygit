<%@ page contentType="text/html;charset=UTF-8" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html lang="zh">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>用户管理</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/static/global/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/static/main/css/main.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/static/global/font-awesome/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">

    <link href="${pageContext.request.contextPath}/static/global/js/plugins/toast/jquery.toast.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/global/js/plugins/confirm/jquery-confirm.min.css"
          rel="stylesheet">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/global/js/plugins/datatables/css/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/global/js/plugins/jquery-ui/jquery-ui.min.css">

</head>

<body>
<div id="wrapper">
    <jsp:include page="../include/nav.jsp">
        <jsp:param name="menu_parent_id" value="1"/>
        <jsp:param name="menu_id" value="6"/>
    </jsp:include>
    <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                       	 用户管理
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fa fa-dashboard"></i> <a
                                href="${pageContext.request.contextPath}/main">主界面</a>
                        </li>
                        <li>
                            <i class="fa fa-table"></i> <a
                                href="${pageContext.request.contextPath}/main/manager/user">用户管理</a>
                        </li>
                        <li class="active">
                            	添加/编辑用户
                        </li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header">
                        <h3>用户基本信息</h3>
                    </div>

                    <form id="userForm" action="${pageContext.request.contextPath}/main/manager/user/user-edit"
                          method="post" user="form">
                        <input id="userId" name="id" hidden="hidden" value="${user.id}">
                       	<div class="row form-group">
                            <div class="col-lg-2"><label>用户名称<span class="required"> * </span></label></div>
                            <div class="col-lg-4"><input class="form-control" required="true" id="username" name="username"
                                                         value="${user.username}" placeholder="1到20个字之间"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col-lg-2">
                                <label>用户密码<span class="required"> * </span></label>
                            </div>
                            <div class="col-lg-4">
                                <input class="form-control" required="true" id="password" name="password" type="password"
                                       value="${user.password}" placeholder="只能由数字和字母组成">
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary">提交</button>
                        <button type="reset" class="btn btn-default">重置</button>
                    </form>

                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/global/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/global/js/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/static/global/js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/static/global/js/plugins/validation/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/static/global/js/plugins/validation/localization/messages_zh.min.js"></script>
<script src="${pageContext.request.contextPath}/static/global/js/plugins/confirm/jquery-confirm.min.js"></script>
<script src="${pageContext.request.contextPath}/static/global/js/plugins/toast/jquery.toast.min.js"></script>
<script src="${pageContext.request.contextPath}/static/main/js/common.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/global/js/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/global/js/plugins/datatables/js/dataTables.bootstrap.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/static/global/js/bootstrap.min.js"></script>

<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<script type="text/javascript">

    var autoData;
    $(document).ready(function () {
        $("#userForm").validate({
            rules: {
                username: {
                    required: true,
                    checkName: true
                },
                password: {
                    minlength: 6,
                    required: true,
                    checkPwd: true
                }
            },
            messages: {
                uaername: {
                    required: "请输入用户名"
                },
                password: {
                    required: "请输入密码",
                    minlength: "密码至少6位"
                }
            }
        });
        $('#userForm').ajaxForm({
            beforeSubmit: function () {
                return $('#userForm').valid();
            },
            success: function (data) {
                if (!data.status) {
                    $.toast({
                        heading: '添加/编辑用户!',
                        text: '成功!',
                        icon: 'info',
                        position: 'mid-center',
                        loaderBg: '#00C1DE',
                        afterHidden: function () {
                            window.location.href = '${pageContext.request.contextPath}/dashboard/manager/user';
                        }
                    });
                } else {
                    $.alert({
                        title: '编辑失败!',
                        content: data.status == 10001 ? data.content : data.msg
                    });
                }
            }
        });
        $.validator.addMethod("checkName", function (value, element, params) {
            var checkName = /^[a-zA-Z0-9]+$/g;
            return this.optional(element) || (checkName.test(value));
        }, "*用户名只允许英文字母和数字组成！");

        $.validator.addMethod("checkPwd", function (value, element, params) {
            var checkPwd = /^\w{6,16}$/g;
            return this.optional(element) || (checkPwd.test(value));
        }, "*只允许6位以上的英文字母、数字或者下画线！");

    });

</script>
</body>

</html>
