package com.springinaction.knights;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class KnightMain.
 */
public class KnightMain {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
		final Knight knight = (Knight) context.getBean("knight");
		knight.embarkOnQuest();
		context.close();
	}
}
