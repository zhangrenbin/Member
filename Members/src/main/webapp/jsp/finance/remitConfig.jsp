<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/authtaglib" prefix="a"%>
<!DOCTYPE html>
<html lang="zh-CN" style="background-color: white">
<head>
<c:import url="/jsp/fragment/baseheader_sub.jsp">
	<c:param name="title" value="汇款确认" />
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
							<h1>汇款确认</h1>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 pull-right">
							<form class="form-search form-inline" id="searchFrm">
								<div class="pull-right">
									<div class="input-group">
										<span class="input-group-addon">
											姓名或账号
										</span>
										<input type="text" name="payload" class="form-control search-query" placeholder="输入用户姓名或账号..." />
										<span class="input-group-btn">
					                        <button class="btn btn-info btn-sm" type="button" onclick="doSearch()">
												<span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
													查询
											</button>
					                    </span>
									</div>
									<!-- <button type="button" class="btn btn-info btn-sm" onclick="doSearch()">
										<span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
										查询
									</button> -->
								</div>
							</form>
						</div>
					</div>
				</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th class="hidden-480">会员姓名</th>
							<th>会员账号</th>
							<th>汇款金额</th>
							<th>汇入账户</th>
							<th class="hidden-480">汇款时间</th>
							<th class="hidden-480">报单中心</th>
							<th class="hidden-480">备注</th>
							<th class="hidden-480">确认状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="remitList">
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
	<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
	<!--[if lte IE 8]>
		  <script src="ace/assets/js/excanvas.min.js"></script>
		<![endif]-->
	<c:import url="/jsp/fragment/basebottom_sub.jsp"></c:import>
	<script src="ace/assets/js/jquery.autosize.min.js"></script>
	<script type="text/javascript" src="js/jqPaginator.min.js"></script>
	<script type="text/javascript" src="jsp/finance/js/remitConfig.js"></script>
</body>
</html>