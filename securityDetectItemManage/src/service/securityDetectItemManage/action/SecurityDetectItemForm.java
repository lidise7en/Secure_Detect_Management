package service.securityDetectItemManage.action;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.tools;

//import java.io.Serializable;

/**
 * 
 * @author QJX
 * ��ȫ�����������
 */

public class SecurityDetectItemForm{
	
	/** ��ȫ�����ID. */
	private int id;
	
	/** ��ȫ��������� */
	private String itemName;
	
	/** ��ȫ��������� */
	private String description;
	
	/** ��ȫ�������ϸ��Ϣ */
	private String itemInfo;
	
	/** ��ȫ�����������һ���లȫ����� */
	private String type;
	
	/** ����ʱ��. */
	private Date createTime;
	
	/** �������Ƽ���⹤��. */
	private String suggestionTools;
	
	/** �������Ƽ���⹤������ */
	private String[] toolsArray;
	
	/** �����İ�ȫ���ҵ��.�����ҵ��ʱ��������*/
	private Set SecurityDetectServices = new HashSet();
	
	
	public Set getSecurityDetectServices() {
		return SecurityDetectServices;
	}
	public void setSecurityDetectServices(Set securityDetectServices) {
		SecurityDetectServices = securityDetectServices;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getItemInfo(){
		return itemInfo;
	}
	public void setItemInfo(String itemInfo){
		this.itemInfo = itemInfo;
	}
	
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getSuggestionTools(){
		return suggestionTools;
	}
	public void setSuggestionTools(String suggestionTools){
		this.suggestionTools = suggestionTools;
	}
	
	public String[] getToolsArray(){
		return toolsArray;
	}
	public void setToolsArray(String[] toolsArray){
		this.toolsArray = toolsArray;
	}
}
