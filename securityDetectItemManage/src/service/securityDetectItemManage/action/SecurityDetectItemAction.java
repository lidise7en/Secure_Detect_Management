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
 * ��ȫ���������Action
 * @author QJX
 *
 */
public class SecurityDetectItemAction extends ActionSupport implements
		ServletRequestAware {
	private HttpServletRequest request;

	//�Ƽ��İ�ȫ��⹤��,ȫ��
	String[] toolList ={"Nessus","Snort","Shadow Database Scanner","Nmap","X-scan","wlsc","ulsc"};

	
	/** ��ȫ������ */
	private SecurityDetectItemForm item;
	
	/** ��ȫ����������߼��� */
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
	 * ��ð�ȫ������б���Ϣ
	 * @return ��ת����ȫ������б���ʾҳ��
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
	 * ��tools������ת�����ɶ��ŷָ��String
	 * @return ת�����String
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
	 * ��tools���ɶ��ŷָ��Stringת��������
	 * @return ת�����String����
	 */
	private String[] toolsStringToArray(String toolsString){

		String[] toolsArray = toolsString.split(",");
		return toolsArray;
	}
	
	/**
	 * ��ʼ����Ӱ�ȫ�����ҳ��,��Ҫ������Ƽ����ߵĳ�ʼ��
	 * @return ��ת����Ӱ�ȫ������ҳ��
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
	 * ���氲ȫ���������
	 * @return ��ת����ȫ������б���ʾ��Action·��
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
		if(itemtype.equals("GSM��WCDMA���簲ȫ���")){
			String tempList[] = {"Nessus", "Snort"};
			toolList = tempList;
		}
		else if(itemtype.equals("3G���簲ȫ���")){
			String tempList[] = {"Nessus", "Snort"};
			toolList = tempList;
		}
		else if(itemtype.equals("WEB������©�����")){
			String tempList[] = {"Webscan", "Acunetix Web Vulnerability Scanner"};
			toolList = tempList;
		}
		else if(itemtype.equals("����ǽ��ȫ���")){
			String tempList[] = {"Nessus", "Nmap", "Snort"};
			toolList = tempList;
		}
		else if(itemtype.equals("�����豸��ȫ���")){
			String tempList[] = {"Nessus", "wlsc", "ulsc", "X-scan", "Nmap"};
			toolList = tempList;
		}
		else if(itemtype.equals("���ݿⰲȫ���")){
			String tempList[] = {"Shadow Database Scanner"};
			toolList = tempList;
		}
		else if(itemtype.equals("�ӿ�Э�鰲ȫ���")){
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
		tempitem.setToolsArray(toolsStringToArray(tempitem.getSuggestionTools()));
		//tempitem.setCreateTime(itemObj.getCreateTime());
		return tempitem;
	}
	
	/**
	 * ��ʼ���޸İ�ȫ��������ͽ���
	 * @return ��ת���޸İ�ȫ��������ͽ���
	 */
	public String initUpdate() throws Exception{
		String id = request.getParameter("id");
		SecurityDetectItem itemObj = itemManager.getItem(Integer.parseInt(id));
		item = itemToItemForm(itemObj);
		request.setAttribute("toolList", toolList);
		return "update";
	}
	
	/**
	 * �޸İ�ȫ�����
	 * @return ��ת����ȫ������б���ʾ��Action·��
	 */
	public String update() throws Exception{
		String id = request.getParameter("id");
		item.setSuggestionTools(toolsArrayToString(item.getToolsArray()));
		itemManager.modifyItem(item);
		return "list";
	}
	
	/**
	 * ɾ����ȫ�����
	 * @return ��ת����ȫ������б���ʾ��Action·��
	 */
	public String delete() throws Exception{
		String id = request.getParameter("id");
		itemManager.deleteItem(id);
		return this.list();
	}
}
