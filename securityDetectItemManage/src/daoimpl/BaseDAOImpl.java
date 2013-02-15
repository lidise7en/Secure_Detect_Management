package daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BaseDAO;

public class BaseDAOImpl<T> extends HibernateDaoSupport  
   implements BaseDAO<T> {
	private Class<T> persistentClass;
	public BaseDAOImpl(Class<T> persistentClass) {
    	//System.out.println("GenericHibernateDAO constructor");
        this.persistentClass = persistentClass;
    }
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public List<T> dmpAll() {
		// TODO Auto-generated method stub
		return findByCriteria();
	}
	public List<T> findByCriteria(Criterion... criterion) {
		// TODO Auto-generated method stub
		Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
	
        return crit.list();
	}
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return findByCriteria();
	}
	public T findById(int id, boolean lock) {
		// TODO Auto-generated method stub
		  T entity;
	        if (lock) {
	            entity = (T) getHibernateTemplate().get(getPersistentClass(), id,
	                    LockMode.UPGRADE);
	        } else {
	            entity = (T) getHibernateTemplate().get(getPersistentClass(), id);
	        }

	        return entity;
	}
	public void delete(T entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(entity);
	}
	public void merge(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().merge(entity);
	}
	public T save(T entity) {
		// TODO Auto-generated method stub
        getHibernateTemplate().save(entity);
        getHibernateTemplate().flush(); 
        return entity;
		}
	public T update(T entity, int id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(String.valueOf(id),entity);
		getHibernateTemplate().flush(); 
		return entity;
	}
	public T update(T entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().merge(entity);
		return entity;
	}    
}
