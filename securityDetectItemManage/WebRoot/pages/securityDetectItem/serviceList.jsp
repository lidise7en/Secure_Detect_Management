<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>安全检测业务列表</title>
<style type="text/css">
.coolscrollbar 
{scrollbar-arrow-color:yellow;
scrollbar-base-color:lightsalmon;}
</style>
</head>
<body bgcolor="#ADD8E6">
<script type="text/javascript">
function check(serviceid,servicename) {  
    if (window.confirm("确认删除检测业务: "+servicename+" 吗?")) {  
     	window.location.href='deleteServiceAction?id='+serviceid;
    }  
    return false;  
   }  
</script>
<div align="center"><h3>安全检测业务类管理</h3> </div>
  <table width="99%" align="center" border="0" cellpadding="4" cellspacing="1">
	  <tr>
		   			<td>
		   				<input type="button" name="addService" value="添加安全检测业务类" 
		   					onclick="window.location.href='${pageContext.request.contextPath}/initAddServiceAction'"/>
		   			</td>
   			</tr>
	  </table>
	  <div align="center" class="coolscrollbar" style="height:400px;overflow-x:auto;overflow-y:auto;">
	  <table width="100%" border="1" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
			  <tr>
			    <td width="250" height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">安全检测业务名称</td>  
			    <td height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">修改时间</td>
			    <td height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">描述</td>
			    <td width="250" height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">安全检测项</td>
			    <td height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">操作</td>
		      </tr>
	<s:iterator value="#request.serviceList" id="service">
   		<tr>
   			<td align="center"><s:property value="serviceName"/></td>
   			<td align="center"><s:property value="createTime"/></td>
   			<td align="center"><s:property value="description"/></td>
   			<td align="center">
   				<s:iterator value="#service.SecurityDetectItems" id="item">
   					<s:property value="#item.itemName"/><br>     
   				</s:iterator>
   			</td>
   			<td align="center">
				<input type="button" name="updateService" value="更新" 
		   					onclick="window.location.href='initUpdateServiceAction?id=${service.id}'"/>
		   		<input type="button" name="deleteService" value="删除" 
		   					onclick="return check('${service.id}','serviceName')"/>
   			</td>
   		</tr>
   	</s:iterator>
	  </table>
	  </div>
</body>
</html>