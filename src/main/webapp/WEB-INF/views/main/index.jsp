<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>主页面</title>
	<!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/static/global/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/global/js/plugins/jquery.datetimepicker/css/jquery.datetimepicker.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/static/main/css/main.css" rel="stylesheet">
    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/static/global/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/static/global/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrapper">
		<jsp:include page="include/nav.jsp">
       		<jsp:param name="menu_id" value="1"/>
    	</jsp:include>
        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            	欢迎来到教育管理系统<small>在这里你能看到最全的教育情况</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> 概况
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->


                <!-- /.row -->

                <div class="row">
                <div class="col-md-11">
<!--                             <div class="form-inline form-box"> -->
<!--                                 <div class="form-group"> -->
<!--                                     <label>时段选择：</label> -->
<!--                                     <input id="datepickerS" size="16" type="text" class="form-control form_datetime"> -->
<!--                                     ~ <input id="datepickerE" size="16" type="text" class="form-control form_datetime"> -->
<!--                                 </div> -->
<!--                                 <button id="searchBtn" type="button" class="btn btn-success" onclick="sub()">查询</button> -->
<!--                             </div> -->
<!--                              <br> -->
                 </div>
                
                    <div class="col-lg-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i>学校最新动态</h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-area-chart"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i>教师比例</h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-donut-chart"></div>
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
    <script src="${pageContext.request.contextPath}/static/global/js/plugins/jquery.datetimepicker/js/jquery.datetimepicker.full.js"></script>
 
  <script>
  $(function() {
    $( "#datepickerS" ).datetimepicker({
    	timepicker:false,
    	 validateOnBlur:false,
         format:'Y-m',
         formatDate:'Y-m',
    });
    $( "#datepickerE" ).datetimepicker({
    	timepicker:false,
    	 validateOnBlur:false,
         format:'Y-m',
         formatDate:'Y-m',
    });
  });
  </script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/static/global/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/static/global/js/plugins/morris/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/global/js/plugins/morris/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/global/js/plugins/morris/morris-data.js"></script>
</body>
</html>