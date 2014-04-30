package com.springinaction.hibernate.example;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * The Class HibernateTestDAO.
 */
@Repository
public class HibernateTestDAO implements HibernateExampleDAO {

	/** The s factory. */
	@Autowired
	SessionFactory sessionFactory;

	// public void update(HibernateTestVO testHibernate) {
	// sFactory.getCurrentSession().update(testHibernate);
	// }
	//
	// public void delete(HibernateTestVO testHibernate) {
	// sFactory.getCurrentSession().delete(testHibernate);
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.springinaction.hibernate.example.HibernateExampleDAO#readRowById(int)
	 */
	public HibernateTestVO readRowById(int id) {
		String hql = "FROM Test WHERE tx = :id";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		List<HibernateTestVO> results = query.list();
		if (results.size() > 0) {
			return results.get(0);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.springinaction.hibernate.example.HibernateExampleDAO#insertRow(com
	 * .springinaction.hibernate.example.HibernateTestVO)
	 */
	public void insertRow(HibernateTestVO hibernateTestVO) {
		sessionFactory.getCurrentSession().save(hibernateTestVO);
	}

	// public List<TestHibernate> getAllTestHibernates() {
	// String hql = "FROM Test ";
	// Query query = sFactory.getCurrentSession().createQuery(hql);
	// List<TestHibernate> results = query.list();
	// return results;
	// }

}
