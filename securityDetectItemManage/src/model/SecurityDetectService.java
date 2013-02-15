package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author QJX
 * ��ȫ���ҵ����Ӧ��POJO��
 *
 */

public class SecurityDetectService {
	
	/** ��ȫ���ҵ��ID. (����)����*/
	private int id;
	
	/** ��ȫ���ҵ������ */
	private String serviceName;
	
	/** ��ȫ���ҵ������ */
	private String description;
	
	/** ��ȫ���ҵ����ϸ��Ϣ */
	private String serviceInfo;
	
	/** ����ʱ��. */
	private Date createTime;
	
	/** �����İ�ȫ�����. */
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
