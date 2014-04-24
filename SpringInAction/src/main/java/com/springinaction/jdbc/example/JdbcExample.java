package com.springinaction.jdbc.example;

// TODO: Auto-generated Javadoc
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
	 * Method Read row by id.
	 * @param id the id
	 * @return Test
	 */
	public Test readRowByIdWithRowMapper(int id);
	
}
