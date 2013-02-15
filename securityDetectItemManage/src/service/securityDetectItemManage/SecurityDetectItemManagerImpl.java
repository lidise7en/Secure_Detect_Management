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
 * 安全检测项逻辑实现类
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
	 * 安全检测项列表
	 * @return 返回安全检测项列表
	 */
	@Override
	public List<SecurityDetectItem> getItemList() throws Exception{
		logger.debug("Entering application.");
		List<SecurityDetectItem> itemList = dao.findAllSecurityDetectItem();
		logger.info("Exiting application.");
		return itemList;
	}
	
	/**
	 * 插入安全检测项
	 * @param form 安全检测项表单对象
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
		//保存该安全检测项
		dao.saveSecurityDetectItem(item);
	}
	
	/**
	 * 修改安全检测项
	 * @param form 安全检测项表单对象
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
		//更新该安全检测项
		dao.updateSecurityDetectItem(item, form.getId());
	}
	
	/**
	 * 删除安全检测项
	 * @param ids 类型id数组
	 */
	@Override
	public void deleteItem(String id) throws Exception{
		SecurityDetectItem item = dao.findSecurityDetectItemById(Integer.parseInt(id), true);
		//删除该安全检测项
		if(item != null)
			dao.deleteSecurityDetectItem(item);
	}
	
	/**
	 * 根据主键查询安全检测项
	 * @param id 安全检测项id
	 * @return 返回主键为id的安全检测项对象
	 */
	@Override
	public SecurityDetectItem getItem(int id) throws Exception{
		SecurityDetectItem item = dao.findSecurityDetectItemById(id, true);
		return item;
	}
}
