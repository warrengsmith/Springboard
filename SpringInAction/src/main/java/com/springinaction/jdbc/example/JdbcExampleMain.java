package com.springinaction.jdbc.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class JdbcExampleMain.
 */
public class JdbcExampleMain {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("jdbc-example.xml");
		try {
		final JdbcExampleDAO jdbcExampleDAO = (JdbcExampleDAO) context.getBean("jdbcExampleDAO");
		JdbcTestVO test = new JdbcTestVO();
		test.setId(72);
		test.setName("Markey Mark");
		jdbcExampleDAO.insertRow(test);
		System.out.println(jdbcExampleDAO.readRowById(72));
		} finally {
			context.close();
		}
	}
	
}
