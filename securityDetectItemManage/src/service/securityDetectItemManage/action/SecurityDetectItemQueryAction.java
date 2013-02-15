package service.securityDetectItemManage.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import model.SecurityDetectItem;
import model.SecurityDetectService;

import org.apache.struts2.interceptor.ServletRequestAware;

import service.securityDetectItemManage.SecurityDetectItemManager;
import service.securityDetectItemManage.SecurityDetectItemManagerImpl;
import service.securityDetectItemManage.SecurityDetectServiceManager;
import service.securityDetectItemManage.SecurityDetectServiceManagerImpl;

import com.opensymphony.xwork2.ActionSupport;

public class SecurityDetectItemQueryAction extends ActionSupport implements
		ServletRequestAware {
	
	private HttpServletRequest request;
	
	/** ��ȫ������ */
	private SecurityDetectItemForm item;
	
	/** ��ȫ����������߼��� */
	private SecurityDetectItemManagerImpl itemManager = new SecurityDetectItemManagerImpl();
	
	/** ��ȫ���ҵ���*/
	private SecurityDetectServiceForm service;
	
	/** ��ȫ���ҵ�������߼���*/
	private SecurityDetectServiceManagerImpl serviceManager = new SecurityDetectServiceManagerImpl();
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	/**
	 * ��ð�ȫ���ҵ���б���Ϣ
	 * @return ��ת����ȫ���ҵ���б���ʾҳ��
	 */
	public String serviceList() throws Exception{
		List<SecurityDetectService> serviceList = serviceManager.getServiceList();
		//List<SecurityDetectService> serviceList = servicetest();
		request.setAttribute("serviceList",serviceList);
		return "serviceList";
	}
	
	/**
	 * ��ð�ȫ������б���Ϣ
	 * @return ��ת����ȫ������б���ʾҳ��
	 */
	public String itemList() throws Exception{
		List<SecurityDetectItem> itemList = itemManager.getItemList();
		//List<SecurityDetectItem> itemList = test();
		request.setAttribute("itemList",itemList);
		return "itemList";
	}
	
	
	/**
	 * ��SecurityDetectItemת����SecurityDetectItemForm
	 * @param itemObj ���ݿ��ҵ���item
	 * @return ת����itemform
	 */
	private SecurityDetectItemForm itemToItemForm(SecurityDetectItem itemObj){
		SecurityDetectItemForm tempitem = new SecurityDetectItemForm();
		tempitem.setDescription(itemObj.getDescription());
		tempitem.setId(itemObj.getId());
		tempitem.setItemInfo(itemObj.getItemInfo());
		tempitem.setItemName(itemObj.getItemName());
		tempitem.setSuggestionTools(itemObj.getSuggestionTools());
		tempitem.setType(itemObj.getType());
		tempitem.setCreateTime(itemObj.getCreateTime());
		tempitem.setSecurityDetectServices(itemObj.getSecurityDetectServices());
		return tempitem;
	}
	
	/**
	 * ��ð�ȫ�������Ϣ
	 * @return ��ת����ȫ�������Ϣ��ʾҳ��
	 */
	public String getItemInfo() throws Exception{
		String id = request.getParameter("id");
		List<SecurityDetectItem> itemList = itemManager.getItemList();
		int len = itemList.size();
		SecurityDetectItem itemObj = new SecurityDetectItem();
		for(int i=0; i<len; i++){
			if(Integer.parseInt(id) == itemList.get(i).getId()){
				itemObj = itemList.get(i);
				break;
			}
		}
		
		//����ȫ������������������������
		item = itemToItemForm(itemObj);
		request.setAttribute("item",item);
		
		Set serviceSet = item.getSecurityDetectServices();
		request.setAttribute("serviceSet", serviceSet);
		return "itemInfo";
	}
	
	
	/**
	 * ��SecurityDetectServiceת����SecurityDetectServiceForm
	 * @param serviceObj���ݿ��ҵ���Service��
	 * @return ת����serviceForm
	 */
	private SecurityDetectServiceForm serviceToServiceForm(SecurityDetectService serviceObj){
		SecurityDetectServiceForm tempService = new SecurityDetectServiceForm();
		tempService.setDescription(serviceObj.getDescription());
		tempService.setId(serviceObj.getId());
		tempService.setSecurityDetectItems(serviceObj.getSecurityDetectItems());
		tempService.setServiceInfo(serviceObj.getServiceInfo());
		tempService.setServiceName(serviceObj.getServiceName());
		tempService.setCreateTime(serviceObj.getCreateTime());
		return tempService;
	}
	/**
	 * ��ð�ȫ���ҵ����Ϣ
	 * @return ��ת����ȫ���ҵ����Ϣ��ʾҳ��
	 * @throws Exception
	 */
	public String getServiceInfo() throws Exception{
		String id = request.getParameter("id");
		List<SecurityDetectService> serviceList = serviceManager.getServiceList();
		int len = serviceList.size();
		SecurityDetectService serviceObj = new SecurityDetectService();
		for(int i=0; i<len; i++){
			if(Integer.parseInt(id) == serviceList.get(i).getId()){
				serviceObj = serviceList.get(i);
				break;
			}
		}
		//ֱ�ӻ�ȡ�ò���������ļ����
		//SecurityDetectService serviceObj = serviceManager.getService(Integer.parseInt(id));
		service = serviceToServiceForm(serviceObj);
		request.setAttribute("service",service);
		Set itemSet =  service.getSecurityDetectItems();
		request.setAttribute("itemSet",itemSet);
		return "serviceInfo";
	}
	
	/**
	 * ��ð�ȫ����������б���Ϣ
	 * @return ��ת����ȫ����������б���ʾҳ��
	 */
	public String typeList() throws Exception{
		return "typeList";
	}
}
