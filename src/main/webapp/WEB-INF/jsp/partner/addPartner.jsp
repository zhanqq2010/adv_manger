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
     <!--    <div class="page-heading">
          		  广告厂商
        </div> -->
        <!-- page heading end-->

        <!--body wrapper start-->
    <div class="wrapper">
       <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                        	  <c:if test="${option == 'edit' } ">编辑</c:if>
                        	  <c:if test="${option == 'add' }">添加</c:if>
                        	  ${typeDescription}
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal adminex-form" id="signupForm" method="post" action="${pageContext.request.contextPath}/partner/dealPartnerOpt">
                                  
                                  	<input name="option" value="${option}" type="hidden">
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-2"><label >厂商类型:</label></label>
                                        <div class="col-lg-3">
 											<input class="form-control" id="disabledInput"  type="text" placeholder="${typeDescription}" disabled>
                                        	<input name="type" value="${type}" type="hidden">
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2"><label>名称:</label></label>
                                        <div class="col-lg-3">
                                            <input class=" form-control" id="nickname" name="nickname" type="text" value="${partner.nickname }" />
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="username" class="control-label col-lg-2">厂商标识(用户名):</label>
                                        <div class="col-lg-3">
                                            <input class="form-control"  name="username"  type="text"  value="${partner.username }" <c:if test="${option == 'edit' }">disabled</c:if> />
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">数据同步地址:</label>
                                        <div class="col-lg-3">
                                            <input class="form-control " id="datasyncaddress" name="datasyncaddress" type="text" value="${partner.datasyncaddress }" />
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="confirm_password" class="control-label col-lg-2">地址:</label>
                                        <div class="col-lg-3">
                                            <input class="form-control " id="address" name="address" type="text" value="${partner.address }" />
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="confirm_password" class="control-label col-lg-2">电话:</label>
                                        <div class="col-lg-3">
                                            <input class="form-control " id="phoneNo" name="phoneNo" type="text" value="${partner.phoneNo }" />
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="confirm_password" class="control-label col-lg-2">QQ:</label>
                                        <div class="col-lg-3">
                                            <input class="form-control " id="qqNo" name="qqNo" type="text" value="${partner.qqNo }" />
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="email" class="control-label col-lg-2">Email</label>
                                        <div class="col-lg-3">
                                            <input class="form-control " id="email" name="email" type="email" value="${partner.email }" />
                                        </div>
                                    </div>
									<div class="form-group">
										<label class="control-label col-lg-2">备注:</label>
										<div class="col-lg-3">
											<textarea name="remark" rows="3" class="form-control" >${partner.remark }</textarea>
										</div>
									</div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-10">
                                          	<button class="btn btn-primary" type="submit">
												提交
											</button>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a class="btn btn-default" href="${pageContext.request.contextPath}/partner/queryPartnerByType/2" type="button">取消</a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </section>
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
</body>
</html>
