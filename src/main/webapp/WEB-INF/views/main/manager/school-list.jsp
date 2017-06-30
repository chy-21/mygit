<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>学校管理</title>
	
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
			<jsp:param name="menu_id" value="2" />
		</jsp:include>
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							系统管理 <small>学校管理</small>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> 学校列表</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-6">
							<a href="${pageContext.request.contextPath}/main/manager/school/edit" class="btn btn-primary">添加学校</a>
                        	<button type="button" id="edit" class="btn btn-info hidden">编辑学校</button>
					</div>
					<div class="col-lg-6 form-inline text-right">
						<div class="form-group">
							<label for="searchName">名称:</label> <input class="form-control"
								id="searchName" type="text" />
						</div>
						<button id="searchBtn" class="btn btn-purple">搜索</button>
					</div>
				</div>
				<div class="col-lg-12">
				    <table id="data-table" class="table table-striped table-bordered table-responsive table-hover"
				           width="100%">
				        <thead>
				        <tr>
				            <th>学校名称</th>
				            <th>学校负责人</th>
				            <th>学校简介</th>
				            <th>学校地址</th>
				            <th>建校时间</th>
				        </tr>
				        </thead>
				    </table>
				</div>
			</div>
		</div>
	</div>
	
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
			$('#data-table tbody').on('click', 'tr', function () {
	            if ($(this).hasClass('selected')) {
	            }
	            else {
	                datatables.$('tr.selected').removeClass('selected');
	                $(this).addClass('selected');
	            }
	            var tr = $(this).closest('tr');
	            var row = datatables.row(tr).data();
	            $("#edit").removeClass('hidden');
	        });
	        $("#searchBtn").click(function () {
	            datatables.ajax.reload();
	        });
	        $("#edit").click(function () {
	            var d = datatables.row('.selected').data();
	            window.location.href = p + "/main/manager/teacher/edit/" + d.id;
	        });
	        
		})

		function initTable() {
			datatables = $("#data-table").DataTable(
			{
				"processing" : true,
				"ajax" : {
					"url" : p+ "/main/manager/school/data",
					data : function(d) {
						d["params[name]"] = $("#searchName").val();
					}
				},
				"order" : [ [ 4, "desc" ] ],
				"columns" : [
						{"data" : "name"},
						{"data" : "headmaster"},
						{"data" : "synopsis"},
						{"data" : "address"},
						{"data" : "entrytime",render : function(d) {
								return d.split(".")[0];
						}} 
						]
			});
		}
	</script>
</body>
</html>