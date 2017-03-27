<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>${param.title }</title>

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="ace/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="ace/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->
<!-- text fonts -->
<link rel="stylesheet" href="ace/assets/fonts/fonts.googleapis.com.css" />
<link rel="stylesheet" href="${param.colorBoxCss}" />
<!-- ace styles -->
<link rel="stylesheet" href="ace/assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />
	
<link rel="stylesheet" href="css/my.css"/>

<!--[if lte IE 9]>
	<link rel="stylesheet" href="ace/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
<![endif]-->

<!--[if lte IE 9]>
  <link rel="stylesheet" href="ace/assets/css/ace-ie.min.css" />
<![endif]-->
<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
	<script src="ace/assets/js/html5shiv.min.js"></script>
	<script src="ace/assets/js/respond.min.js"></script>
<![endif]-->
<!-- basic scripts -->

<!--[if !IE]> -->
<script Charset="UTF-8" src="ace/assets/js/jquery.2.1.1.min.js"></script>
<!-- <![endif]-->

<!--[if IE]>
	<script src="ace/assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

<!--[if !IE]> -->
<script type="text/javascript">
	window.jQuery || document.write("<script src='ace/assets/js/jquery.min.js'>"+"<"+"/script>");
</script>
<!-- <![endif]-->

<!--[if IE]>
	<script type="text/javascript">
	 window.jQuery || document.write("<script src='ace/assets/js/jquery1x.min.js'>"+"<"+"/script>");
	</script>
<![endif]-->
<script type="text/javascript">
	if('ontouchstart' in document.documentElement) document.write("<script src='ace/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script type="text/javascript">
	var basePath = '<%=basePath%>'
</script>