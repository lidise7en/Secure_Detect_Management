package dao;

import java.util.List;

import model.SecurityDetectItem;

public interface SecurityDetectItemDAO extends BaseDAO<SecurityDetectItem> {
	/** 返回安全检测项列表*/
	public List<SecurityDetectItem> findAllSecurityDetectItem();
	
	/** 按类型返回安全检测项列表 这样可以吗?*/
	public List<SecurityDetectItem> findSecurityDetectItemListByType(String type);
	
	/** 保存(新增)安全检测项*/
	public SecurityDetectItem saveSecurityDetectItem(SecurityDetectItem entity);
	
	/** 获取安全检测项*/
	public SecurityDetectItem findSecurityDetectItemById(int id, boolean lock);
	
	/** 更新(修改)安全检测项*/
	public SecurityDetectItem updateSecurityDetectItem(SecurityDetectItem entity, int id);
	
	/** 删除安全检测项*/
	public void deleteSecurityDetectItem(SecurityDetectItem entity);
}
