package service.securityDetectItemManage;

import java.util.List;

import model.SecurityDetectItem;
import model.SecurityDetectService;

/** 
 * ��ȫ������ѯ�߼��ӿ���
 * @author QJX
 *
 */

public interface SecurityDetectItemQuery {
	/**
	 * ��ȫ���ҵ���б�
	 * @return ���ذ�ȫ���ҵ���б�
	 */
	public List<SecurityDetectService> getServiceList() throws Exception;
	
	/**
	 * ����������ѯ��ȫ���ҵ��
	 * @param id ��ȫ���ҵ��id
	 * @return ��������Ϊid�İ�ȫ���ҵ�����
	 */
	public SecurityDetectService getService(int id) throws Exception;
	
	/**
	 * ��ȫ������б�
	 * @return ���ذ�ȫ������б�
	 */
	public List<SecurityDetectItem> getItemList() throws Exception;
	
	/**
	 * ��ȫ������б�
	 * @return �����ض����͵İ�ȫ������б�
	 */
	public List<SecurityDetectItem> getItemListByType(String type) throws Exception;
	
	/**
	 * ����������ѯ��ȫ�����
	 * @param id ��ȫ�����id
	 * @return ��������Ϊid�İ�ȫ��������
	 */
	public SecurityDetectItem getItem(int id) throws Exception;
}
