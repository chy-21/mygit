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

    <title>教师管理</title>

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
        <jsp:param name="menu_id" value="3"/>
    </jsp:include>
    <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                       	 教师管理
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fa fa-dashboard"></i> <a
                                href="${pageContext.request.contextPath}/main">主界面</a>
                        </li>
                        <li>
                            <i class="fa fa-table"></i> <a
                                href="${pageContext.request.contextPath}/main/business/teacher">教师管理</a>
                        </li>
                        <li class="active">
                            <i class="fa fa-table"></i> 添加/编辑教师资料
                        </li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header">
                        <h3>教师基本信息</h3>
                    </div>
				
                    <form id="teacherForm" action="${pageContext.request.contextPath}/main/business/teacher/edit"
                          method="post" user="form">
                        <input id="tId" name="id" hidden="hidden" value="${teacher.id}">
                       	<div class="row form-group">
                            <div class="col-lg-2"><label>名称<span class="required"> * </span></label></div>
                            <div class="col-lg-4"><input class="form-control" required="true" id="name" name="name" value="${teacher.name}" placeholder="1到20个字之间">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-lg-2">
                            	<label>性别<span class="required"> * </span></label>
                            </div>
                            <div class="col-lg-4">
                                <select class="form-control" id="sex" name="sex">
                                    <option value="男" ${teacher.sex == '男' ?'selected':'' }>男</option>
                                    <option value="女" ${teacher.sex == '女' ?'selected':'' }>女</option>
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                        	<div class="col-lg-2">
                        		<label>年龄<span class="required"> * </span></label>
                        	</div>
                        	<div class="col-lg-4">
                        		<input class="form-control" required="true" id="age" name="age" value="${teacher.age}"/>
                        	</div>
                        </div>
                        <div class="row form-group">
                        	<div class="col-lg-2">
                        		<label>教师简介</label>
                        	</div>
                        	<div class="col-lg-4">
                        		<input class="form-control" id="synopsis" name="synopsis" value="${teacher.synopsis}"/>
                        	</div>
                        </div>
                        <div class="row form-group">
                        	<div class="col-lg-2">
                        		<label>所在学校<span class="required"> * </span></label>
                        	</div>
                        	<div class="col-lg-4">
                        		<input type="hidden" name="s_id" id="s_id" value="${teacher.s_id }" />
                        		<input class="form-control" required="true" id="sName" name="sName" value="${teacher.sName}"/>
                        	</div>
                        </div>
                        <div class="row form-group">
                        	<div class="col-lg-2">
                        		<label>所在年级<span class="required"> * </span></label>
                        	</div>
                        	<div class="col-lg-4">
                        		<input type="hidden" name="g_id" id="g_id" value="${teacher.g_id }" />
                        		<input class="form-control" required="true" id="gName" name="gName" value="${teacher.gName}"/>
                        	</div>
                        </div>
                        <div class="row form-group">
                        	<div class="col-lg-2">
                        		<label>所在班级<span class="required"> * </span></label>
                        	</div>
                        	<div class="col-lg-4">
                        		<input type="hidden" name="c_id" id="c_id" value="${teacher.c_id }" />
                        		<input class="form-control" required="true" id="cName" name="cName" value="${teacher.cName}"/>
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
    	initAutocomplateSchool();
    	initAutocomplateGrade();
    	initAutocomplateClass();
    	
        $('#teacherForm').ajaxForm({
            beforeSubmit: function () {
                return $('#teacherForm').valid();
            },
            success: function (data) {
                if (!data.status) {
                    $.toast({
                        heading: '添加/编辑教师!',
                        text: '成功!',
                        icon: 'info',
                        position: 'mid-center',
                        loaderBg: '#00C1DE',
                        afterHidden: function () {
                            window.location.href = '${pageContext.request.contextPath}/main/business/teacher';
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
    
    function initAutocomplateSchool(){
    	$.ajax({
    		url: "${pageContext.request.contextPath}/main/business/school/autoSchool",
    		method:'get',
    		dataType:'json',
    		success: function(data){
    			$( "#sName" ).autocomplete({
    			      source: data,
    			      delay:10,
    			      minLength:0,
    			      autoFocus:false,
    			      focus: function( event, ui ) {
    			        $( "#sName" ).val( ui.item.label );
    			        $( "#s_id" ).val( ui.item.value );
    			        return false;
    			      },
    			      select: function( event, ui ) {
    			        $( "#sName" ).val( ui.item.label );
    			        $( "#s_id" ).val( ui.item.value );
    			        return false;
    			      }
    			    })
    			    .data( "ui-autocomplete" )._renderItem = function( ul, item ) {
    			      return $( "<li>" )
    			        .append( "<a>" + item.label + "</a>" )
    			        .appendTo( ul );
    			    };
        	}
		})
    }
    
    function initAutocomplateGrade(){
    	$.ajax({
    		url: "${pageContext.request.contextPath}/main/business/s_grade/autoGrade",
    		method:'get',
    		dataType:'json',
    		success: function(data){
    			$( "#gName" ).autocomplete({
    			      source: data,
    			      delay:10,
    			      minLength:0,
    			      autoFocus:false,
    			      focus: function( event, ui ) {
    			        $( "#gName" ).val( ui.item.label );
    			        $( "#g_id" ).val( ui.item.value );
    			        return false;
    			      },
    			      select: function( event, ui ) {
    			        $( "#gName" ).val( ui.item.label );
    			        $( "#g_id" ).val( ui.item.value );
    			        return false;
    			      }
    			    })
    			    .data( "ui-autocomplete" )._renderItem = function( ul, item ) {
    			      return $( "<li>" )
    			        .append( "<a>" + item.label + "</a>" )
    			        .appendTo( ul );
    			    };
        	}
		})
    }
    
    function initAutocomplateClass(){
    	$.ajax({
    		url:"${pageContext.request.contextPath}/main/business/s_class/autoClass",
    		method:'get',
    		datatype:'json',
    		success: function(data){
    			$( "#cName" ).autocomplete({
    			      source: data,
    			      delay:10,
    			      minLength:0,
    			      autoFocus:false,
    			      focus: function( event, ui ) {
    			        $( "#cName" ).val( ui.item.label );
    			        $( "#c_id" ).val( ui.item.value );
    			        return false;
    			      },
    			      select: function( event, ui ) {
    			        $( "#cName" ).val( ui.item.label );
    			        $( "#c_id" ).val( ui.item.value );
    			        return false;
    			      }
    			    })
    			    .data( "ui-autocomplete" )._renderItem = function( ul, item ) {
    			      return $( "<li>" )
    			        .append( "<a>" + item.label + "</a>" )
    			        .appendTo( ul );
    			    };
        	}
    	})
    }
    
</script>
</body>

</html>
