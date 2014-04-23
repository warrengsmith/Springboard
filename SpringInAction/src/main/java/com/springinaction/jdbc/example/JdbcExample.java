package com.springinaction.jdbc.example;

/**
 * The Interface JdbcExample.
 */
public interface JdbcExample {

	/**
	 * Method Insert a row.
	 *
	 * @param test the test
	 */
	public void insertARow(Test test);
	
	/**
	 * Method Read row.
	 *
	 * @param id the id
	 * @return the string
	 */
	public String readRow(int id);
	
}
