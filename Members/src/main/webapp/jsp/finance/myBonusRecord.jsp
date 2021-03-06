<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/authtaglib" prefix="a"%>
<!DOCTYPE html>
<html lang="zh-CN" style="background-color: white">
<head>
<c:import url="/jsp/fragment/baseheader_sub.jsp">
	<c:param name="title" value="奖励记录" />
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
							<h1>奖励记录</h1>
						</div>
						<c:if test="${!empty god }">
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
						</c:if>
					</div>
				</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>会员名称</th>
							<th>会员账号</th>
							<th class="hidden-480">奖励时间</th>
							<th>奖励金额</th>
							<th class="hidden-480">奖励描述</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="recordList">
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
	<script type="text/javascript" src="jsp/finance/js/myBonusRecord.js"></script>
</body>
</html>