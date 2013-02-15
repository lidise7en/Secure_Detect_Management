package service.securityDetectItemManage;

import java.util.List;
import service.securityDetectItemManage.action.SecurityDetectServiceForm;
import model.SecurityDetectService;
/**
 * 
 * @author QJXKID
 * ��ȫ���ҵ���߼��ӿ���
 */

public interface SecurityDetectServiceManager {
	/**
	 * ��ȫ���ҵ���б�
	 * @return ���ذ�ȫ���ҵ���б�
	 */
	public List<SecurityDetectService> getServiceList() throws Exception;
	
	/**
	 * ���밲ȫ���ҵ��
	 * @param form ��ȫ���ҵ�������
	 */
	public void insertService(SecurityDetectServiceForm form) throws Exception;
	
	/**
	 * �޸İ�ȫ���ҵ��
	 * @param form ��ȫ���ҵ�������
	 */
	public void modifyService(SecurityDetectServiceForm form) throws Exception;
	
	/**
	 * ɾ����ȫ���ҵ��
	 * @param ids ����id����
	 */
	public void deleteService(String id) throws Exception;
	
	/**
	 * ����������ѯ��ȫ���ҵ��
	 * @param id ��ȫ���ҵ��id
	 * @return ��������Ϊid�İ�ȫ���ҵ�����
	 */
	public SecurityDetectService getService(int id) throws Exception;
}
