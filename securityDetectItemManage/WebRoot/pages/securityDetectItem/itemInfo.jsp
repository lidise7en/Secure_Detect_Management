<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>itemInfo</title>
</head>
<body bgcolor="#ADD8E6">
<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
  <tr>
    <td height="26" align="center" bgcolor="#FFFFFF">安全检测项名称</td>
    <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="#request.item.itemName"/></td>
  </tr>
  <tr>
    <td height="26" align="center" bgcolor="#F7FAFF">描述</td>
    <td height="26" align="center" bgcolor="#F7FAFF"><s:property value="#request.item.description"/></td>
  </tr>
  <tr>
    <td height="26" align="center" bgcolor="#F7FAFF">类型</td>
    <td height="26" align="center" bgcolor="#F7FAFF"><s:property value="#request.item.type"/></td>
  </tr>
  <tr>
    <td height="26" align="center" bgcolor="#FFFFFF">详细信息</td>
    <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="#request.item.itemInfo"/></td>
  </tr>
  <tr>
    <td height="26" align="center" bgcolor="#FFFFFF">创建时间</td>
    <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="#request.item.createTime"/></td>
  </tr>
  <tr>
    <td height="26" align="center" bgcolor="#FFFFFF">所处电信网应用</td>
    <td height="26" align="center" bgcolor="#FFFFFF">
		<s:iterator value="#request.serviceSet" id="service">
   					<s:property value="#service.serviceName"/><br>     
   		</s:iterator>
	</td>
  </tr>
  <tr>
    <td height="26" align="center" bgcolor="#FFFFFF">推荐检测工具</td>
    <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="#request.item.suggestionTools"/></td>
  </tr>
</table>
</body>
</html>