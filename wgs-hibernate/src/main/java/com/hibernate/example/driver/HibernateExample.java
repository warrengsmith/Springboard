package com.hibernate.example.driver;

import org.springframework.context.ApplicationContext;

import com.hibernate.example.dao.HibernateDAO;
import com.hibernate.example.dao.IHibernateDAO;
import com.hibernate.example.model.TestVO;

public class HibernateExample {
	
//	private final transient IHibernateDAO dao;
//	
//	public HibernateExample(final IHibernateDAO dao) {
//		this.dao = dao;
//	}

	public void process(ApplicationContext context) {
		IHibernateDAO dao = (HibernateDAO) context.getBean("hibernateDAO");
		TestVO testVO = new TestVO();
		testVO.setId(33);
		testVO.setName("Kirk Nelson");
		dao.insertRow(testVO);
		System.out.println(dao.readRowById(33));
	}
}
