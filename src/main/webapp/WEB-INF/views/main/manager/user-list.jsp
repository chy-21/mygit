<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>用户管理</title>
	
	<!-- Bootstrap Core CSS -->
	<link href="${pageContext.request.contextPath}/static/global/css/bootstrap.css" rel="stylesheet">
	
	<!-- Custom CSS -->
	<link href="${pageContext.request.contextPath}/static/main/css/main.css" rel="stylesheet">
	
	<!-- Morris Charts CSS -->
	<link href="${pageContext.request.contextPath}/static/global/css/plugins/morris.css" rel="stylesheet">
	
	<!-- Custom Fonts -->
	<link href="${pageContext.request.contextPath}/static/global/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/static/global/js/plugins/confirm/jquery-confirm.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/global/js/plugins/toast/jquery.toast.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/global/js/plugins/datatables/css/dataTables.bootstrap.css">

</head>
<body>
	<div id="wrapper">
		<jsp:include page="../include/nav.jsp">
			<jsp:param name="menu_id" value="5" />
		</jsp:include>
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							系统管理 <small>用户管理</small>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> 用户列表</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-6">
<!-- 						<shiro:hasPermission name="user-add"> -->
							<a href="${pageContext.request.contextPath}/main/manager/user/edit" class="btn btn-primary">添加用户</a>
<!-- 						</shiro:hasPermission> -->
<!-- 						<shiro:hasPermission name="user-edit"> -->
							<button type="button" id="user-edit" class="btn btn-info hidden">编辑用户</button>
<!-- 						</shiro:hasPermission> -->
<!-- 						<shiro:hasPermission name="user-delete"> -->
<!-- 							<button type="button" id="user-delete" class="btn btn-danger hidden">删除用户</button> -->
<!-- 						</shiro:hasPermission> -->
<!-- 						<shiro:hasPermission name="user-status"> -->
<!-- 							<button type="button" id="user-status" class="btn btn-default hidden">禁用用户</button> -->
<!-- 						</shiro:hasPermission> -->
<!-- 						<shiro:hasPermission name="user-updatePwd"> -->
<!-- 							<button type="button" id="user-updatePwd" class="btn btn-warning hidden">密码重置</button> -->
<!-- 						</shiro:hasPermission> -->
					</div>
					<div class="col-lg-6 form-inline text-right">
						<div class="form-group">
							<label for="searchName">名称:</label> 
							<input class="form-control" id="searchName" type="text" />
						</div>
						<button id="searchBtn" class="btn btn-purple">搜索</button>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<table id="data-table" class="table table-striped table-bordered"
							style="width: 100%;">
							<thead>
								<tr>
									<th>用户名称</th>
									<th>用户状态</th>
									<th>录入时间</th>
									<th>修改时间</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>


		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/static/global/js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/static/global/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/static/global/js/plugins/jquery.datetimepicker/js/jquery.datetimepicker.full.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/global/js/plugins/datatables/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/global/js/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/global/js/common.js"></script>
	<script src="${pageContext.request.contextPath}/static/global/js/plugins/confirm/jquery-confirm.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/global/js/plugins/toast/jquery.toast.min.js"></script>
	<script type="text/javascript">
		var p = '${pageContext.request.contextPath}';
		var datatables;
		$(function() {
			initTable();
		})

		function initTable() {
			datatables = $("#data-table").DataTable(
			{
				"processing" : true,
				"ajax" : {
					"url" : p+ "/main/manager/user/data",
					data : function(d) {
						d["params[username]"] = $("#searchName").val();
					}
				},
				"order" : [ [ 2, "desc" ] ],
				"columns" : [
						{"data" : "username"},
						{"data" : "status",render : function(d){
							if (d == 0) {
								return "<span class=\"label label-primary\">正常</span>";
							} else {
								return "<span class=\"label label-warning\">禁用</span>";
							}
						}},
						{"data" : "entrytime",render : function(d) {
								return d.split(".")[0];
						}},
						{"data" : "updatetime",render : function(d) {
								return d.split(".")[0];
						}} ]
			});
		}
	</script>
</body>
</html>
