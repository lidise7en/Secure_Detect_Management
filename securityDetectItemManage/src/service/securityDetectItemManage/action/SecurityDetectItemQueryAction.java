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
	
	/** 安全检测项表单 */
	private SecurityDetectItemForm item;
	
	/** 安全检测项管理的逻辑类 */
	private SecurityDetectItemManagerImpl itemManager = new SecurityDetectItemManagerImpl();
	
	/** 安全检测业务表单*/
	private SecurityDetectServiceForm service;
	
	/** 安全检测业务管理的逻辑类*/
	private SecurityDetectServiceManagerImpl serviceManager = new SecurityDetectServiceManagerImpl();
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	/**
	 * 获得安全检测业务列表信息
	 * @return 跳转到安全检测业务列表显示页面
	 */
	public String serviceList() throws Exception{
		List<SecurityDetectService> serviceList = serviceManager.getServiceList();
		//List<SecurityDetectService> serviceList = servicetest();
		request.setAttribute("serviceList",serviceList);
		return "serviceList";
	}
	
	/**
	 * 获得安全检测项列表信息
	 * @return 跳转到安全检测项列表显示页面
	 */
	public String itemList() throws Exception{
		List<SecurityDetectItem> itemList = itemManager.getItemList();
		//List<SecurityDetectItem> itemList = test();
		request.setAttribute("itemList",itemList);
		return "itemList";
	}
	
	
	/**
	 * 将SecurityDetectItem转换成SecurityDetectItemForm
	 * @param itemObj 数据库找到的item
	 * @return 转换成itemform
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
	 * 获得安全检测项信息
	 * @return 跳转到安全检测项信息显示页面
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
		
		//将安全监测项对象的属性置入表单对象中
		item = itemToItemForm(itemObj);
		request.setAttribute("item",item);
		
		Set serviceSet = item.getSecurityDetectServices();
		request.setAttribute("serviceSet", serviceSet);
		return "itemInfo";
	}
	
	
	/**
	 * 将SecurityDetectService转换成SecurityDetectServiceForm
	 * @param serviceObj数据库找到的Service项
	 * @return 转换成serviceForm
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
	 * 获得安全检测业务信息
	 * @return 跳转到安全检测业务信息显示页面
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
		//直接获取得不到相关联的检测项
		//SecurityDetectService serviceObj = serviceManager.getService(Integer.parseInt(id));
		service = serviceToServiceForm(serviceObj);
		request.setAttribute("service",service);
		Set itemSet =  service.getSecurityDetectItems();
		request.setAttribute("itemSet",itemSet);
		return "serviceInfo";
	}
	
	/**
	 * 获得安全检测项类型列表信息
	 * @return 跳转到安全检测项类型列表显示页面
	 */
	public String typeList() throws Exception{
		return "typeList";
	}
}
