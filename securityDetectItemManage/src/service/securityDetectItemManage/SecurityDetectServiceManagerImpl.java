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
 * 安全检测业务管理的逻辑实现类
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
	 * 安全检测业务列表
	 * @return 返回安全检测业务列表
	 */
	@Override
	public List<SecurityDetectService> getServiceList() throws Exception{
		List<SecurityDetectService> serviceList = dao.findAllSecurityDetectService();
		return serviceList;
	}
	
	/**
	 * 插入安全检测业务
	 * @param form 安全检测业务表单对象
	 */
	@Override
	public void insertService(SecurityDetectServiceForm form) throws Exception{
		SecurityDetectService service = new SecurityDetectService();
		service.setCreateTime(new Date());
		service.setDescription(form.getDescription());
		service.setServiceName(form.getServiceName());
		service.setSecurityDetectItems(form.getSecurityDetectItems());
		service.setServiceInfo(form.getServiceInfo());
		//保存该安全检测业务
		dao.saveSecurityDetectService(service);
	}
	
	/**
	 * 修改安全检测业务
	 * @param form 安全检测业务表单对象
	 */
	@Override
	public void modifyService(SecurityDetectServiceForm form) throws Exception{
		SecurityDetectService service = dao.findSecurityDetectServiceById(form.getId(), true);
		service.setDescription(form.getDescription());
		service.setServiceName(form.getServiceName());
		service.setSecurityDetectItems(form.getSecurityDetectItems());
		service.setCreateTime(new Date());
		//保存安全检测业务
		dao.updateSecurityDetectService(service, form.getId());
	}
	
	/**
	 * 删除安全检测业务
	 * @param ids 类型id数组
	 */
	@Override
	public void deleteService(String id) throws Exception{
		SecurityDetectService service = dao.findSecurityDetectServiceById(Integer.parseInt(id), true);
		//删除该安全检测业务
		dao.deleteSecurityDetectService(service);
	}
	/**
	 * 根据主键查询安全检测业务
	 * @param id 安全检测业务id
	 * @return 返回主键为id的安全检测业务对象
	 */
	@Override
	public SecurityDetectService getService(int id) throws Exception{
		SecurityDetectService service = dao.findSecurityDetectServiceById(id, true);
		return service;
	}
}
