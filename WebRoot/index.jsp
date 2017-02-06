<%@ page language="java" pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("CURRENT_USER") == null) { //用户未登录
		response.sendRedirect("login.jsp");
	};
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="cache-control" content="no-store">
<meta http-equiv="expires" content="0">

<!-- 包含 bootstrap  核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<!-- 主题 -->
<link
	href="extjs/resources/ext-theme-neptune/ext-theme-neptune-all.css"
	rel="stylesheet" />

<link rel="stylesheet" type="text/css" href="extjs/resources/css/ext-all-neptune.css">

<link rel="stylesheet" type="text/css" href="resource/css/index.css">

<!-- 引入图标定义文件 -->
<link rel="stylesheet" type="text/css" href="resource/css/image.css">

<script src="extjs/ext-all.js"></script>
<script src="extjs/locale/ext-lang-zh_CN.js"></script>

<script type="text/javascript" src="app.js"></script>

</head>

<body>
	<script type="text/javascript">
		var SYSTEM_CONTEXTPATH="<%=path%>";
	</script>
</body>
</html>
