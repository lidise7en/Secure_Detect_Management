<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>新增安全检测业务</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<s:head />
    <style type="text/css">
    .label {
	font-style: normal;
}
    </style>
	</head>
	<body bgcolor="#ADD8E6" class="body">
	<div align="center"><h3>添加安全检测业务</h3> </div>
	<div align="center"><h4>该检测业务已存在!</h4> </div>
	<div align="center">
		<s:form action="addServiceAction" name="addServiceForm">
			<s:textfield name="service.serviceName" label="安全检测业务名称"></s:textfield>
			<s:textfield name="service.description" label="安全检测业务描述"></s:textfield>
	 		<s:textarea cols="20" rows="6" name="service.serviceInfo" label="安全检测业务详细信息"></s:textarea>			
			<!-- 关联安全检测项 -->
			<!-- 用optiontransferselect -->
			<s:optiontransferselect label="关联安全检测项"
				 name="itemNameList" leftTitle="所有安全检测项" list="#request.itemNameList"  multiple="true" 
				 doubleName="service.addedItemList" rightTitle="已添加的安全检测项" doubleList="" doubleMultiple="true"
				 cssStyle="width:150px; height:200px"   doubleCssStyle="width:150px; height:200px"
				 allowUpDownOnLeft="false" allowUpDownOnRight="false">
			</s:optiontransferselect>
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