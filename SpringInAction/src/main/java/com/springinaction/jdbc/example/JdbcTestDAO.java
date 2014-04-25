package com.springinaction.jdbc.example;

// TODO: Auto-generated Javadoc
/**
 * The Interface JdbcExample.
 */
public interface JdbcTestDAO {

	/**
	 * Insert row.
	 *
	 * @param test the test
	 */
	public void insertRow(JdbcTestVO test);
	

	/**
	 * Read row by id.
	 *
	 * @param id the id
	 * @return the test
	 */
	public JdbcTestVO readRowById(int id);
	
}
