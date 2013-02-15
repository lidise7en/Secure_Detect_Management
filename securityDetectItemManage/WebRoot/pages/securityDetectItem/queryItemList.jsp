<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>安全检测项列表</title>
<style type="text/css">
.coolscrollbar 
{scrollbar-arrow-color:yellow;
scrollbar-base-color:lightsalmon;}
</style>
</head>
<body bgcolor="#ADD8E6">
<div align="center"><h3>安全检测项列表 </h3></div>
<br>
<div align="center" class="coolscrollbar" style="height:400px;overflow-x:auto;overflow-y:auto;">

<table width="100%" border="1" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
		<tr>
			    <td width="250" height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">安全检测项名称</td>
			    <td  height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">类型</td>
			    <td height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">修改时间</td>
			    <td height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">描述</td>
		</tr>
	<s:iterator value="#request.itemList" id="item">
   		<tr>
   			<td align="center"><a href="${pageContext.request.contextPath}/itemInfoAction?id=${item.id}"><s:property value="itemName"/></a></td>
   			<td align="center"><s:property value="type"/></td>
   			<td align="center"><s:property value="createTime"/></td>
   			<td align="center"><s:property value="description"/></td>
   		</tr>
   	</s:iterator>
</table>
</div>
</body>
</html>