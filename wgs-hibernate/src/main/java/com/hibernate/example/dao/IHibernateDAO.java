package com.hibernate.example.dao;

import com.hibernate.example.model.TestVO;

/**
 * The Interface IHibernateDAO.
 */
public interface IHibernateDAO {

	public void insertRow(TestVO test);
	
	public TestVO readRowById(int id);
	
}
