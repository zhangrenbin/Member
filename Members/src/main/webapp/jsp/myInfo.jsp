<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/authtaglib" prefix="a"%>
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
	<c:param name="title" value="会员信息" />
</c:import>
<link rel="stylesheet" href="ace/assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="ace/assets/css/datepicker.min.css" />
<link rel="stylesheet" href="css/my.css" />
<script type="text/javascript">
	var provid = '${m.mProvince}';
	var cityid = '${m.mCity}';
</script>
</head>

<body class="no-skin">
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="page-header">
					<div class="clearfix">
						<div class="pull-left">
							<h1>${m.mCnname }</h1>
						</div>
						<div class="pull-right">
							<div id="beforeEdit">
								<button type="reset" class="btn btn-label btn-sm" onclick="backToList()">
									<span class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></span>
									返回
								</button>
								&nbsp;&nbsp;
								<a:auth funccode="memb_edit">
									<button type="button" class="btn btn-info btn-sm" onclick="toModMode()">
										<span class="ace-icon fa fa-edit icon-on-right bigger-110"></span>
										编辑
									</button>
								</a:auth>
							</div>
							<div id="afterEdit" style="display: none">
								<button type="reset" class="btn btn-label btn-sm" onclick="cancleEdit()">
									<span class="ace-icon fa fa-undo icon-on-right bigger-110"></span>
									取消
								</button>
								&nbsp;&nbsp;
								<button type="button" class="btn btn-primary btn-sm" onclick="modMemb()">
									<span class="ace-icon fa fa-check icon-on-right bigger-110"></span>
									保存
								</button>
							</div>
						</div>
					</div>
				</div>
				<form class="form-horizontal" id="infoFrm" method="post" action="main/editMyInfo.do">
					<input type="hidden" id="id" name="id" value="${m.id }">
					<div class="row">
						<div class="col-md-12 widget-container-col">
							<div class="widget-box transparent">
								<div class="widget-header widget-header-small">
									<h4 class="widget-title lighter smaller">
										<i class="ace-icon fa fa-book"></i>基本信息
									</h4>
									<div class="widget-toolbar no-border">
										<a href="#" data-action="collapse">
											<i class="ace-icon fa fa-chevron-up"></i>
										</a>
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main padding-6 no-padding-left no-padding-right">
										<div class="clearfix">
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">会员账号</div>
											    	<label class=" form-control" id="l_mAccount">${m.mAccount } </label>
											    	<input type="hidden" id="mAccount" name="userAccount" value="${m.mAccount }">
											    </div>
											</div>
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">会员姓名</div>
											    	<label class=" form-control" id="l_mCnname" mycontrol>${m.mCnname} </label>
											    	<input mycontrol type="text" id="mCnname" name="mCnname" 
														class="form-control" style="display: none" value="${m.mCnname}">
											    </div>
											</div>
										</div>
										<div class="clearfix">
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">身份证号</div>
											    	<label class="form-control" id="l_mIdnum" mycontrol>
														${m.mIdnum } 
													</label>
													<input mycontrol type="text" id="mIdnum" name="mIdnum" 
														class="form-control" style="display: none" value="${m.mIdnum}">
											    </div>
											</div>
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">手机号</div>
													<label class="form-control" id="l_mMobile" mycontrol> 
														${m.mMobile } 
													</label>
													<input mycontrol type="text" id="mMobile" name="mMobile" 
														class="form-control" style="display: none" value="${m.mMobile}">
											    </div>
											</div>
										</div>
										<div class="clearfix">
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">推荐人</div>
											    	<label class="form-control" id="l_mRecommderName">
														${m.mRecommderName } 
													</label>
											    </div>
											</div>
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">注册日期</div>
													<label class="form-control" id="l_mMobile"> 
														<fmt:formatDate value="${m.mRegdate }" pattern="yyyy-MM-dd HH:mm:ss"/>
													</label>
											    </div>
											</div>
										</div>
										<div class="clearfix">
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">激活状态</div>
											    	<label class="form-control" id="l_mActive">
														<c:if test="${empty m.mActive || m.mActive < 1}">
															<span class="red">未激活</span>
														</c:if>
														<c:if test="${!empty m.mActive && m.mActive > 0}">
															<span class="green">已激活</span>
														</c:if>
													</label>
											    </div>
											</div>
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">激活日期</div>
													<label class="form-control" id="l_activeDate"> 
														<fmt:formatDate value="${m.mActivedate }" pattern="yyyy-MM-dd HH:mm:ss"/>
													</label>
											    </div>
											</div>
										</div>
										<div class="clearfix">
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">奖金总额</div>
											    	<label class="form-control" id="l_mActive">
														${empty m.mTotal ? '--':m.mTotal}
													</label>
											    </div>
											</div>
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">奖金余额</div>
													<label class="form-control" id="l_activeDate"> 
														${empty m.mBalance ? '--':m.mTotal}
													</label>
											    </div>
											</div>
										</div>
										<div class="clearfix">
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">省份</div>
											    	<label class="form-control" id="l_mProvince" mycontrol>
														${m.extendPro.provinceName } 
													</label>
													<div mycontrol style="display: none">
														<select class="form-control" data-placeholder="选择省份..."
														 	name="mProvince" id="mProvince" onchange="loadCity(this.value)">
														</select>
													</div>
											    </div>
											</div>
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">城市</div>
													<label class="form-control" id="l_mCity" mycontrol>
														${m.extendPro.cityName}
													</label>
													<div mycontrol style="display: none">
														<select class="form-control" data-placeholder="选择城市..."
														 	name="mCity" id="mCity">
														</select>
													</div>
											    </div>
											</div>
										</div>
										<div class="clearfix">
											<div class="form-group has-info col-sm-12">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">收货地址</div>
											    	<label class="form-control" id="l_mAddr" mycontrol>
														${m.mAddr }
													</label>
													<input mycontrol type="text" id="mAddr" name="mAddr" 
														class="form-control" style="display: none" value="${m.mAddr}">
											    </div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12 widget-container-col">
							<div class="widget-box transparent">
								<div class="widget-header widget-header-small">
									<h4 class="widget-title lighter smaller">
										<i class="ace-icon fa fa-cubes"></i>高级
									</h4>
									<div class="widget-toolbar no-border">
										<a href="#" data-action="collapse">
											<i class="ace-icon fa fa-chevron-up"></i>
										</a>
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main padding-6 no-padding-left no-padding-right">
										<div class="clearfix">
											<div class="form-group has-info col-sm-12">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">开户银行</div>
													<label class="form-control" id="l_depts" mycontrol>
														${m.mBank }
													</label>
													<input mycontrol style="display: none" type="text" class="form-control width-100" placeholder="办公电话..."
													 	name="mBank" id="mBank" value="${m.mBank }">
											    </div>
											</div>
										</div>
										<div class="clearfix">
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">银行账户</div>
													<label class="form-control" id="l_mBAccount" mycontrol>
														${m.mBAccount }
													</label>
													<input mycontrol style="display: none" type="text" class="form-control width-100" placeholder="银行账户..."
													 	name="mBAccount" id="mBAccount" value="${m.mBAccount }">
											    </div>
											</div>
											<div class="form-group has-info col-sm-6">
												<div class="input-group col-sm-10 col-xs-12">
											    	<div class="input-group-addon" style="width: 150px">账号姓名</div>
													<label class="form-control" id="l_mBName" mycontrol>
														${m.mBName }
													</label>
													<input mycontrol style="display: none" type="text" class="form-control width-100" placeholder="账户姓名..."
													 	name="mBName" id="mBName" value="${m.mBName }">
											    </div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
	<!--[if lte IE 8]>
		  <script src="ace/assets/js/excanvas.min.js"></script>
		<![endif]-->
	<c:import url="/jsp/fragment/basebottom_sub.jsp"></c:import>
	<script src="ace/assets/js/jquery.autosize.min.js"></script>
	<script src="js/ajaxfileupload.js"></script>
	<script src="ace/assets/js/bootstrap-datepicker.min.js"></script>
	<script src="ace/assets/js/moment.min.js"></script>
	<script src="ace/assets/js/bootstrap-datepicker.zh-CN.min.js"></script>
	<script type="text/javascript" src="jsp/member/js/membDetail.js"></script>
</body>
</html>