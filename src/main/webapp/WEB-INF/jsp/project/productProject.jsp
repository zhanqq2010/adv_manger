<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="image/png">

  <title>Left menu collapsed</title>

  <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/css/style-responsive.css" rel="stylesheet">
  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/js/data-tables/DT_bootstrap.css" />

<!-- velocity 弹出框模块 start -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jQueryVelocity/css/style.css">

<!-- velocity 弹出框模块  end-->

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="sticky-header ">

<section>
    <%@ include file="/WEB-INF/jsp/common/leftnav.jsp"%>
    
    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start-->
        <%@ include file="/WEB-INF/jsp/common/topnav.jsp"%>
        <!-- header section end-->

 <!-- page heading start-->
        <div class="page-heading">
            <h3>
            	   广告管理平台
            </h3>
            <ul class="breadcrumb">
                <li>
                    <a href="#">首页</a>
                </li>
                <li class="active">${typeDescription}项目</li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
    <div class="wrapper">
             <div class="row">
                <div class="col-sm-12">
                <section class="panel">
                <header class="panel-heading">
                 	   广告厂商
                    <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                        <a href="javascript:;" class="fa fa-times"></a>
                     </span>
                </header>
                <div class="panel-body">
                <div class="adv-table editable-table ">
                <div class="clearfix">
                    <div class="btn-group">
                      <a href="${pageContext.request.contextPath}/project/goAddProductProject/${partnerName}" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i> 添加项目 </a>
                    </div>
                    <div class="btn-group pull-right">
                        <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">工具 <i class="fa fa-angle-down"></i>
                        </button>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="#">打印</a></li>
                            <li><a href="#">保存为PDF</a></li>
                            <li><a href="#">导入Excel</a></li>
                        </ul>
                    </div>
                </div>
                <div class="space15"></div>
                   <table class="table table-striped table-hover table-bordered" id="editable-sample">
                <thead>
                <tr>
                    <th class="col-lg-1 col-xs-1">项目ID</th>
                    <th class="col-lg-1 col-xs-1">名称</th>
                    <th class="col-lg-1 col-xs-1">计费方式</th>
                    <th class="col-lg-1 col-xs-1">接入价格</th>
                    <th class="col-lg-1 col-xs-1">备注</th>
                    <th class="col-lg-1 col-xs-1">编辑</th>
                    <th class="col-lg-1 col-xs-1">删除</th>
                </tr>
                </thead>
                <tbody>
	              <c:forEach var="productProject" items="${productProjects}">
						<tr class="">
					        <td>${ productProject.pid}</td>
				       	    <td>${ productProject.pname}</td>
							<td>${ productProject.type}</td>
        					<td>${ productProject.inPrice}</td>	
        					<td><textarea name="remark" rows="1" class="textareaDisEdit" readonly="readonly">${productProject.remark}</textarea> </td>
							<td><a
								href="${pageContext.request.contextPath}/project/goProject/${partner.username}/${partner.type}">编辑</a></td>
							<td><a class="delete" href="#myModal15" role="button" class="btn btn-default" data-toggle="modal">删除</a></td>
					      <div id="myModal15" class="modal" data-easein="bounceRightIn" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					        <form action="${pageContext.request.contextPath}/project/delProductProject/${productProject.partnerName}/${productProject.pid}">
					        <div class="modal-dialog">
					          <div class="modal-content">
					            <div class="modal-header">
					              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					              <h4 class="modal-title">删除</h4>
					            </div>
					            <div class="modal-body">
					              <p>确定这样做吗？</p>
					            </div>
					            <div class="modal-footer">
					              <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
					              <button class="btn btn-primary" type="submit">确定</button>
					            </div>
					          </div>
					        </div>
					      </div>
						</form>
						</tr>
				  </c:forEach>
               
                </tbody>
                </table>
                </div>
                </div>
                </section>
                </div>
                </div>
        </div>
        <!--body wrapper end-->

        <!--footer section start-->
        <footer class="sticky-footer">
			2017 &copy; AdminEx by <a href="#" target="_blank">储世界</a>
        </footer>
        <!--footer section end-->


    </div>
    <!-- main content end-->
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/modernizr.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.nicescroll.js"></script>

<!--common scripts for all pages-->
<script src="${pageContext.request.contextPath}/static/js/scripts.js"></script>

<!--data table-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/data-tables/jquery.dataTables.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/data-tables/DT_bootstrap.js"></script>

<!--script for editable table-->
<script src="${pageContext.request.contextPath}/static/js/editable-table.js"></script>
<!--common scripts for all pages-->
<script src="${pageContext.request.contextPath}/static/js/scripts.js"></script>
<script>
    jQuery(document).ready(function() {
        EditableTable.init();
        
    });
</script>

<!-- velocity 弹出框模块 start -->
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script src='${pageContext.request.contextPath}/static/js/jQueryVelocity/js/velocity.min.js'></script> 
<script src='${pageContext.request.contextPath}/static/js/jQueryVelocity/js/velocity.ui.min.js'></script> 
<script type="text/javascript">
		// add the animation to the popover
		$('a[rel=popover]').popover().click(function(e) {
		  e.preventDefault();
		  var open = $(this).attr('data-easein');
		  if (open == 'shake') {
		    $(this).next().velocity('callout.' + open);
		  } else if (open == 'pulse') {
		    $(this).next().velocity('callout.' + open);
		  } else if (open == 'tada') {
		    $(this).next().velocity('callout.' + open);
		  } else if (open == 'flash') {
		    $(this).next().velocity('callout.' + open);
		  } else if (open == 'bounce') {
		    $(this).next().velocity('callout.' + open);
		  } else if (open == 'swing') {
		    $(this).next().velocity('callout.' + open);
		  } else {
		    $(this).next().velocity('transition.' + open);
		  }

		});

		// add the animation to the modal
		$(".modal").each(function(index) {
		  $(this).on('show.bs.modal', function(e) {
		    var open = $(this).attr('data-easein');
		    if (open == 'shake') {
		      $('.modal-dialog').velocity('callout.' + open);
		    } else if (open == 'pulse') {
		      $('.modal-dialog').velocity('callout.' + open);
		    } else if (open == 'tada') {
		      $('.modal-dialog').velocity('callout.' + open);
		    } else if (open == 'flash') {
		      $('.modal-dialog').velocity('callout.' + open);
		    } else if (open == 'bounce') {
		      $('.modal-dialog').velocity('callout.' + open);
		    } else if (open == 'swing') {
		      $('.modal-dialog').velocity('callout.' + open);
		    } else {
		      $('.modal-dialog').velocity('transition.' + open);
		    }

		  });
		});
	</script>

<!-- velocity 弹出框模块 end -->
</body>
</html>
