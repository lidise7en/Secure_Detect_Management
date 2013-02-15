package dao;

import java.util.List;

import model.SecurityDetectItem;

public interface SecurityDetectItemDAO extends BaseDAO<SecurityDetectItem> {
	/** ���ذ�ȫ������б�*/
	public List<SecurityDetectItem> findAllSecurityDetectItem();
	
	/** �����ͷ��ذ�ȫ������б� ����������?*/
	public List<SecurityDetectItem> findSecurityDetectItemListByType(String type);
	
	/** ����(����)��ȫ�����*/
	public SecurityDetectItem saveSecurityDetectItem(SecurityDetectItem entity);
	
	/** ��ȡ��ȫ�����*/
	public SecurityDetectItem findSecurityDetectItemById(int id, boolean lock);
	
	/** ����(�޸�)��ȫ�����*/
	public SecurityDetectItem updateSecurityDetectItem(SecurityDetectItem entity, int id);
	
	/** ɾ����ȫ�����*/
	public void deleteSecurityDetectItem(SecurityDetectItem entity);
}
