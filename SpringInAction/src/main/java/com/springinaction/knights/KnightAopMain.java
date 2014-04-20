package com.springinaction.knights;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class KnightAopMain.
 */
public class KnightAopMain {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		final ConfigurableApplicationContext  context = new ClassPathXmlApplicationContext("knights-aop.xml");
		final Knight knight = (Knight) context.getBean("knight");
		knight.embarkOnQuest();
		context.close();
	}
}
