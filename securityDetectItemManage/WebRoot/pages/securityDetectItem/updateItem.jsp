<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>更新安全检测项</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	</head>
	<body bgcolor="#ADD8E6">
	<div align="center">
		<div align="center"><h3>安全检测项更新</h3> </div>
		<s:form action="updateItemAction">
			<input type="hidden" name="item.id" value="<s:property value='item.id'/>"/>
			<s:textfield readonly="true" name="item.itemName" label="安全检测项名称"></s:textfield>
			<s:select name="item.type" label="安全检测项类型" list="{'GSM，WCDMA网络安全检测','数据库安全检测','接口协议安全检测',
			'防火墙安全检测','主机设备安全检测','3G网络安全检测','WEB攻击及漏洞检测'}"></s:select>
			<s:textfield name="item.description" label="安全检测项描述"></s:textfield>
			<s:textarea cols="20" rows="6" name="item.itemInfo" label="安全检测项详细信息"></s:textarea>
			<!-- 推荐工具咧...用checkboxlist? -->
			<s:checkboxlist name="item.toolsArray" label="推荐检测工具" labelposition="left"
				list="#request.toolList" >
			</s:checkboxlist>
			<table>
  			<tr>
      			<td> <s:submit value="提交" theme="simple"> </s:submit> </td>
      			<td><input type="button" name="return" value="返回" 
		   					onclick="window.history.back()"/>
      			</td>
  			</tr>
			</table>
		</s:form>
	</div>
	</body>
</html>