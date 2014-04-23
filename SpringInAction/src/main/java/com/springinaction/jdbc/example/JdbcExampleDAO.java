package com.springinaction.jdbc.example;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * The Class JdbcExampleDAO.
 */
public class JdbcExampleDAO implements JdbcExample {

	/** The Constant SQL_INSERT. */
	private static final String SQL_INSERT = "INSERT INTO TEST VALUES(?, ?)";
	
	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Method sets the jdbc template.
	 *
	 * @param jdbcTemplate the new jdbc template
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/* (non-Javadoc)
	 * @see com.springinaction.jdbc.example.JdbcExample#insertARow(com.springinaction.jdbc.example.Test)
	 */
	public void insertARow(Test test) {
		jdbcTemplate.update(SQL_INSERT,
				test.getId(),
				test.getName());
	}

	/* (non-Javadoc)
	 * @see com.springinaction.jdbc.example.JdbcExample#readRow(int)
	 */
	public String readRow(int id) {
//		return jdbcTemplate.query
		return "";
	}

}
