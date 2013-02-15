package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author QJX
 * 安全检测业务表对应的POJO类
 *
 */

public class SecurityDetectService {
	
	/** 安全检测业务ID. (自增)主键*/
	private int id;
	
	/** 安全检测业务名称 */
	private String serviceName;
	
	/** 安全检测业务描述 */
	private String description;
	
	/** 安全检测业务详细信息 */
	private String serviceInfo;
	
	/** 创建时间. */
	private Date createTime;
	
	/** 关联的安全检测项. */
	private Set SecurityDetectItems = new HashSet();
	
	public Set getSecurityDetectItems() {
		return SecurityDetectItems;
	}
	public void setSecurityDetectItems(Set securityDetectItems) {
		SecurityDetectItems = securityDetectItems;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	}
	
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getServiceInfo(){
		return serviceInfo;
	}
	public void setServiceInfo(String serviceInfo){
		this.serviceInfo = serviceInfo;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
