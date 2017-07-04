<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>教师管理</title>
	
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
			<jsp:param name="menu_id" value="3" />
		</jsp:include>
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							系统管理 <small>教师管理</small>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> 教师列表</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-6">
<!--                        <shiro:hasPermission name="add"> -->
                        	<a href="${pageContext.request.contextPath}/main/business/teacher/edit" class="btn btn-primary">添加老师</a>
<%-- 						</shiro:hasPermission> --%>
<%-- 						<shiro:hasPermission name="edit"> --%>
                        	<button type="button" id="edit" class="btn btn-info hidden">编辑老师</button>
<%-- 	                    </shiro:hasPermission> --%>
<%-- 	                    <shiro:hasPermission name="delete"> --%>
	                        <button type="button" id="delete" class="btn btn-danger hidden">删除老师</button>
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
				            <th>姓名</th>
				            <th>性别</th>
				            <th>年龄</th>
				            <th>简介</th>
				            <th>所属学校</th>
				            <th>年级</th>
				            <th>班级</th>
				            <th>入校时间</th>
				            <th>修改时间</th>
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
	            $("#delete").removeClass('hidden');
	            $("#edit").removeClass('hidden');
	        });
	        $("#searchBtn").click(function () {
	            datatables.ajax.reload();
	        });
	        $("#edit").click(function () {
	            var d = datatables.row('.selected').data();
	            window.location.href = p + "/main/business/teacher/edit/" + d.id;
	        });
	        
	        $("#delete").click(function () {
	            var d = datatables.row('.selected').data();
	            $.confirm({
	                icon: 'glyphicon glyphicon-bell',
	                title: '提示',
	                content: '是否确认删除该用户?',
	                type: 'red',
	                typeAnimated: true,
	                buttons: {
	                    tryAgain: {
	                        text: '确认',
	                        btnClass: 'btn-green',
	                        action: function () {
	                            $.ajax({
	                                url: "${pageContext.request.contextPath}/main/business/teacher/delete/",
	                                method: 'post',
	                                data: {id: d.id},
	                                success: function (data) {
	                                    if (!data.status) {
	                                        $.toast({
	                                            heading: '提示',
	                                            text: '成功!',
	                                            icon: 'info',
	                                            position: 'mid-center',
	                                            loaderBg: '#00C1DE',
	                                            afterHidden: function () {
	                                                datatables.ajax.reload();
	                                            }
	                                        });
	                                    } else {
	                                        $.alert({
	                                            title: '提示',
	                                            content: data.content
	                                        });
	                                    }
	                                }
	                            });
	                        }
	                    },
	                    close: {
	                        text: '取消'
	                    }
	                }
	            });
	        })
	        
		})

		function initTable() {
			datatables = $("#data-table").DataTable(
			{
				"processing" : true,
				"ajax" : {
					"url" : p+ "/main/business/teacher/data",
					data : function(d) {
						d["params[name]"] = $("#searchName").val();
					}
				},
				"order" : [ [ 7, "desc" ] ],
				"columns" : [
 						//s_id,g_id,c_id,entrytime,updatetime
						{"data" : "name"},
						{"data" : "sex",render : function(d){
							if(d == 0){
								return "男";
							}else{
								return "女";
							}
						}},
						{"data" : "age"},
						{"data" : "synopsis"},
						{"data" : "sName"},
						{"data" : "s_grade"},
						{"data" : "s_class"},
						{"data" : "entrytime",render : function(d) {
								return d.split(".")[0];
						}},
						{"data" : "updatetime",render : function(d) {
								return d.split(".")[0];
						}}
						]
			});
		}
	</script>
</body>
</html>