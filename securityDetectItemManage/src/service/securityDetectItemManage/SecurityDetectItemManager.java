package service.securityDetectItemManage;

import java.util.List;

import service.securityDetectItemManage.action.SecurityDetectItemForm;

import model.SecurityDetectItem;

/**
 * 
 * @author QJX
 * ��ȫ������߼��ӿ���
 */

public interface SecurityDetectItemManager {
	/**
	 * ��ȫ������б�
	 * @return ���ذ�ȫ������б�
	 */
	public List<SecurityDetectItem> getItemList() throws Exception;
	
	/**
	 * ���밲ȫ�����
	 * @param form ��ȫ����������
	 */
	public void insertItem(SecurityDetectItemForm form) throws Exception;
	
	/**
	 * �޸İ�ȫ�����
	 * @param form ��ȫ����������
	 */
	public void modifyItem(SecurityDetectItemForm form) throws Exception;
	
	/**
	 * ɾ����ȫ�����
	 * @param ids ����id����
	 */
	public void deleteItem(String id) throws Exception;
	
	/**
	 * ����������ѯ��ȫ�����
	 * @param id ��ȫ�����id
	 * @return ��������Ϊid�İ�ȫ��������
	 */
	public SecurityDetectItem getItem(int id) throws Exception;

}
