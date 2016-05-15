package com.daphne.lazulite.common.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.jdbc.Work;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public abstract class HibernateRespository<M, ID extends Serializable>{
	
	public List<Object[]> executeSql(String sql,Object... objs) {
		// TODO Auto-generated method stub
		Query query=getEm().createNativeQuery(sql);
		for(int i=0;i<objs.length;i++){
			query.setParameter(i+1, objs[i]);
		}
		return query.getResultList();
	}


	public List<M> executeCriteria(Criterion... criterions) {
		// TODO Auto-generated method stub
		Session session= (Session)getEm().getDelegate();
		Criteria criteria = session.createCriteria(getEntityClass());
        for (Criterion c : criterions)
        {
            criteria.add(c);
        }
		
		return criteria.list();
	}
	
	public void doWork(Work work){
		Session session= (Session)getEm().getDelegate();
		session.doWork(work);
	}
	
	

	abstract protected Class getEntityClass();

	public abstract EntityManager getEm();



}
