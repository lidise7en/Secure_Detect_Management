<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../css/querymain.css" type="text/css" rel="stylesheet" />
</head>
<body>
<script type="text/javascript" language="javascript" src="../../js/jquery-1.3.2.min.js"></script>
<script type="text/javascript">
var oplist = new Array('queryItem', 'queryService');
$(document).ready(function() {
	$('#nav').find("a").click(function() {
		var id = $(this).attr('id');
		$.each(oplist, function(i, n) {
			$('#'+n).attr('class', 'inactive');
		});
		$(this).parents("li").attr('class', 'active');
	});
});
</script>
<div id="all"><br><br><br>
	<div id="nav">
		<ul>
			<li class="inactive" id="queryItem"><a href="${pageContext.request.contextPath}/itemListQueryAction" target="queryContent">按安全检测项查询</a></li>
			<li><br></li>
			<li><br></li>
			<li class="inactive" id="queryService"><a href="${pageContext.request.contextPath}/serviceListQueryAction" target="queryContent">按安全检测业务查询</a></li>
		</ul>
	</div>
</div>
</body>
</html>