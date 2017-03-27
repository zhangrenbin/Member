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
	<c:param name="title" value="报单申请" />
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
								<h4 class="widget-title lighter smaller">报单申请</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main padding-8">
									<div class="step-pane active" data-step="1">
										<form class="form-horizontal" id="bdFrm" method="post">
											<div class="widget-box transparent">
												<div class="widget-header">
													<h3 class="widget-title lighter">申请报单</h3>
													<div class="widget-toolbar no-border">
														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>
													</div>
												</div>
												<div class="widget-body">
													<div class="widget-main padding-12 no-padding-left no-padding-right">
														<div class="padding-4">
															<c:if test="${empty bd || bd.bState < 0}">
																<div class="form-group has-info">
																	<label class="col-sm-3 control-label no-padding-right"
																		for="form-field-1"> 备注<span class="red">*</span></label>
																	<div class="col-sm-6">
																		<span class="block"> 
																			<textarea class="form-control" name="bRemark" id="bRemark" placeholder="100字以内..." class="width-100" ></textarea>
																		</span>
																	</div>
																</div>
																<div class="space-4"></div>
																<div class="form-group has-info">
																	<label class="col-sm-3 control-label no-padding-right"
																		for="form-field-1"> <span class="red">注意: </span></label>
																	<div class="col-sm-6">
																		<span class="block"> 
																			<label class="red control-label">申请报单，请确保你满足报单条件！</label>
																		</span>
																	</div>
																</div>
															</c:if>
															<c:if test="${!empty bd && bd.bState == 0}">
																<div class="form-group has-info">
																	<h1 class="center">
																		您已经提交报单申请，你耐心等待管理员审批！
																	</h1>
																</div>
															</c:if>
															<c:if test="${!empty bd && bd.bState > 0}">
																<div class="form-group has-info">
																	<h1 class="center">
																		恭喜！您的报单申请已经审批通过
																	</h1>
																</div>
															</c:if>
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>
									<c:if test="${empty bd || bd.bState < 0}">
										<hr>
										<div class="wizard-actions">
											<button class="btn btn-success btn-next" id="applyBtn">
												提交申请
												<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
											</button>
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
	<script src="jsp/bd/js/bdApply.js"></script>
</body>
</html>