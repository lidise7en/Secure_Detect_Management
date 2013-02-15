package service.securityDetectItemManage;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.SecurityDetectItemDAO;
import dao.SecurityDetectServiceDAO;
import daoimpl.SecurityDetectItemDAOImpl;
import daoimpl.SecurityDetectServiceDAOImpl;

import model.SecurityDetectItem;
import model.SecurityDetectService;

public class SecurityDetectItemQueryImpl implements SecurityDetectItemQuery {
	
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private SecurityDetectItemDAOImpl itemDao = (SecurityDetectItemDAOImpl)context.getBean("SecurityDetectItemDAO");
	public SecurityDetectItemDAOImpl getItemDao(){
		return itemDao;
	}
	
	private SecurityDetectServiceDAOImpl serviceDao = (SecurityDetectServiceDAOImpl)context.getBean("SecurityDetectServiceDAO");
	
	public SecurityDetectServiceDAOImpl getServiceDao(){
		return serviceDao;
	}
	
	@Override
	public List<SecurityDetectService> getServiceList() throws Exception {
		// TODO Auto-generated method stub
		List<SecurityDetectService> serviceList = serviceDao.findAllSecurityDetectService();
		return serviceList;
	}

	@Override
	public SecurityDetectService getService(int id) throws Exception {
		// TODO Auto-generated method stub
		SecurityDetectService service = serviceDao.findSecurityDetectServiceById(id, true);
		return service;
	}

	@Override
	public List<SecurityDetectItem> getItemList() throws Exception {
		// TODO Auto-generated method stub
		List<SecurityDetectItem> itemList = itemDao.findAllSecurityDetectItem();
		return itemList;
	}

	@Override
	public SecurityDetectItem getItem(int id) throws Exception {
		// TODO Auto-generated method stub
		SecurityDetectItem item = itemDao.findSecurityDetectItemById(id, true);
		return item;
	}

	@Override
	public List<SecurityDetectItem> getItemListByType(String type)
			throws Exception {
		// TODO Auto-generated method stub
		List<SecurityDetectItem> itemList = itemDao.findSecurityDetectItemListByType(type);
		return itemList;
	}

}
