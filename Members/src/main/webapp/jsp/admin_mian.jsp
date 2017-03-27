<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN" style="background-color: white">
<head>
<c:import url="/jsp/fragment/baseheader_sub.jsp">
	<c:param name="title" value="管理员首页" />
</c:import>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" href="ace/assets/css/jquery-ui.min.css" />
<script type="text/javascript">
	var basePath = '<%=basePath%>'
</script>
</head>

<body class="no-skin" style="background-color: white">
	<div class="main-content">
		<div class="main-content-inner">
			<div id="user-profile-2" class="user-profile">
				<div class="tabbable">
					<div class="tab-content no-border padding-28">
						<div id="home" class="">
							<div class="row">
								<div class="col-xs-12 col-sm-4 center">
									<span class="profile-picture"> <img width="180" height="200"
										class="editable img-responsive" alt="${m.mCnname }"
										id="avatar2" src="img/timg.jpg" />
									</span>
									<div class="space space-4"></div>
									<div>
										<a href="javascript:editInfo()" class="btn btn-sm  btn-success"> <i
											class="ace-icon fa fa-edit bigger-120"></i> <span
											class="bigger-110">编辑资料</span>
										</a> <a href="javascript:editPwd('${m.mAccount }')" class="btn btn-sm  btn-primary"> <i
											class="ace-icon fa fa-shield bigger-110"></i> <span
											class="bigger-110">修改密码</span>
										</a>
									</div>
									<div class="hr hr-8 dotted"></div>
									<div class="profile-user-info">
										<div class="profile-info-row">
											<div class="profile-info-name">账号</div>
											<div class="profile-info-value">
												<span>${m.mAccount }</span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">姓名</div>
											<div class="profile-info-value">
												<span>${m.mCnname }</span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">上次登录时间</div>
											<div class="profile-info-value">
												<span>
													<fmt:formatDate value="${m.extendPro.lastLoginTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
												</span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">会员总数/激活数</div>
											<div class="profile-info-value">
												<span>${m.extendPro.total}/${m.extendPro.activeNum}</span>&nbsp;个
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">今日新会员数</div>
											<div class="profile-info-value">
												<span>${m.extendPro.todayNum}</span>个
											</div>
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-8">
									<div class="widget-box transparent">
										<div class="widget-header widget-header-small">
											<h4 class="widget-title smaller">
												<i class="ace-icon fa fa-user bigger-110"></i>
												最新会员
											</h4>
										</div>
										<div class="widget-body">
											<div class="widget-main">
												<table class="table ">	
													<thead>
														<tr>
															<th>账号</th>
															<th>姓名</th>
															<th>会员状态</th>
															<th class="hidden-480">推荐人</th>
															<th class="hidden-480">推荐时间</th>
														</tr>
													</thead>
													<tbody id="recnetMembs">
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<div class="widget-box transparent">
										<div class="widget-header widget-header-small">
											<h4 class="widget-title smaller">
												<i class="ace-icon fa fa-money bigger-110"></i>
												最近汇款通知
											</h4>
										</div>
										<div class="widget-body">
											<div class="widget-main">
												<table class="table">	
													<thead>
														<tr>
															<th class="hidden-480">会员账号</th>
															<th>会员姓名</th>
															<th>汇款金额</th>
															<th>汇款账户</th>
															<th class="hidden-480">汇款时间</th>
															<th class="hidden-480">汇款说明</th>
														</tr>
													</thead>
													<tbody id="recentRemits">
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<div class="widget-box transparent">
										<div class="widget-header widget-header-small">
											<h4 class="widget-title smaller">
												<i class="ace-icon fa fa-bell bigger-110"></i>
												最新公告
											</h4>
										</div>
										<div class="widget-body">
											<div class="widget-main">
												<table class="table">	
													<tbody>
														
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modPassDlg" tabindex="-1" role="dialog" 
	   aria-labelledby="myModalLabel_pass" aria-hidden="true">
	   <div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	            </button>
	            <h4 class="modal-title" id="myModalLabel_pass">
	               	修改密码
	            </h4>
	         </div>
	         <div class="modal-body">
	            <form class="form-horizontal" id="modPassForm">
					<div class="form-group has-info">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> 用户账号 </label>
						<div class="col-sm-6">
							<span class="block">
								<label class="control-label" id="accountlabel"></label>
							</span>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="form-group has-info">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> 原密码<span class="text-danger">*</span> </label>
						<div class="col-sm-6">
							<span class="block">
								<input type="password" id="oldPassword" name="oldPassword"
									placeholder="原密码..." class="width-100"/>
							</span>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="form-group has-info">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> 新密码<span class="text-danger">*</span> </label>
						<div class="col-sm-6">
							<span class="block">
								<input type="password" id="userPassword" name="userPassword"
									placeholder="新密码..." class="width-100"/>
							</span>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="form-group has-info">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> 确认密码 </label>
						<div class="col-sm-6">
							<span class="block">
								<input type="password" id="userPassword2" name="userPassword2"
									placeholder="确认密码..." class="width-100"/>
							</span>
						</div>
					</div>
				</form>
	         </div>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-primary" onclick="modPass()">
	               	确定
	            </button>
	            <button type="button" class="btn btn-default" 
	               data-dismiss="modal">关闭
	            </button>
	         </div>
	      </div>
		</div>
	</div>
	<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
	<!--[if lte IE 8]>
		  <script src="ace/assets/js/excanvas.min.js"></script>
		<![endif]-->
	<c:import url="/jsp/fragment/basebottom_sub.jsp"></c:import>
	<script src="ace/assets/js/jquery.autosize.min.js"></script>
	<script type="text/javascript" src="js/jqPaginator.min.js"></script>
	<script type="text/javascript" src="jsp/js/admin_main.js"></script>
</body>
</html>