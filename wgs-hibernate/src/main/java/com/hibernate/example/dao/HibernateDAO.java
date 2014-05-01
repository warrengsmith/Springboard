package com.hibernate.example.dao;

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
	
}
	
