<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/authtaglib" prefix="a"%>
<!DOCTYPE html>
<html lang="zh-CN" style="background-color: white">
<head>
<c:import url="/jsp/fragment/baseheader_sub.jsp">
	<c:param name="title" value="会员列表" />
</c:import>
<link rel="stylesheet" href="ace/assets/css/jquery-ui.min.css" />
</head>

<body class="no-skin">
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="page-header">
					<div class="row clearfix">
						<div class="col-xs-12 col-sm-6 col-md-4 pull-left">
							<h1>推荐关系图</h1>
						</div>
						<c:if test="${!empty god }">
							<div class="col-xs-12 col-sm-6 col-md-4 pull-right">
								<form class="form-search form-inline" id="searchFrm" action="memb/f_recomm_tree.do">
									<div class="pull-right">
										<div class="input-group">
											<span class="input-group-addon">
												姓名或账号
											</span>
											<input type="text" name="payload" class="form-control search-query" placeholder="输入用户姓名或账号..." />
											<span class="input-group-btn">
						                        <button class="btn btn-info btn-sm" type="button" onclick="doSubmit()">
													<span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
														查询
												</button>
						                    </span>
										</div>
									</div>
								</form>
							</div>
						</c:if>
					</div>
				</div>
				<div class="row" id="multiArea" style="padding: 10px 10px">
					<span>快捷选择：</span>
					<div class="btn-group">
						<c:forEach var="m" items="${l }" varStatus="st">
							<button type="button" class="memb btn btn-white btn-sm btn-primary" data-val="${m.id }">${m.mCnname }</button>
						</c:forEach>
					</div>
				</div>
				<hr>
				<div class="row" id="recommTree" style="overflow:auto; padding: 0px 10px;width: 100%;height:500px">
					
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="resetPassDlg" tabindex="-1" role="dialog" 
	   aria-labelledby="myModalLabel" aria-hidden="true">
	   <div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	            </button>
	            <h4 class="modal-title" id="myModalLabel">
	               	重置密码
	            </h4>
	         </div>
	         <div class="modal-body">
	            <form class="form-horizontal" id="resetPassForm">
					<div class="form-group has-info">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> 用户账号 </label>
						<div class="col-sm-6">
							<span class="block">
								<label class="control-label" id="accountlabel"></label>
								<input type="hidden" id="account" name="account">
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
	            <button type="button" class="btn btn-primary" onclick="resetPass()">
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
	<script type="text/javascript" src="js/echarts-all.js"></script>
	<script type="text/javascript" src="jsp/member/js/myrecommTree.js"></script>
</body>
</html>