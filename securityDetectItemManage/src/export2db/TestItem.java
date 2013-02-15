package export2db;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.SecurityDetectItem;
import model.SecurityDetectService;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import daoimpl.SecurityDetectItemDAOImpl;
import daoimpl.SecurityDetectServiceDAOImpl;

public class TestItem extends ActionSupport{
	 static Logger logger = Logger.getLogger(TestItem.class.getName());
	 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	 SecurityDetectItemDAOImpl securityDetectItemdaoimpl= (SecurityDetectItemDAOImpl)context.getBean("SecurityDetectItemDAO");
	 //logger.appenderName = logFile;
	      
	 SecurityDetectServiceDAOImpl dao = (SecurityDetectServiceDAOImpl)context.getBean("SecurityDetectServiceDAO");
	
	 public String success() throws Exception {
		DOMConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.xml"));
		System.out.println("hello world");
		

		//SecurityDetectItem i3 = new SecurityDetectItem();
		//SecurityDetectItem t1 = SecurityDetectItemdaoimpl.findById(1, true);
		//System.out.println(t.getName());
		//t.setId(1);
		//SecurityDetectItemdaoimpl.update(t1);
		//securityDetectItemdaoimpl.saveSecurityDetectItem(t);
		//System.out.println(securityDetectItemdaoimpl.findAllSecurityDetectItem().toString());
		//System.out.println(securityDetectItemdaoimpl.findSecurityDetectItemListByType("hw").toString());
		//System.out.println(securityDetectItemdaoimpl.findSecurityDetectItemById(4, true) .toString());
		//i3.setItemName("hhhhhhhhhh");
		//i3.setId(11);
		//securityDetectItemdaoimpl.updateSecurityDetectItem(i3,11);
		//System.out.println(SecurityDetectItemdaoimpl.getIdeaAmount());
	      //PropertyConfigurator.configure(args[0]);
		/*
		SecurityDetectItem stu = new SecurityDetectItem();
		stu.setId(22);
		stu.setItemName("不能中文吗?");
		securityDetectItemdaoimpl.saveSecurityDetectItem(stu);
		
		SecurityDetectService abc = new SecurityDetectService();
		abc.setServiceName("service");
		Set SecurityDetectItems = new HashSet();
		SecurityDetectItem temp = securityDetectItemdaoimpl.findSecurityDetectItemById(36, true);
		SecurityDetectItems.add(temp);
		abc.setSecurityDetectItems(SecurityDetectItems);
		dao.saveSecurityDetectService(abc);
		
		SecurityDetectItems = new HashSet();
		SecurityDetectItem temp2 = securityDetectItemdaoimpl.findSecurityDetectItemById(37, true);
		SecurityDetectItems.add(temp2);
		abc.setSecurityDetectItems(SecurityDetectItems);
		dao.updateSecurityDetectService(abc, 46);
		*/
		/*
		SecurityDetectService abc = dao.findSecurityDetectServiceById(44, true);
		Set SecurityDetectItems = abc.getSecurityDetectItems();
		SecurityDetectItem temp;
		Iterator i=SecurityDetectItems.iterator();
		while(i.hasNext()){
			temp=(SecurityDetectItem)i.next();
			System.out.println(temp.getItemName());
		}
		*/
		/*
		List<SecurityDetectService> serviceList = dao.findAllSecurityDetectService();
		SecurityDetectService abc = serviceList.get(0);
		Set SecurityDetectItems = abc.getSecurityDetectItems();
		SecurityDetectItem temp;
		Iterator i=SecurityDetectItems.iterator();
		while(i.hasNext()){
			temp=(SecurityDetectItem)i.next();
			System.out.println(temp.getItemName());
		}*/
		SecurityDetectItem temp = securityDetectItemdaoimpl.findSecurityDetectItemById(37, true);
		Set SecurityDetectServices = temp.getSecurityDetectServices();
		SecurityDetectService service;
		Iterator i=SecurityDetectServices.iterator();
		while(i.hasNext()){
			service=(SecurityDetectService)i.next();
			System.out.println(service.getServiceName());
		}
		//securityDetectItemdaoimpl.deleteSecurityDetectItem(stu );
	      logger.debug("Entering application.");
	      logger.info("Exiting application.");
        return "SUCESS";
    

	 }
	private Object getSession() {
		// TODO Auto-generated method stub
		return null;
	}}
