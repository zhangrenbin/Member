<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="navbar" class="navbar navbar-default">
	<script type="text/javascript">
		try{ace.settings.check('navbar' , 'fixed')}catch(e){}
	</script>
	<div class="navbar-container" id="navbar-container">
		<button type="button" class="navbar-toggle menu-toggler pull-left" style="height:50px;width: 50px; margin: 10px 10px"
			id="menu-toggler" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>

		<div class="navbar-header pull-left" style="height:70px; line-height: 70px">
			<h2 class="white" style="padding-left: 20px"> 
				<i class="fa fa-lock"></i> 会员管理系统
			</h2>
		</div>

		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="light-blue" style="height:70px; line-height: 70px">
					<a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> 
						<img class="nav-user-photo" style="max-width:60px; width: 60px;height: 60px" 
							src="${empty userinfo.photo ? 'ace/assets/avatars/avatar5.png' : userinfo.photo }">
						<span class="user-info"> 
							<h4>欢迎,
								<br>
								<span id="userName">
									${userinfo.name }
								</span>
							</h4>
						</span>
						<i class="ace-icon fa fa-caret-down"></i>
					</a>
					<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li><a href="main/myInfo.do" target="iframepage"> <i
								class="ace-icon fa fa-user"></i> 我的信息
						</a></li>
						<li class="divider"></li>
						<li><a href="logout.do"> <i class="ace-icon fa fa-power-off"></i>
								注销
						</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	<!-- /.navbar-container -->
</div>