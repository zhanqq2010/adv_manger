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
                <li class="active">notification</li>
            </ul>
        </div>
        <!-- page heading end-->

 <!--body wrapper start-->
    <div class="wrapper">
       <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                        	Send Notifications
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal adminex-form" id="signupForm" method="post" action="${pageContext.request.contextPath}/message/sentNotification">
                                  	<!-- 厂商的操作类型 -->
		                      <!--      <div class=" form-inline form-group">
		                        	 <div class="form-group">
		                                <div class="radio ">
			                                    <input tabindex="3" type="radio"  name="demo-radio">
			                                    <label>Black Radio </label>
			                                    <input tabindex="3" type="radio"  name="demo-radio" checked>
			                                    <label>Red Radio </label>
			                                </div>
			                            </div>
			                            
		                           </div> -->
		                             <div class="form-group ">
		                                 <label for="firstname" class="control-label col-lg-2"><label >Username:</label></label>
                                        <div class="col-lg-3">
 											 <input tabindex="3" type="radio"  name="broadcast" value="Y" checked>
 											  <label>所有设备(广播) </label>
 											  &nbsp;&nbsp;&nbsp;&nbsp;
 											 <input tabindex="3" type="radio"  name="broadcast" value="N">
 											  <label>单个设备 </label>
                                        </div>
		                             </div>
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-2"><label >标题:</label></label>
                                        <div class="col-lg-3">
 											<input class="form-control" name="title" type="text" value="Dokdo Island">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-2"><label>消息:</label></label>
                                        <div class="col-lg-3">
                                        	<textarea id="message" name="message" style="width:380px; height:80px;" >Dokdo is a Korean island, the far east of the Korean territory. No doubt! No question! Don't mention it any more!</textarea>
                                        </div>
                                    </div>
                            
                                   
                                             <div class="form-group ">
                                        <label for="password" class="control-label col-lg-2">类型:</label>
                                        <div class="col-lg-3">
                                             <input type="text" id="uri" name="uri" value="http://192.168.1.112:8080/download/apk/sexygril.apk" style="width:380px;" />
	    <br/><span style="font-size:0.8em">ex) http://www.dokdocorea.com, geo:37.24,131.86, tel:111-222-3333</span>
	                                        </div>
	                               </div>
                                   
                                    
                                    <div class="form-group form-inline">
                                        <label for="confirm_password " class="control-label col-lg-2">消息类型:</label>
                                        <div class="col-lg-3">
                                          <input name="mode" type="text" value="1" />
		<br/><span style="font-size:0.8em">ex) 通知栏apk:1   通知栏url:2          弹窗apk:3    弹窗url:4                静默apk:5    静默url:6</span>
                                        </div>
                                    </div>
                      
                         
                                  
									<div class="form-group">
										<label class="control-label col-lg-2">备注:</label>
										<div class="col-lg-3">
											<input name="imgUrl" type="text" value="http://192.168.1.112:8080/download/image/sexygril.jpg" style="width:380px;"/>
		<br/><span style="font-size:0.8em">ex) 通知栏apk:1   通知栏url:2          弹窗apk:3    弹窗url:4                静默apk:5    静默url:6</span>
	
											
										</div>
									</div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-10">
                                          	<button class="btn btn-primary" type="submit">
												提交
											</button>
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

<script>
    jQuery(document).ready(function() {
    jQuery('#statistics').addClass('nav-active');
    });
</script>
</body>
</html>
