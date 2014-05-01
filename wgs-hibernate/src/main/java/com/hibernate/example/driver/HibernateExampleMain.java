package com.hibernate.example.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateExampleMain {

	public static void main (String[] args) {
		final ApplicationContext context = new ClassPathXmlApplicationContext("hibernate-example.xml");
		final HibernateExample hibernateExample = (HibernateExample) context.getBean("hibernateExample");
		hibernateExample.process(context);
	}
}
