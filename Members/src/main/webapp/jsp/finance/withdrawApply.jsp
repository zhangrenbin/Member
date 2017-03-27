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
	<c:param name="title" value="提现申请" />
</c:import>
<link rel="stylesheet" href="ace/assets/css/daterangepicker.min.css" />
<script type="text/javascript">
	var valid = ${m.mBalance - lock };
</script>
</head>

<body class="no-skin">
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="" style="padding:0 10px">
						<div class="widget-box widget-color-blue2">
							<div class="widget-header">
								<h4 class="widget-title lighter smaller">提现申请</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main padding-8">
									<div class="step-pane active" data-step="1">
										<form class="form-horizontal" id="withDrawFrm" method="post">
											<div class="widget-box transparent">
												<div class="widget-body">
													<div class="widget-main padding-12 no-padding-left no-padding-right">
														<div class="padding-4">
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 姓名<span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<label class="control-label">${m.mCnname }</label>
																	</span>
																</div>
															</div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 我的余额<span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<label class="control-label">
																			<span>可用：<span id="valid">${m.mBalance - lock }</span>元</span>
																			&nbsp;&nbsp;&nbsp;&nbsp;
																			<span class="red">锁定：<span id="lock">${lock }</span>元</span>
																		</label>
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 提现金额 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input type="text" id="txMoney"
																			name="txMoney" placeholder="提现金额，不能大于余额..." class="width-100" />
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> <span class="red">注意: </span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<label class="red control-label">最小提现额度：100元！并且支持整百提取</label>
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 提现账户 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input type="text" id="txBAccount"
																			name="txBAccount" placeholder="提现的银行账户..." class="width-100" value="${m.mBAccount }"/>
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 账户姓名 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input type="text" id="txBName"
																			name="txBName" placeholder="账号姓名..." class="width-100" value="${m.mBName }"/>
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 开户银行 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input type="text" id="txBank"
																			name="txBank" placeholder="具体到支行..." class="width-100" value="${m.mBank }"/>
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 备注 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<textarea name="txRemark" id="txRemark" placeholder="输入100字内"
																		class="form-control width-100"></textarea>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</form>
										<div class="center">
											<button class="btn btn-success btn-next" id="withDrawBtn">
												提交
												<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="widget-box widget-color-blue2">
							<div class="widget-header">
								<h4 class="widget-title lighter smaller">我的提现记录</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main padding-8">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th class="hidden-480">提现时间</th>
												<th>提现金额</th>
												<th>银行账户</th>
												<th class="hidden-480">账号姓名</th>
												<th>处理状态</th>
												<th>处理意见</th>
											</tr>
										</thead>
										<tbody id="withDrawBody">
										</tbody>
									</table>
									<div class="clearfix" id="pagetool">
										<br>
										<div class="pull-right">
											<ul style="margin: 0" class="pagination" id="pagination1"></ul>
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
	<script src="ace/assets/js/moment.min.js"></script>
	<script src="ace/assets/js/daterangepicker.min.js"></script>
	<c:import url="/jsp/fragment/basebottom_sub.jsp"></c:import>
	<script src="js/ajaxfileupload.js"></script>
	<script src="jsp/finance/js/withdrawApply.js"></script>
</body>
</html>