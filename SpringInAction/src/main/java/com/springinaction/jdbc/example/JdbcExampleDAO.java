package com.springinaction.jdbc.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * The Class JdbcExampleDAO.
 * 
 * @author Warren Smith
 */
public class JdbcExampleDAO extends JdbcDaoSupport implements JdbcTestDAO {

	/** The Constant SQL_INSERT. */
	private static final String SQL_INSERT = "INSERT INTO TEST VALUES(?, ?)";

	/** The Constant SQL_QUERY_BY_ID. */
	private static final String SQL_QUERY_BY_ID = "SELECT * FROM TEST WHERE ID = ?";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.springinaction.jdbc.example.JdbcExample#insertARow(com.springinaction
	 * .jdbc.example.Test)
	 */
	public void insertRow(JdbcTestVO test) {
		getJdbcTemplate().update(SQL_INSERT, test.getId(), test.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.springinaction.jdbc.example.JdbcExample#readRow(int)
	 */
	public JdbcTestVO readRowById(int id) {
		return getJdbcTemplate().queryForObject(SQL_QUERY_BY_ID,
				new ParameterizedRowMapper<JdbcTestVO>() {
					public JdbcTestVO mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						JdbcTestVO test = new JdbcTestVO();
						test.setId(rs.getInt(1));
						test.setName(rs.getString(2));
						return test;
					}
				}, id);
	}
}
