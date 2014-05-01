package com.hibernate.example.dao;

import org.springframework.stereotype.Repository;

import com.hibernate.example.model.TestVO;

/**
 * The Class HibernateDAO.
 */
@Repository
public class HibernateDAO extends AbstractHibernateDAO<TestVO> implements IHibernateDAO {

	    /**
    	 * Constructor instantiates a new hibernate dao.
    	 */
    	public HibernateDAO() {
	        super();
	        setClazz(TestVO.class);
	    }
	}
	
