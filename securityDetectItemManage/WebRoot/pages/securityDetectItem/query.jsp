<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<frameset cols="200,*" framespacing="0" border="0" frameborder="0" name="queryIndexFrame">
	<frame name="queryMainFrame" id="queryMainFrame" target="content" src="queryMain.jsp"  scrolling="no" noresize>	
	<frame src="${pageContext.request.contextPath}/itemListQueryAction" name="queryContent" target="queryContent" scrolling="no" noresize>
</frameset>
<body>
</body>
</html>