package daoimpl;

import java.util.List;

import model.SecurityDetectItem;
import model.SecurityDetectService;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.SecurityDetectItemDAO;
import dao.SecurityDetectServiceDAO;

public class SecurityDetectServiceDAOImpl<T> extends BaseDAOImpl<SecurityDetectService> implements SecurityDetectServiceDAO{



	public SecurityDetectServiceDAOImpl() {
		super(SecurityDetectService.class);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	//返回所有的安全检测项
	public List<SecurityDetectService> findAllSecurityDetectService() {
		 //TODO Auto-generated method stub
		Query query = getSession().createQuery("from SecurityDetectService");
		return query.list();
	}


	@Override
	public SecurityDetectService saveSecurityDetectService(SecurityDetectService entity) {
		 //TODO Auto-generated method stub
		 getHibernateTemplate().save(entity);
	        getHibernateTemplate().flush(); 
	        return entity;
	}

	@Override
	public SecurityDetectService findSecurityDetectServiceById(int id, boolean lock) {
		// TODO Auto-generated method stub
		
		SecurityDetectService entity;
        if (lock) {
            entity = (SecurityDetectService) getHibernateTemplate().get(getPersistentClass(), id,
                    LockMode.UPGRADE);
        } else {
            entity = (SecurityDetectService) getHibernateTemplate().get(getPersistentClass(), id);
        }

        return entity;
	}

	@Override
	public SecurityDetectService updateSecurityDetectService(
			SecurityDetectService entity, int id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(String.valueOf(id),entity);
		getHibernateTemplate().flush(); 
		return entity;
	}

	@Override
	public void deleteSecurityDetectService(SecurityDetectService entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(entity);
	}


	
	}
