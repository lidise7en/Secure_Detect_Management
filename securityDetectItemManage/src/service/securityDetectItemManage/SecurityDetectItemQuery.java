package service.securityDetectItemManage;

import java.util.List;

import model.SecurityDetectItem;
import model.SecurityDetectService;

/** 
 * 安全检测项查询逻辑接口类
 * @author QJX
 *
 */

public interface SecurityDetectItemQuery {
	/**
	 * 安全检测业务列表
	 * @return 返回安全检测业务列表
	 */
	public List<SecurityDetectService> getServiceList() throws Exception;
	
	/**
	 * 根据主键查询安全检测业务
	 * @param id 安全检测业务id
	 * @return 返回主键为id的安全检测业务对象
	 */
	public SecurityDetectService getService(int id) throws Exception;
	
	/**
	 * 安全检测项列表
	 * @return 返回安全检测项列表
	 */
	public List<SecurityDetectItem> getItemList() throws Exception;
	
	/**
	 * 安全检测项列表
	 * @return 返回特定类型的安全检测项列表
	 */
	public List<SecurityDetectItem> getItemListByType(String type) throws Exception;
	
	/**
	 * 根据主键查询安全检测项
	 * @param id 安全检测项id
	 * @return 返回主键为id的安全检测项对象
	 */
	public SecurityDetectItem getItem(int id) throws Exception;
}
