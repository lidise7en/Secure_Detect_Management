package dao;

import java.util.List;

import model.SecurityDetectService;

public interface SecurityDetectServiceDAO extends BaseDAO<SecurityDetectService> {

	/** 返回安全检测业务列表*/
	public List<SecurityDetectService> findAllSecurityDetectService();
	
	/** 保存(新增)安全检测业务*/
	public SecurityDetectService saveSecurityDetectService(SecurityDetectService entity);
	
	/** 获取安全检测业务*/
	public SecurityDetectService findSecurityDetectServiceById(int id, boolean lock);
	
	/** 更新(修改)安全检测业务*/
	public SecurityDetectService updateSecurityDetectService(SecurityDetectService entity, int id);
	
	/** 删除安全检测业务*/
	public void deleteSecurityDetectService(SecurityDetectService entity);
}
