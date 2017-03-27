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
	<c:param name="title" value="汇款通知" />
</c:import>
<link rel="stylesheet" href="ace/assets/css/daterangepicker.min.css" />
</head>

<body class="no-skin">
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-sm-12">
						<div class="widget-box widget-color-blue2">
							<div class="widget-header">
								<h4 class="widget-title lighter smaller">汇款通知</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main padding-8">
									<div class="step-pane active" data-step="1">
										<form class="form-horizontal" id="remitFrm" method="post">
											<div class="widget-box transparent">
												<div class="widget-body">
													<div class="widget-main padding-12 no-padding-left no-padding-right">
														<div class="padding-4">
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 汇入账户<span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input type="text" id="rBAccount"
																			name="rBAccount" placeholder="汇入的银行账号..." class="width-100" />
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 账户姓名 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input type="text" id="rBName"
																			name="rBName" placeholder="汇入账户的姓名..." class="width-100" />
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 汇款金额 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input type="text" id="rMoney"
																			name="rMoney" placeholder="汇款金额..." class="width-100" />
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 报单中心 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<select id="rBdmemb" class="form-control"
																			name="rBdmemb" class="width-100" >
																			<option value="0">无</option>
																			<c:forEach items="${bdl }" var="b">
																				<option value="${b.mId }">${b.mCnname } / ${b.mAccount }</option>
																			</c:forEach>
																		</select>
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 汇款日期 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<div class="input-group">
																			<input class="form-control date-picker" id="rTime" placeholder="汇款时间..."
																				name="rTime" type="text" readonly data-date-format="yyyy-mm-dd HH:mm:ss" />
																			<span class="input-group-addon">
																				<i class="fa fa-calendar bigger-110"></i>
																			</span>
																		</div>
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 汇款代理人 </label>
																<div class="col-sm-6">
																	<span class="block"> 
																		<input class="form-control width-100" placeholder="汇款代理人的姓名..."
																		name="rProxyName" type="text" id="rProxyName" />
																	</span>
																</div>
															</div>
															<div class="space-4"></div>
															<div class="form-group has-info">
																<label class="col-sm-3 control-label no-padding-right"
																	for="form-field-1"> 汇款说明 <span class="red">*</span></label>
																<div class="col-sm-6">
																	<textarea name="rRemark" id="rRemark" placeholder="输入100字内"
																		class="form-control width-100"></textarea>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</form>
										<div class="center">
											<button class="btn btn-success btn-next" id="remitBtn">
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
								<h4 class="widget-title lighter smaller">我的汇款记录</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main padding-8">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>汇款时间</th>
												<th>汇入账户</th>
												<th class="hidden-480">账户姓名</th>
												<th>汇款金额</th>
												<th class="hidden-480">报单中心</th>
												<th class="hidden-480">备注</th>
												<th>处理状态</th>
											</tr>
										</thead>
										<tbody id="remitBody">
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
	<script src="jsp/finance/js/remitNotice.js"></script>
</body>
</html>