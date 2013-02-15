package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface BaseDAO<T> {
     public T findById(int id, boolean lock);
     public List<T> findAll();
     public List<T> findByCriteria(Criterion... criterion);
     public void delete(T entity);
     public T save(T entity);
     public T update(T entity, int id);
     public T update(T entity); 
     public void merge(T entity);
     public List<T> dmpAll();  
}
