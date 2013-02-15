package service.securityDetectItemManage;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.SecurityDetectItem;
import service.securityDetectItemManage.action.SecurityDetectItemForm;
import dao.SecurityDetectItemDAO;
import daoimpl.SecurityDetectItemDAOImpl;
import export2db.TestItem;

/**
 * ��ȫ������߼�ʵ����
 * @author QJX
 *
 */

public class SecurityDetectItemManagerImpl implements SecurityDetectItemManager{
	static Logger logger = Logger.getLogger(SecurityDetectItemManagerImpl.class.getName());
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private SecurityDetectItemDAOImpl dao = (SecurityDetectItemDAOImpl)context.getBean("SecurityDetectItemDAO");
	public SecurityDetectItemDAOImpl getDao(){
		return dao;
	}
	/**
	 * ��ȫ������б�
	 * @return ���ذ�ȫ������б�
	 */
	@Override
	public List<SecurityDetectItem> getItemList() throws Exception{
		logger.debug("Entering application.");
		List<SecurityDetectItem> itemList = dao.findAllSecurityDetectItem();
		logger.info("Exiting application.");
		return itemList;
	}
	
	/**
	 * ���밲ȫ�����
	 * @param form ��ȫ����������
	 */
	@Override
	public void insertItem(SecurityDetectItemForm form) throws Exception{
		SecurityDetectItem item = new SecurityDetectItem();
		item.setCreateTime(new Date());
		item.setDescription(form.getDescription());
		item.setItemName(form.getItemName());
		item.setType(form.getType());
		item.setSuggestionTools(form.getSuggestionTools());
		item.setItemInfo(form.getItemInfo());
		//����ð�ȫ�����
		dao.saveSecurityDetectItem(item);
	}
	
	/**
	 * �޸İ�ȫ�����
	 * @param form ��ȫ����������
	 */
	@Override
	public void modifyItem(SecurityDetectItemForm form) throws Exception{
		SecurityDetectItem item = dao.findSecurityDetectItemById(form.getId(), true);
		item.setDescription(form.getDescription());
		item.setItemName(form.getItemName());
		item.setSuggestionTools(form.getSuggestionTools());
		item.setType(form.getType());
		item.setItemInfo(form.getItemInfo());
		//item.setCreateTime(form.getCreateTime());
		item.setCreateTime(new Date());
		//���¸ð�ȫ�����
		dao.updateSecurityDetectItem(item, form.getId());
	}
	
	/**
	 * ɾ����ȫ�����
	 * @param ids ����id����
	 */
	@Override
	public void deleteItem(String id) throws Exception{
		SecurityDetectItem item = dao.findSecurityDetectItemById(Integer.parseInt(id), true);
		//ɾ���ð�ȫ�����
		if(item != null)
			dao.deleteSecurityDetectItem(item);
	}
	
	/**
	 * ����������ѯ��ȫ�����
	 * @param id ��ȫ�����id
	 * @return ��������Ϊid�İ�ȫ��������
	 */
	@Override
	public SecurityDetectItem getItem(int id) throws Exception{
		SecurityDetectItem item = dao.findSecurityDetectItemById(id, true);
		return item;
	}
}
