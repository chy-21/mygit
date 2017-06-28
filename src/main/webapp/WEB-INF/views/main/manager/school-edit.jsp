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

    <title>学校管理</title>

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
        <jsp:param name="menu_id" value="2" />
    </jsp:include>
    <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                       	 学校管理
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fa fa-dashboard"></i> <a
                                href="${pageContext.request.contextPath}/main">主界面</a>
                        </li>
                        <li>
                            <i class="fa fa-table"></i> <a
                                href="${pageContext.request.contextPath}/main/manager/school">学校管理</a>
                        </li>
                        <li class="active">
                            <i class="fa fa-table"></i> 添加/编辑学校资料
                        </li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header">
                        <h3>学校基本信息</h3>
                    </div>
                    <form id="schoolForm" action="${pageContext.request.contextPath}/main/manager/school/edit"
                          method="post" user="form">
                        <input id="userId" name="id" hidden="hidden" value="${school.id}">
                       	<div class="row form-group">
                            <div class="col-lg-2"><label>名称<span class="required"> * </span></label></div>
                            <div class="col-lg-4">
                            	<input class="form-control" required="true" id="name" name="name" value="${school.name}">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-lg-2">
                                <label>学校负责人<span class="required"> * </span></label>
                            </div>
                            <div class="col-lg-4">
                                <input class="form-control" required="true" id="headmaster" name="headmaster" value="${school.headmaster}">
                            </div>
                        </div>
                        <div class="row form-group">
                        	<div class="col-lg-2">
                        		<label>学校简介<span class="required"> * </span></label>
                        	</div>
                        	<div class="col-lg-4">
                        		<input class="form-control" required="true" id="synopsis" name="synopsis" value="${school.synopsis}"/>
                        	</div>
                        </div>
	                    <div class="row form-group">
	                    	<div class="col-lg-2">
	                    		<label>学校地址<span class="required"> * </span></label>
	                    	</div>
	                    	<div class="col-lg-4">
	                    		<input class="form-control" required="true" id="address" name="address" value="${school.address}"/>
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
        $('#schoolForm').ajaxForm({
            beforeSubmit: function () {
                return $('#schoolForm').valid();
            },
            success: function (data) {
                if (!data.status) {
                    $.toast({
                        heading: '添加/编辑学校!',
                        text: '成功!',
                        icon: 'info',
                        position: 'mid-center',
                        loaderBg: '#00C1DE',
                        afterHidden: function () {
                            window.location.href = '${pageContext.request.contextPath}/main/manager/school';
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
    });

</script>
</body>

</html>
