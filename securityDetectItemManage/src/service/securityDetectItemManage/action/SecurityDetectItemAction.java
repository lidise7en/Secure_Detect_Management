package service.securityDetectItemManage.action;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.SecurityDetectItem;
import model.SecurityDetectService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.securityDetectItemManage.SecurityDetectItemManager;
import service.securityDetectItemManage.SecurityDetectItemManagerImpl;

import com.opensymphony.xwork2.ActionSupport;

import export2db.Hu;
import export2db.TestItem;

/**
 * 安全检测项管理的Action
 * @author QJX
 *
 */
public class SecurityDetectItemAction extends ActionSupport implements
		ServletRequestAware {
	private HttpServletRequest request;

	//推荐的安全检测工具,全部
	String[] toolList ={"Nessus","Snort","Shadow Database Scanner","Nmap","X-scan","wlsc","ulsc"};

	
	/** 安全检测项表单 */
	private SecurityDetectItemForm item;
	
	/** 安全检测项管理的逻辑类 */
	private SecurityDetectItemManagerImpl itemManager = new SecurityDetectItemManagerImpl();
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	public SecurityDetectItemForm getItem(){
		return item;
	}
	public void setItem(SecurityDetectItemForm item){
		this.item = item;
	}
	
	public SecurityDetectItemManagerImpl getItemManager(){
		return itemManager;
	}
	public void setItemManager(SecurityDetectItemManagerImpl itemManager){
		this.itemManager = itemManager;
	}
	
	/**
	 * 获得安全检测项列表信息
	 * @return 跳转到安全检测项列表显示页面
	 */
	public String list() throws Exception{
		List<SecurityDetectItem> itemList = itemManager.getItemList();
		request.setAttribute("itemList",itemList);
		return "list";
	}
	
	public String listByType() throws Exception{
		
		List<SecurityDetectItem> itemList1 = itemManager.getItemList();
		
		List<SecurityDetectItem> itemList = new ArrayList<SecurityDetectItem>();
		List<String> typeList = new ArrayList<String>();
		Iterator itr = itemList1.iterator();
		while(itr.hasNext()){
			typeList.add(((SecurityDetectItem)itr.next()).getType());
		}
		HashSet h = new HashSet(typeList);
		typeList.clear();
		typeList.addAll(h);
		
		itr = typeList.iterator();
		Iterator itr2 = itemList1.iterator();
		while(itr.hasNext()){
			String tempType = (String)itr.next();
			while(itr2.hasNext()){
				SecurityDetectItem tempItem = (SecurityDetectItem)itr2.next();
				if(tempItem.getType().equals(tempType)){
					itemList.add(tempItem);
				}
			}
			itr2 = itemList1.iterator();
		}

		request.setAttribute("itemList",itemList);
		return "list";
	}
	
	
	/**
	 * 将tools的数组转换成由逗号分割的String
	 * @return 转换后的String
	 */
	private String toolsArrayToString(String[] toolsArray){
		String toolstemp = new String();
		String[] temp = toolsArray;
		int l = temp.length;
		for(int i=0; i<l; i++){
			toolstemp += temp[i];
			if(i!=l-1) toolstemp += ",";
		}
		return toolstemp;
	}
	/**
	 * 将tools的由逗号分割的String转换成数组
	 * @return 转换后的String数组
	 */
	private String[] toolsStringToArray(String toolsString){

		String[] toolsArray = toolsString.split(",");
		return toolsArray;
	}
	
	/**
	 * 初始化添加安全检测项页面,主要是添加推荐工具的初始化
	 * @return 跳转到添加安全检测项的页面
	 * @throws Exception
	 */
	public String initAdd() throws Exception{
//		request.setAttribute("toolList", toolList);
		return "add";
	}
/*
	public String changeTools() throws Exception{
		FileOutputStream out = new FileOutputStream("D:/b.txt");
		PrintWriter pw = new PrintWriter(out);
		//String testtype = request.getParameter("type");
		String testtype=new String(request.getParameter("type").getBytes("ISO8859-1"),"UTF-8");
		if (testtype==null)
			pw.println("what's up?!");
		else
			pw.println(testtype);
		if(testtype!=null){
			String[] toolList2 = new String[4];
			toolList2[0]="1";
			toolList2[1]="2";
			toolList2[2]="3";
			toolList2[3]=testtype;
			toolList = toolList2;
		}
		pw.close();
		out.close();
		return this.initAdd();
	}
*/	
	/**
	 * 保存安全检测项类型
	 * @return 跳转到安全检测项列表显示的Action路径
	 */
	public String add() throws Exception{
		//
		List<SecurityDetectItem> itemList = itemManager.getItemList();
		Iterator itr = itemList.iterator();
		while (itr.hasNext()) {
			SecurityDetectItem nextObj = (SecurityDetectItem)itr.next();
			if(nextObj.getItemName().equals(item.getItemName()))
			{
				return this.initAdd();
			}
		}
		
		//itemManager.insertItem(item);
		//return "list";
		String itemtype = item.getType();
		//String toolList[];
		if(itemtype.equals("GSM，WCDMA网络安全检测")){
			String tempList[] = {"Nessus", "Snort"};
			toolList = tempList;
		}
		else if(itemtype.equals("3G网络安全检测")){
			String tempList[] = {"Nessus", "Snort"};
			toolList = tempList;
		}
		else if(itemtype.equals("WEB攻击及漏洞检测")){
			String tempList[] = {"Webscan", "Acunetix Web Vulnerability Scanner"};
			toolList = tempList;
		}
		else if(itemtype.equals("防火墙安全检测")){
			String tempList[] = {"Nessus", "Nmap", "Snort"};
			toolList = tempList;
		}
		else if(itemtype.equals("主机设备安全检测")){
			String tempList[] = {"Nessus", "wlsc", "ulsc", "X-scan", "Nmap"};
			toolList = tempList;
		}
		else if(itemtype.equals("数据库安全检测")){
			String tempList[] = {"Shadow Database Scanner"};
			toolList = tempList;
		}
		else if(itemtype.equals("接口协议安全检测")){
			String tempList[] = {"Nessus", "Nmap", "X-scan"};
			toolList = tempList;
		}
		request.setAttribute("toolList", toolList);
		return "selectTools";
	}
	
	public String selectTools() throws Exception{
		
		item.setSuggestionTools(toolsArrayToString(item.getToolsArray()));
		
		itemManager.insertItem(item);
		
		return "list";
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
		tempitem.setToolsArray(toolsStringToArray(tempitem.getSuggestionTools()));
		//tempitem.setCreateTime(itemObj.getCreateTime());
		return tempitem;
	}
	
	/**
	 * 初始化修改安全检测项类型界面
	 * @return 跳转到修改安全检测项类型界面
	 */
	public String initUpdate() throws Exception{
		String id = request.getParameter("id");
		SecurityDetectItem itemObj = itemManager.getItem(Integer.parseInt(id));
		item = itemToItemForm(itemObj);
		request.setAttribute("toolList", toolList);
		return "update";
	}
	
	/**
	 * 修改安全检测项
	 * @return 跳转到安全检测项列表显示的Action路径
	 */
	public String update() throws Exception{
		String id = request.getParameter("id");
		item.setSuggestionTools(toolsArrayToString(item.getToolsArray()));
		itemManager.modifyItem(item);
		return "list";
	}
	
	/**
	 * 删除安全检测项
	 * @return 跳转到安全检测项列表显示的Action路径
	 */
	public String delete() throws Exception{
		String id = request.getParameter("id");
		itemManager.deleteItem(id);
		return this.list();
	}
}
