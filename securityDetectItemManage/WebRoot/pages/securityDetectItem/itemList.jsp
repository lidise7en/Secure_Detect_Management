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
<script type="text/javascript">
function check(itemid,itemname) {  
    if (window.confirm("确认删除检测项: "+itemname+" 吗?")) {  
	    //alert('deleteItemAction?id='+itemid);
     	window.location.href='deleteItemAction?id='+itemid;
    }  
    return false;  
   }  
</script>
<div align="center"><h3>安全检测项管理</h3> </div>

 <table width="100%" align="center" border="0" cellpadding="4" cellspacing="1"> 
		<tr>
		   		<td>
		   			<input type="button" name="addItem" value="添加安全检测项" 
		   					onclick="window.location.href='${pageContext.request.contextPath}/initAddItemAction'"/>
		   		</td>
		   		<td>
		   			<input type="button" name="listItemByType" value="按类型显示安全检测项" 
		   					onclick="window.location.href='${pageContext.request.contextPath}/listItemByTypeAction'"/>
		   		</td>		   		
   		</tr>
 </table>
 <div align="center" class="coolscrollbar" style="height:400px;overflow-x:auto;overflow-y:auto;">
<table width="100%" border="1" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
		<tr>
			    <td width="250" height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">安全检测项名称</td>
			    <td height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">类型</td>
			    <td height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">修改时间</td>
			    <td height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">描述</td>
			    <td width="250" height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">推荐检测工具</td>
			    <td height="27" align="center" background="images/b1.gif" bgcolor="#FFFFFF">操作</td>
		</tr>
		
	<s:iterator value="#request.itemList" id="item">
   		<tr>
   			<td align="center"><s:property value="itemName"/></td>
   			<td align="center"><s:property value="type"/></td>
   			<td align="center"><s:property value="createTime"/></td>
   			<td align="center"><s:property value="description"/></td>
   			<td align="center"><s:property value="suggestionTools"/></td>
   			<td align="center">
   				<input type="button" name="updateItem" value="更新" 
		   					onclick="window.location.href='initUpdateItemAction?id=${item.id}'"/>
		   		<input type="button" name="deleteItem" value="删除" 
		   					onclick="return check('${item.id}', '${item.itemName}')"/>
		   	</td>
   		</tr>
   	</s:iterator>
</table>
</div>
</body>
</html>