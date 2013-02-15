package service.securityDetectItemManage;

import java.util.List;
import service.securityDetectItemManage.action.SecurityDetectServiceForm;
import model.SecurityDetectService;
/**
 * 
 * @author QJXKID
 * 安全检测业务逻辑接口类
 */

public interface SecurityDetectServiceManager {
	/**
	 * 安全检测业务列表
	 * @return 返回安全检测业务列表
	 */
	public List<SecurityDetectService> getServiceList() throws Exception;
	
	/**
	 * 插入安全检测业务
	 * @param form 安全检测业务表单对象
	 */
	public void insertService(SecurityDetectServiceForm form) throws Exception;
	
	/**
	 * 修改安全检测业务
	 * @param form 安全检测业务表单对象
	 */
	public void modifyService(SecurityDetectServiceForm form) throws Exception;
	
	/**
	 * 删除安全检测业务
	 * @param ids 类型id数组
	 */
	public void deleteService(String id) throws Exception;
	
	/**
	 * 根据主键查询安全检测业务
	 * @param id 安全检测业务id
	 * @return 返回主键为id的安全检测业务对象
	 */
	public SecurityDetectService getService(int id) throws Exception;
}
