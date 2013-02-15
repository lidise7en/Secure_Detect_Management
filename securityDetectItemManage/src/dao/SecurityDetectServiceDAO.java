package dao;

import java.util.List;

import model.SecurityDetectService;

public interface SecurityDetectServiceDAO extends BaseDAO<SecurityDetectService> {

	/** ���ذ�ȫ���ҵ���б�*/
	public List<SecurityDetectService> findAllSecurityDetectService();
	
	/** ����(����)��ȫ���ҵ��*/
	public SecurityDetectService saveSecurityDetectService(SecurityDetectService entity);
	
	/** ��ȡ��ȫ���ҵ��*/
	public SecurityDetectService findSecurityDetectServiceById(int id, boolean lock);
	
	/** ����(�޸�)��ȫ���ҵ��*/
	public SecurityDetectService updateSecurityDetectService(SecurityDetectService entity, int id);
	
	/** ɾ����ȫ���ҵ��*/
	public void deleteSecurityDetectService(SecurityDetectService entity);
}
