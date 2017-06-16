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
  <link href="${pageContext.request.contextPath}/static/css/jquery.stepy.css" rel="stylesheet">
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
        <div class="page-heading">
            <h3>
            	   广告管理平台
            </h3>
            <ul class="breadcrumb">
                <li>
                    <a href="#">首页</a>
                </li>
                <li class="active">添加广告厂商项目</li>
            </ul>
        </div>
        <!-- page heading end-->

 <!--body wrapper start-->
    <div class="wrapper">
       <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                        	  添加广告厂商项目
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal adminex-form" id="signupForm" method="post" action="${pageContext.request.contextPath}/project/createProductProject/${partnerName}">
                                  	<!-- 厂商的操作类型 -->
                        
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-2"><label >项目id:</label></label>
                                        <div class="col-lg-3">
 											<input class="form-control"  type="text" placeholder="${pid}" disabled>
                                        	<input name="pid" value="${pid}" type="hidden">
                                        </div>
                                    </div>
                                        	<input name="partnerName" value="${partnerName}" type="hidden">
                                    
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2"><label>项目名称:</label></label>
                                        <div class="col-lg-3">
                                            <input class=" form-control" id="pname" name="pname" type="text"" required />
                                        </div>
                                    </div>
                            
                                   
                                             <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">类型:</label>
                                        <div class="col-lg-3">
                                             <select class="form-control m-bot15" name="type">
				                                <option value="1">CPC(按点击量)</option>
				                                <option value="2">CPA(按激活量)</option>
				                                <option value="3">CPS(按安装量)</option>
				                            </select>
	                                        </div>
	                               </div>
                                   
                                    
                                    <div class="form-group form-inline">
                                        <label for="confirm_password " class="control-label col-lg-2">接入价格:</label>
                                        <div class="col-lg-3">
                                           <input class="form-control col-lg-2" id="inprice" name="inPrice" type="text" required />
                                          <select class="form-control col-lg-1" name="moneyType">
				                                <option value="1">元</option>
				                                <option value="2">美元</option>
				                            </select>
                                         
                                          
                                        </div>
                                    </div>
                      
                         
                                  
									<div class="form-group">
										<label class="control-label col-lg-2">备注:</label>
										<div class="col-lg-3">
											<textarea name="remark" rows="3" class="form-control" ></textarea>
											
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

</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.stepy.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/modernizr.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.nicescroll.js"></script>


<!--common scripts for all pages-->
<script src="${pageContext.request.contextPath}/static/js/scripts.js"></script>

<script>
    /*=====STEPY WIZARD====*/
    $(function() {
        $('#default').stepy({
            backLabel: 'Previous',
            block: true,
            nextLabel: 'Next',
            titleClick: true,
            titleTarget: '.stepy-tab'
        });
    });
    /*=====STEPY WIZARD WITH VALIDATION====*/
    $(function() {
        $('#stepy_form').stepy({
            backLabel: 'Back',
            nextLabel: 'Next',
            errorImage: true,
            block: true,
            description: true,
            legend: false,
            titleClick: true,
            titleTarget: '#top_tabby',
            validate: true
        });
        $('#stepy_form').validate({
            errorPlacement: function(error, element) {
                $('#stepy_form div.stepy-error').append(error);
            },
            rules: {
                'name': 'required',
                'email': 'required'
            },
            messages: {
                'name': {
                    required: 'Name field is required!'
                },
                'email': {
                    required: 'Email field is requerid!'
                }
            }
        });
    });
</script>


</body>
</html>
