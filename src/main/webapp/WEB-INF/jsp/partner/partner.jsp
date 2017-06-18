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
                <li class="active">${typeDescription}</li>
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
                       <a href="${pageContext.request.contextPath}/partner/goAddPartner/${type}"
						class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i>
						添加${typeDescription} </a> 
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
                    <th class="col-lg-1 col-xs-1">名称</th>
                    <th class="col-lg-1 col-xs-1">登录名</th>
                    <th class="col-lg-7 col-xs-7">备注</th>
                    <th class="col-lg-1 col-xs-1">编辑</th>
                    <th class="col-lg-1 col-xs-1">项目管理</th>
                    <th class="col-lg-1 col-xs-1">删除</th>
                </tr>
                </thead>
                <tbody>
	              <c:forEach var="partner" items="${partners}">
						<tr class="">
							<td >${partner.nickname}</td>
							<td >${partner.username}</td>
							<td >${partner.remark}</td>
							<td ><a
								href="${pageContext.request.contextPath}/partner/goEditPartner/${partner.username}">编辑</a>
								 </td>
							<td><a
								href="${pageContext.request.contextPath}/project/goProject/${partner.username}/${partner.type}">项目管理</a></td>
							<td><a
								href="${pageContext.request.contextPath}/partner/delPartner/${partner.username}/${partner.type}">删除</a></td>
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

<script>
    jQuery(document).ready(function() {
    jQuery('#partner').addClass('nav-active');
        EditableTable.init();
    });
</script>
</body>
</html>
