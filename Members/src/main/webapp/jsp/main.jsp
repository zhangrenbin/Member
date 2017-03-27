<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<c:import url="/jsp/fragment/baseheader_sub.jsp">
	<c:param name="title" value="会员管理系统"/>
</c:import>
</head>

<body class="no-skin">
	<c:import url="/jsp/fragment/title_sub.jsp"></c:import>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<c:import url="/jsp/fragment/left_sub.jsp">
		</c:import>
		<div class="main-content">
			<div class="main-content-inner">
				<c:import url="/jsp/fragment/breakcrumbs_sub.jsp"></c:import>
				<iframe src="main/f_user_main.do" marginheight="0" marginwidth="0" frameborder="0"
						scrolling-y="auto" width="100%" height=100% id="iframepage"
						name="iframepage" class="minWidth"></iframe>
			</div>
		</div>
		<c:import url="/jsp/fragment/basefooter_sub.jsp"></c:import>
	</div>
	<!--[if lte IE 8]>
		  <script src="ace/assets/js/excanvas.min.js"></script>
		<![endif]-->
	<c:import url="/jsp/fragment/basebottom_sub.jsp"></c:import>
	<script src="ace/assets/js/jquery.nestable.min.js"></script>
	<script type="text/javascript" src="jsp/js/main.js"></script>
</body>
</html>
