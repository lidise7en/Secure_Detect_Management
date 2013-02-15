package service.securityDetectItemManage;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.securityDetectItemManage.action.SecurityDetectServiceForm;
import model.SecurityDetectService;
import dao.SecurityDetectServiceDAO;
import daoimpl.SecurityDetectServiceDAOImpl;

/**
 * ��ȫ���ҵ�������߼�ʵ����
 * @author QJX
 *
 */
public class SecurityDetectServiceManagerImpl implements SecurityDetectServiceManager{
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	private SecurityDetectServiceDAOImpl dao = (SecurityDetectServiceDAOImpl)context.getBean("SecurityDetectServiceDAO");
	
	public SecurityDetectServiceDAOImpl getDao(){
		return dao;
	}
	
	/**
	 * ��ȫ���ҵ���б�
	 * @return ���ذ�ȫ���ҵ���б�
	 */
	@Override
	public List<SecurityDetectService> getServiceList() throws Exception{
		List<SecurityDetectService> serviceList = dao.findAllSecurityDetectService();
		return serviceList;
	}
	
	/**
	 * ���밲ȫ���ҵ��
	 * @param form ��ȫ���ҵ�������
	 */
	@Override
	public void insertService(SecurityDetectServiceForm form) throws Exception{
		SecurityDetectService service = new SecurityDetectService();
		service.setCreateTime(new Date());
		service.setDescription(form.getDescription());
		service.setServiceName(form.getServiceName());
		service.setSecurityDetectItems(form.getSecurityDetectItems());
		service.setServiceInfo(form.getServiceInfo());
		//����ð�ȫ���ҵ��
		dao.saveSecurityDetectService(service);
	}
	
	/**
	 * �޸İ�ȫ���ҵ��
	 * @param form ��ȫ���ҵ�������
	 */
	@Override
	public void modifyService(SecurityDetectServiceForm form) throws Exception{
		SecurityDetectService service = dao.findSecurityDetectServiceById(form.getId(), true);
		service.setDescription(form.getDescription());
		service.setServiceName(form.getServiceName());
		service.setSecurityDetectItems(form.getSecurityDetectItems());
		service.setCreateTime(new Date());
		//���氲ȫ���ҵ��
		dao.updateSecurityDetectService(service, form.getId());
	}
	
	/**
	 * ɾ����ȫ���ҵ��
	 * @param ids ����id����
	 */
	@Override
	public void deleteService(String id) throws Exception{
		SecurityDetectService service = dao.findSecurityDetectServiceById(Integer.parseInt(id), true);
		//ɾ���ð�ȫ���ҵ��
		dao.deleteSecurityDetectService(service);
	}
	/**
	 * ����������ѯ��ȫ���ҵ��
	 * @param id ��ȫ���ҵ��id
	 * @return ��������Ϊid�İ�ȫ���ҵ�����
	 */
	@Override
	public SecurityDetectService getService(int id) throws Exception{
		SecurityDetectService service = dao.findSecurityDetectServiceById(id, true);
		return service;
	}
}
