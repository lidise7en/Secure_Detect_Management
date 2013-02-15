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
 * 安全检测项表表单对象
 */

public class SecurityDetectItemForm{
	
	/** 安全检测项ID. */
	private int id;
	
	/** 安全检测项名称 */
	private String itemName;
	
	/** 安全检测项描述 */
	private String description;
	
	/** 安全检测项详细信息 */
	private String itemInfo;
	
	/** 安全检测项属于哪一大类安全检测项 */
	private String type;
	
	/** 创建时间. */
	private Date createTime;
	
	/** 关联的推荐检测工具. */
	private String suggestionTools;
	
	/** 关联的推荐检测工具数组 */
	private String[] toolsArray;
	
	/** 关联的安全检测业务.在添加业务时关联进来*/
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
