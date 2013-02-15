package service.securityDetectItemManage.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import model.SecurityDetectItem;
import model.SecurityDetectService;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.BeanUtils;

import service.securityDetectItemManage.SecurityDetectItemManager;
import service.securityDetectItemManage.SecurityDetectItemManagerImpl;
import service.securityDetectItemManage.SecurityDetectServiceManager;
import service.securityDetectItemManage.SecurityDetectServiceManagerImpl;

import com.opensymphony.xwork2.ActionSupport;

public class SecurityDetectServiceAction extends ActionSupport implements
		ServletRequestAware {
	
	//接口测试的工具
	String[] testItemsArray;
	public String[] getTestItemsArray(){
		return testItemsArray;
	}
	public void setTestItemsArray(String[] testItemsArray){
		this.testItemsArray = testItemsArray;
	}
	
	
	private HttpServletRequest request;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	/** 安全检测业务表单*/
	private SecurityDetectServiceForm service;
	
	/** 安全检测业务管理的逻辑类*/
	private SecurityDetectServiceManagerImpl serviceManager = new SecurityDetectServiceManagerImpl();
	
	/** 安全检测项管理的逻辑类 */
	private SecurityDetectItemManagerImpl itemManager = new SecurityDetectItemManagerImpl();
	
	public SecurityDetectServiceForm getService(){
		return service;
	}
	public void setService(SecurityDetectServiceForm service){
		this.service = service;
	}
	
	public SecurityDetectServiceManagerImpl getServiceManager(){
		return serviceManager;
	}
	public void setServiceManager(SecurityDetectServiceManagerImpl serviceManager){
		this.serviceManager = serviceManager;
	}
	
	/**
	 * 获得安全检测业务列表信息
	 * @return 跳转到安全检测业务列表显示页面
	 */
	public String list() throws Exception{
		List<SecurityDetectService> serviceList = serviceManager.getServiceList();
		request.setAttribute("serviceList",serviceList);
		return "list";
	}
	
	/**
	 * 初始化添加安全检测业务类型界面,主要是初始化关联的安全检测项部分
	 * @return 跳转到添加安全检测业务页面
	 * @throws Exception
	 */
	public String initAddService() throws Exception{
		List<SecurityDetectItem> itemList = itemManager.getItemList();
		int len = itemList.size();
		List<String> itemNameList;
		itemNameList = new ArrayList<String>();
		for(int i=0; i<len; i++){
			itemNameList.add(itemList.get(i).getItemName());
		}
		request.setAttribute("itemNameList",itemNameList);
		return "add";
	}
	
	/**
	 * 保存安全检测业务类型
	 * @return 跳转到安全检测业务列表显示的Action路径
	 */
	public String add() throws Exception{
//		FileOutputStream out = new FileOutputStream("D:/b.txt");
//		PrintWriter pw = new PrintWriter(out);
		
		
		List<SecurityDetectService> serviceList = serviceManager.getServiceList();
		Iterator itr = serviceList.iterator();
		while (itr.hasNext()) {
			SecurityDetectService nextObj = (SecurityDetectService)itr.next();
			if(nextObj.getServiceName().equals(service.getServiceName()))
					return this.initAddService();
		}
		
		List<SecurityDetectItem> itemList = itemManager.getItemList();
		int len = itemList.size();
		String[] temp = service.getAddedItemList();
		int len2 = temp.length;
		Set tempItems = new HashSet();
		for(int i=0; i<len2; i++){
			for(int j=0; j<len; j++){
				if(temp[i].equals(itemList.get(j).getItemName())){
					SecurityDetectItem tempItem = itemList.get(j);
					tempItems.add(tempItem);
				}
			}
		}
//		pw.close();
//		out.close();
		
		service.setSecurityDetectItems(tempItems);
		serviceManager.insertService(service);
		return "list";
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
		//tempService.setSecurityDetectItems(serviceObj.getSecurityDetectItems());
		tempService.setServiceInfo(serviceObj.getServiceInfo());
		tempService.setServiceName(serviceObj.getServiceName());
		
		//获取已添加安全检测项
		List<SecurityDetectItem> addedItemList = new ArrayList<SecurityDetectItem>(serviceObj.getSecurityDetectItems());
		List<String> addedNameList = new ArrayList<String>();
		Iterator itr = addedItemList.iterator();
		while(itr.hasNext()){
			addedNameList.add(((SecurityDetectItem)itr.next()).getItemName());
		}
		//要转换成检测项名字的String[]
		tempService.setAddedItemList((String[])addedNameList.toArray(new String[addedNameList.size()]));
		
		//tempService.setCreateTime(serviceObj.getCreateTime());
		return tempService;
	}
	
	/**
	 * 初始化修改安全检测业务类型界面
	 * @return 跳转到修改安全检测业务类型界面
	 */
	public String initUpdate() throws Exception{
		String id = request.getParameter("id");
		SecurityDetectService serviceObj = null;
		
		List<SecurityDetectService> serviceList = serviceManager.getServiceList();
		
		Iterator itr = serviceList.iterator();
		while(itr.hasNext()){
			SecurityDetectService tempService = (SecurityDetectService)itr.next();
			if(tempService.getId() == Integer.parseInt(id)){
				serviceObj = tempService;
				break;
			}
		}
		
		//SecurityDetectService serviceObj = serviceManager.getService(Integer.parseInt(id));
		
		
		//将安全监测项对象的属性置入表单对象中
		service = serviceToServiceForm(serviceObj);
		
		String[] addedItemNameList = service.getAddedItemList();
		int len2 = addedItemNameList.length;
		
		List<SecurityDetectItem> itemList = itemManager.getItemList();
		int len = itemList.size();
		List<String> itemNameList;
		itemNameList = new ArrayList<String>();
		
		for(int i=0; i<len; i++){
			boolean flag = true;
			for(int j=0; j<len2 && flag; j++){
				if(itemList.get(i).getItemName().equals(addedItemNameList[j]))
					flag = false;
			}
			if(flag)
				itemNameList.add(itemList.get(i).getItemName());
		}
		request.setAttribute("itemNameList",itemNameList);
		request.setAttribute("addedItemNameList", addedItemNameList);
		
		return "update";
	}
	
	/**
	 * 修改安全检测业务
	 * @return 跳转到安全检测业务列表显示的Action路径
	 */
	public String update() throws Exception{
		String id = request.getParameter("id");
//		FileOutputStream out = new FileOutputStream("D:/b.txt");
//		PrintWriter pw = new PrintWriter(out);	
		List<SecurityDetectItem> itemList = itemManager.getItemList();
		int len = itemList.size();
		String[] temp = service.getAddedItemList();
		int len2 = temp.length;
		Set tempItems = new HashSet();
		
//		pw.println(len);
//		pw.println(len2);
		
		
		for(int i=0; i<len2; i++){
			for(int j=0; j<len; j++){
				if(temp[i].equals(itemList.get(j).getItemName())){
					SecurityDetectItem tempItem = itemList.get(j);
					tempItems.add(tempItem);
//					pw.println(temp[i]);
				}
			}
		}
//		pw.close();
//		out.close();

		service.setSecurityDetectItems(tempItems);		
		serviceManager.modifyService(service);
		return this.list();
	}
	
	/**
	 * 删除安全检测业务
	 * @return 跳转到安全检测项列表显示的Action路径
	 */
	public String delete() throws Exception{
		String id = request.getParameter("id");
		serviceManager.deleteService(id);
		return this.list();
	}
	
//	public List<SecurityDetectItem> showItems(String serviceName, String[] types) throws Exception{
	public String showItems() throws Exception{
		FileOutputStream out = new FileOutputStream("D:/b.txt");
		PrintWriter pw = new PrintWriter(out);
		
		String serviceName = new String("短信业务");
		String[] types = testItemsArray;
		//String[] types = request.getParameterValues("testItemList");
		if(types == null){
			pw.println("null");
			pw.close();
			out.close();
			return "test";
		}
		
		List<SecurityDetectService> serviceList = serviceManager.getServiceList();
		SecurityDetectService tempService = null;
		int len = serviceList.size();
		for(int i=0; i<len; i++){
			if(serviceName.equals(serviceList.get(i).getServiceName())){
				tempService = serviceList.get(i);
				break;
			}
		}
		
		List<SecurityDetectItem> itemList = new ArrayList<SecurityDetectItem>();
		Set itemSet =  tempService.getSecurityDetectItems();
		SecurityDetectItem tempItem = new SecurityDetectItem();
		List<String> itemNameList = new ArrayList<String>();
		
		len = types.length;
		for(int i=0; i<len; i++){
			Iterator itr = itemSet.iterator();
			while(itr.hasNext()){
				tempItem = (SecurityDetectItem)itr.next();
				if(tempItem.getType().equals(types[i])){
					itemList.add(tempItem);
					itemNameList.add(tempItem.getItemName());
					pw.println(tempItem.getItemName());
				}
			}
		}
		
		request.setAttribute("itemNameList", itemNameList);
		//return itemList;
		pw.close();
		out.close();
		
		return "test";
	}
	public void testInterface() throws Exception{
		
	}
}
