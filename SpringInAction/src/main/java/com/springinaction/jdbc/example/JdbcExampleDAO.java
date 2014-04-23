package com.springinaction.jdbc.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 * The Class JdbcExampleDAO.
 */
public class JdbcExampleDAO implements JdbcExample {

	/** The Constant SQL_INSERT. */
	private static final String SQL_INSERT = "INSERT INTO TEST VALUES(?, ?)";
	
	private static final String SQL_QUERY_BY_ID = "SELECT * FROM TEST WHERE ID = ?";
	
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
	public Test readRow(int id) {
		return jdbcTemplate.queryForObject(SQL_QUERY_BY_ID, 
				new ParameterizedRowMapper<Test>() {
				public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
					Test test = new Test();
					test.setId(rs.getInt(1));
					test.setName(rs.getString(2));
					return test;
				}
		},		
		id
		);
	}

}
