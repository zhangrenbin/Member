<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN" style="background-color: white">
<head>
<c:import url="/jsp/fragment/baseheader_sub.jsp">
	<c:param name="title" value="错误" />
</c:import>
<link rel="stylesheet" href="ace/assets/css/jquery-ui.min.css" />
</head>

<body class="no-skin" style="background-color: white">
	<div class="main-content">
		<div class="main-content-inner">
			<div class="error-container">
				<div class="well">
					<h1 class="grey lighter smaller">
						<span class="blue bigger-125">
							<i class="ace-icon fa fa-exclamation-triangle"></i>
						</span>
						出了一点问题
					</h1>
					<hr />
					<h3 class="lighter smaller">
						${msg }
					</h3>

				</div>
			</div>
		</div>
	</div>
	<!--[if lte IE 8]>
		  <script src="ace/assets/js/excanvas.min.js"></script>
		<![endif]-->
	<c:import url="/jsp/fragment/basebottom_sub.jsp"></c:import>
</body>
</html>