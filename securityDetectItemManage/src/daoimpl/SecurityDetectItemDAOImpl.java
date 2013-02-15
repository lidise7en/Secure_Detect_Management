package daoimpl;

import java.util.List;

import model.SecurityDetectItem;
import model.SecurityDetectService;

import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import dao.SecurityDetectItemDAO;

public class SecurityDetectItemDAOImpl<T> extends BaseDAOImpl<SecurityDetectItem> implements SecurityDetectItemDAO{


	
	public SecurityDetectItemDAOImpl() {
		super(SecurityDetectItem.class);
		// TODO Auto-generated constructor stub
	}
	


	@Override
	//返回所有的安全检测项
	public List<SecurityDetectItem> findAllSecurityDetectItem() {
		 //TODO Auto-generated method stub
		Query query = getSession().createQuery("from SecurityDetectItem");
		return query.list();
	}

	@Override
	public List<SecurityDetectItem> findSecurityDetectItemListByType(String type) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from SecurityDetectItem where type=" + "'" + type + "'"  );
		return query.list();
	}

	@Override
	public SecurityDetectItem saveSecurityDetectItem(SecurityDetectItem entity) {
		 //TODO Auto-generated method stub
		 getHibernateTemplate().save(entity);
	        getHibernateTemplate().flush(); 
	        return entity;
	}
	
	@Override
	public SecurityDetectItem findSecurityDetectItemById(int id, boolean lock) {
		// TODO Auto-generated method stub
		
		SecurityDetectItem entity;
        if (lock) {
            entity = (SecurityDetectItem) getHibernateTemplate().get(getPersistentClass(), id,
                    LockMode.UPGRADE);
        } else {
            entity = (SecurityDetectItem) getHibernateTemplate().get(getPersistentClass(), id);
        }

        return entity;
	}

	@Override
	public SecurityDetectItem updateSecurityDetectItem(
			SecurityDetectItem entity, int id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(String.valueOf(id),entity);
		getHibernateTemplate().flush(); 
		return entity;
	}

	@Override
	public void deleteSecurityDetectItem(SecurityDetectItem entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(entity);
	}
	}
