<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>serviceInfo</title>
</head>
<body bgcolor="#ADD8E6">
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
  <tr>
    <td height="26" align="center" bgcolor="#FFFFFF">安全检测业务名称</td>
    <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="#request.service.serviceName"/></td>
  </tr>
  <tr>
    <td height="26" align="center" bgcolor="#FFFFFF">描述</td>
    <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="#request.service.description"/></td>
  </tr>
  <tr>
    <td height="26" align="center" bgcolor="#FFFFFF">创建时间</td>
    <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="#request.service.createTime"/></td>
  </tr>
  <tr>
    <td height="26" align="center" bgcolor="#FFFFFF">详细信息</td>
    <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="#request.service.serviceInfo"/></td>
  </tr>
  <tr>
    <td height="26" align="center" bgcolor="#FFFFFF">安全检测项</td>
    <td height="26" align="center" bgcolor="#FFFFFF">
    	<s:iterator value="#request.itemSet" id="item">
   					<s:property value="#item.itemName"/><br>     
   		</s:iterator>
   	</td>
  </tr>
</table>
</body>
</html>