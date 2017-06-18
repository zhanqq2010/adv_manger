<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>   
    <!-- left side start-->
    <div class="left-side sticky-left-side">

        <!--logo and iconic logo start-->
        <div class="logo">
            <a href="${pageContext.request.contextPath}/home.jsp"><img src="${pageContext.request.contextPath}/static/images/logo.png" alt=""></a>
        </div>

        <div class="logo-icon text-center">
            <a href="${pageContext.request.contextPath}/home.jsp"><img src="${pageContext.request.contextPath}/static/images/logo_icon.png" alt=""></a>
        </div>
        <!--logo and iconic logo end-->


        <div class="left-side-inner">

            <!-- visible to small devices only -->
            <div class="visible-xs hidden-sm hidden-md hidden-lg">
                <div class="media logged-user">
                    <img alt="" src="${pageContext.request.contextPath}/static/images/photos/user-avatar.png" class="media-object">
                    <div class="media-body">
                        <h4><a href="#">John Doe</a></h4>
                        <span>"Hello There..."</span>
                    </div>
                </div>

                <h5 class="left-nav-title">Account Information</h5>
                <ul class="nav nav-pills nav-stacked custom-nav">
              
                    <li><a href="#"><i class="fa fa-sign-out"></i> <span>注销</span></a></li>
                </ul>
            </div>

            <!--sidebar nav start-->
            <ul class="nav nav-pills nav-stacked custom-nav">
                <li><a href="${pageContext.request.contextPath}/home.jsp"><i class="fa fa-home"></i> <span>主页</span></a></li>
                <li class="menu-list" id="partner"> <a href=""><i class="fa fa-user"></i> <span>合作方管理</span></a>
                    <ul class="sub-menu-list">
                        <li><a href="${pageContext.request.contextPath}/partner/queryPartnerByType/2"> 广告厂商</a></li>
                        <li><a href="${pageContext.request.contextPath}/partner/queryPartnerByType/1"> 手机渠道商</a></li>
                        <li><a href="horizontal_menu.html"> 手机渠道商数据录入</a></li>
						<li><a href="horizontal_menu.html"> 渠道更新设置</a></li>
						<li><a href="horizontal_menu.html"> 操作日志</a></li>
                    </ul>
                </li>
                <li class="menu-list " id="advManager"><a href=""><i class="fa fa-book"></i> <span>广告事件管理</span></a>
                    <ul class="sub-menu-list">
                        <li><a href="${pageContext.request.contextPath}/project/goAdvProject">广告管理</a></li>
                        <li><a href="buttons.html"> 广告事件管理</a></li>
                        <li><a href="tabs-accordions.html"> 推送设置管理</a></li>
                        <li><a href="typography.html"> 广告墙</a></li>
                        <li><a href="slider.html"> API对接</a></li>
                    </ul>
                </li>
                <li class="menu-list"><a href=""><i class="fa fa-eye"></i> <span>用户行为分析</span></a>
                    <ul class="sub-menu-list">
                        <li><a href="grids.html"> Grids</a></li>
                        <li><a href="gallery.html"> Media Gallery</a></li>
                        <li><a href="calendar.html"> Calendar</a></li>
                        <li><a href="tree_view.html"> Tree View</a></li>
                        <li><a href="nestable.html"> Nestable</a></li>

                    </ul>
                </li>

                <li class="menu-list"><a href=""><i class="fa fa-bar-chart-o"></i> <span>广告统计分析</span></a>
                    <ul class="sub-menu-list">
                        <li><a href="mail.html"> Inbox</a></li>
                        <li><a href="mail_compose.html"> Compose Mail</a></li>
                        <li><a href="mail_view.html"> View Mail</a></li>
                    </ul>
                </li>

            </ul>
            <!--sidebar nav end-->

        </div>
    </div>
    <!-- left side end-->
    
    


