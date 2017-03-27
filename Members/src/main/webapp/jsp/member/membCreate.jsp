<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN" style="background-color: white">
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" href="ace/assets/css/chosen.min.css" />
<c:import url="/jsp/fragment/baseheader_sub.jsp">
	<c:param name="title" value="推荐会员" />
</c:import>
<link rel="stylesheet" href="ace/assets/css/datepicker.min.css" />
</head>

<body class="no-skin">
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="" style="padding:0 10px">
						<div class="widget-box widget-color-blue2">
							<div class="widget-header">
								<h4 class="widget-title lighter smaller">推荐会员</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main padding-8">
									<div class="step-pane active" data-step="1">
										<form class="form-horizontal" id="memFrm" method="post">
											<div class="widget-box transparent">
												<div class="widget-header">
													<h3 class="widget-title lighter">基本信息</h3>
													<div class="widget-toolbar no-border">
														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>
													</div>
												</div>
												<div class="widget-body">
													<div class="widget-main padding-12 no-padding-left no-padding-right">
														<div class="padding-4">
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 账号<span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input type="text" id="mAccount"
																			name="mAccount" placeholder="会员账号..." class="width-100" />
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 姓名 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input type="text" id="mCnname"
																			name="mCnname" placeholder="会员的姓名..." class="width-100" />
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 身份证号 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input type="text" id="mIdnum"
																			name="mIdnum" placeholder="会员的18位身份证号..." class="width-100" />
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 手机号 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input class="form-control width-100" placeholder="会员的联系手机号..."
																		name="mMobile" type="text" id="mMobile" />
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 省份 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<select class="form-control chosen-select " name="mProvince"
																			id="mProvince" onchange="loadCity(this.value)">
																		</select>
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 城市 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<select class="form-control chosen-select " name="mCity"
																			id="mCity">
																		</select>
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 收货地址 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input type="text" id="mAddr"
																			name="mAddr" placeholder="会员的详情地址..." class="width-100" />
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> <span class="red">注意: </span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<label class="red control-label">会员初始化密码未123456aA,请登录后修改密码！</label>
																	</span>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="widget-box transparent">
												<div class="widget-header">
													<h3 class="widget-title lighter">高级</h3>
													<div class="widget-toolbar no-border">
														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>
													</div>
												</div>
												<div class="widget-body">
													<div class="widget-main padding-12 no-padding-left no-padding-right">
														<div class="padding-4">
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 开户银行(具体到支行) <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input class="form-control width-100" name="mBank" placeholder="会员的银行卡的开户银行..."
																		 type="text" id="mBank" />
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 银行账户 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input class="form-control width-100" name="mBAccount" placeholder="会员的银行卡的开户银行..."
																		 type="text" id="mBAccount" />
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 开户姓名 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input name="mBName" id="mBName" placeholder="开户姓名..."
																			type="text" class="form-control width-100">
																	</span>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>
									<c:if test="${!empty mymember.mActive && mymember.mActive > 0}">
										<hr>
										<div class="wizard-actions">
											<button class="btn btn-success btn-next" id="createBtn">
												创建会员
												<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
											</button>
										</div>
									</c:if>
									<c:if test="${empty mymember.mActive || mymember.mActive < 1}">
										<hr>
										<div class="wizard-actions">
											<span class="red">您的账号尚未被激活，不能添加会员</span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<iframe name='hidden_frame' id="hidden_frame" style='display:none'>
		<form id="photoFrm">
			<input>
		</form>
	</iframe>
	<!--[if lte IE 8]>
		  <script src="ace/assets/js/excanvas.min.js"></script>
		<![endif]-->
	<script src="ace/assets/js/fuelux.wizard.min.js"></script>
	<script src="ace/assets/js/jquery.autosize.min.js"></script>
	<script src="ace/assets/js/bootstrap-datepicker.min.js"></script>
	<script src="ace/assets/js/moment.min.js"></script>
	<script src="ace/assets/js/bootstrap-datepicker.zh-CN.min.js"></script>
	<c:import url="/jsp/fragment/basebottom_sub.jsp"></c:import>
	<script src="js/ajaxfileupload.js"></script>
	<script src="ace/assets/js/chosen.jquery.min.js"></script>
	<script src="jsp/member/js/createMemb.js"></script>
</body>
</html>