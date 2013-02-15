<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>更新安全检测业务</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
				<s:head />
    <style type="text/css">
    .label {
	font-style: normal;
}
    </style>
	</head>
	<body bgcolor="#ADD8E6">
	<div align="center"><h3>安全检测业务类更新</h3> </div>
	<div align="center">
		<s:form action="updateServiceAction">
			<input type="hidden" name="service.id" value="<s:property value='service.id' />" />
			<s:textfield readonly="true" name="service.serviceName" label="安全检测业务名称"></s:textfield>
			<s:textfield name="service.description" label="安全检测业务描述"></s:textfield>
	 		<s:textarea cols="20" rows="6" name="service.serviceInfo" label="安全检测业务详细信息"></s:textarea>
			<!-- 关联的安全检测项... -->
			<!-- 用optiontransferselect -->
			<s:optiontransferselect label="关联安全检测项"
				 name="itemNameList" leftTitle="所有安全检测项" list="#request.itemNameList"  multiple="true" 
				 doubleName="service.addedItemList" rightTitle="已添加的安全检测项" doubleList="#request.addedItemNameList" doubleMultiple="true"
				 cssStyle="width:150px; height:200px"   doubleCssStyle="width:150px; height:200px"
				 allowUpDownOnLeft="false" allowUpDownOnRight="false">
			</s:optiontransferselect>
			<table>
  			<tr>
      			<td> <s:submit value="提交" theme="simple"> </s:submit> </td>
      			<td> <s:reset value="重置" theme="simple"></s:reset>	</td> 
      			<td><input type="button" name="return" value="返回" 
		   					onclick="window.history.back()"/>
      			</td>
  			</tr>
			</table>
		</s:form>
	</div>
	</body>
</html>