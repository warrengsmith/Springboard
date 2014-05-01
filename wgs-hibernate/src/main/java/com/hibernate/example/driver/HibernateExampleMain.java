package com.hibernate.example.driver;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.example.dao.*;
import com.hibernate.example.model.*;

public class HibernateExampleMain {

	public static void main (String[] args) {
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("hibernate-example.xml");
		try {
		final HibernateDAO hibernateDAO = (HibernateDAO) context.getBean("hibernateDAO");
		TestVO testVO = new TestVO();
		testVO.setId(7);
		testVO.setName("Kirk Nelson");
		hibernateDAO.create(testVO);
		System.out.println(hibernateDAO.findOne(7));
		} finally {
			context.close();
		}
	}
}
