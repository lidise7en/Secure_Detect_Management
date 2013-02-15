package service.securityDetectItemManage;

import java.util.List;

import service.securityDetectItemManage.action.SecurityDetectItemForm;

import model.SecurityDetectItem;

/**
 * 
 * @author QJX
 * 安全检测项逻辑接口类
 */

public interface SecurityDetectItemManager {
	/**
	 * 安全检测项列表
	 * @return 返回安全检测项列表
	 */
	public List<SecurityDetectItem> getItemList() throws Exception;
	
	/**
	 * 插入安全检测项
	 * @param form 安全检测项表单对象
	 */
	public void insertItem(SecurityDetectItemForm form) throws Exception;
	
	/**
	 * 修改安全检测项
	 * @param form 安全检测项表单对象
	 */
	public void modifyItem(SecurityDetectItemForm form) throws Exception;
	
	/**
	 * 删除安全检测项
	 * @param ids 类型id数组
	 */
	public void deleteItem(String id) throws Exception;
	
	/**
	 * 根据主键查询安全检测项
	 * @param id 安全检测项id
	 * @return 返回主键为id的安全检测项对象
	 */
	public SecurityDetectItem getItem(int id) throws Exception;

}
