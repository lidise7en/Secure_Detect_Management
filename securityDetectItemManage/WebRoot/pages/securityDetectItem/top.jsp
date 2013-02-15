<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Top</title>
<link href="../../css/header.css" type="text/css" rel="stylesheet" />
</head>
<body>
<script type="text/javascript" language="javascript" src="../../js/jquery-1.3.2.min.js"></script>
<script type="text/javascript">
var oplist = new Array('query', 'serviceManager', 'itemManager');
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
<div id="all">
	<div id="banner"><h1>电信网应用业务安全检测平台</h1></div>
	<div id="subtitle"><h2>电信网应用业务安全属性特征分析和管理系统</h2></div>
	<div id="nav">
    	<ul>
    	<li class="inactive" id="query"><a href="query.jsp" target="content">安全属性查询</a></li>
		<li class="inactive" id="serviceManager"><a href="${pageContext.request.contextPath}/listServiceAction" target="content">安全检测业务类管理</a></li>
    	<li class="inactive" id="itemManager"><a href="${pageContext.request.contextPath}/listItemAction" target="content">安全检测项管理</a></li>
 		</ul>
 	</div>
 	<div id="main">
    	<div id="welcome">您好，欢迎使用本系统!</div>
        <div id="adminop">
            <ul>
                <li><a href="javascript:parent.location.reload();">退出系统</a></li>
                <li><a href="javascript:parent.location.reload();">系统首页</a></li>
            </ul>
        </div>
    </div>
 </div>
</body>
</html>