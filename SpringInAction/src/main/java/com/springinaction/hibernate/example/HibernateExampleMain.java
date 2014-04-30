package com.springinaction.hibernate.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateExampleMain {

	public static void main (String[] args) {
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("hibernate-example.xml");
		try {
		final HibernateTestDAO hibernateTestDAO = (HibernateTestDAO) context.getBean("hibernateTestDAO");
		HibernateTestVO hibernateTestVO = new HibernateTestVO();
		hibernateTestVO.setId(6);
		hibernateTestVO.setName("Kirk Nelson");
		hibernateTestDAO.insertRow(hibernateTestVO);
//		System.out.println(hibernateTestDAO.readRowById(6));
		} finally {
			context.close();
		}
	}
}
