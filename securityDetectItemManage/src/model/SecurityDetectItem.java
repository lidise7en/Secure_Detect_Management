package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author QJX
 * ��ȫ�������Ӧ��POJO��
 * 
 */
public class SecurityDetectItem {

	/** ��ȫ�����ID. (����)����*/
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

	/** �����İ�ȫ���ҵ��.�����ҵ��ʱ��������*/
	private Set SecurityDetectServices = new HashSet();
	
	/** �������Ƽ���⹤��.���й���д��string��,�ö��ŷָ� */
	private String suggestionTools;
	
	
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
}
