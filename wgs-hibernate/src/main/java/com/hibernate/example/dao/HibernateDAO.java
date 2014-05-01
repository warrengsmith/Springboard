package com.hibernate.example.dao;

import java.util.List;






import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.example.model.TestVO;

@Repository
public class HibernateDAO implements IHibernateDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertRow(TestVO test) {
		sessionFactory.getCurrentSession().save(test);
	}

	@Override
	public TestVO readRowById(int id) {
		TestVO result = null;
		String hql = "FROM Test WHERE tx = :id";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<TestVO> results = query.list();
		if (results.size() > 0) {
			result = results.get(0);
		}
		return result;
	}
}
	
