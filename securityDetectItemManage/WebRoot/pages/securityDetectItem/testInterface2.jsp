<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>TestInterface</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<s:head />
    <style type="text/css">
    .label {
	font-style: normal;
}
    </style>
	</head>
	<body bgcolor="#ADD8E6" class="body">
	<div align="center"><h3>TestInterface</h3> </div>
	<div align="center">
		<s:form action="../../showItemsAction" name="testInterfaceForm">
			<s:checkboxlist id="testItemList" name="testItemsArray" label="推荐检测工具" labelposition="left"
				list="{'GSM，WCDMA网络安全检测','数据库安全检测','接口协议安全检测','防火墙安全检测','主机设备安全检测',
					'3G网络安全检测','WEB攻击及漏洞检测'}" >
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
		<table>
			<tr>
			<td>
			<s:optiontransferselect label="关联安全检测项"
				 name="itemNameList" leftTitle="所有安全检测项" list="#request.itemNameList"  multiple="true" 
				 doubleName="service.addedItemList" rightTitle="已添加的安全检测项" doubleList="" doubleMultiple="true"
				 cssStyle="width:150px; height:200px"   doubleCssStyle="width:150px; height:200px"
				 allowUpDownOnLeft="false" allowUpDownOnRight="false">
			</s:optiontransferselect>
		   	</td>
		   	</tr>
		   	</table>
	</div>
	</body>
</html>