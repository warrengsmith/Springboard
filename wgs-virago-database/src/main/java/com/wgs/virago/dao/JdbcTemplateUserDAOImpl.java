package com.wgs.virago.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.usg.ssg1.common.dao.UserDAO;
import com.usg.ssg1.common.dto.User;

/**
 * The Class JdbcTemplateUserDAOImpl.
 * @author Warren Smith
 * @version 1.0
 */
public class JdbcTemplateUserDAOImpl  extends NamedParameterJdbcDaoSupport implements UserDAO {

    /**
     * The Class UserMapper.
     */
    private static final class UserMapper implements RowMapper<User> {

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		@Override
    	public User mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
	        final User user = new User();
	        user.setId(resultSet.getInt(1));
	        user.setName(resultSet.getString(2));
	        return user;
	    }
	}
	
	/**
	 * Instantiates a new jdbc template user dao impl.
	 *
	 * @param dataSource the data source
	 */
	@Autowired
    public JdbcTemplateUserDAOImpl(final DataSource dataSource) {
    	super();
		this.setDataSource(dataSource);
    }

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.UserDAO#addUser(java.lang.String)
	 */
	@Override
	public User addUser(final String name) {
		final User returnUser = new User();
		returnUser.setName(name);
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update("insert into USER(USER_NM) values(:name)", new MapSqlParameterSource("name", name), keyHolder);
		returnUser.setId((Integer) keyHolder.getKey());
		return returnUser;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.UserDAO#deleteUser(int)
	 */
	@Override
	public boolean deleteUser(final int userId) {
		getNamedParameterJdbcTemplate().update("delete from USER where USER_ID = :userId", new MapSqlParameterSource("userId", userId));
		return true;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.UserDAO#findAllUsers()
	 */
	@Override
	public List<User> findAllUsers() {
		return getNamedParameterJdbcTemplate().query("select USER_ID, USER_NM from USER", new UserMapper());
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.UserDAO#findUserById(int)
	 */
	@Override
	public User findUserById(final int userId) {
		User result = null;
		try {
			result = getNamedParameterJdbcTemplate().queryForObject("select USER_ID, USER_NM from USER where USER_ID = :userId",  new MapSqlParameterSource("userId", userId),  new UserMapper());
		} 
		catch (DataAccessException e) { // NOPMD by kahwgs on 5/22/14 12:34 PM
			// do nothing
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.UserDAO#findUserByName(java.lang.String)
	 */
	@Override
	public User findUserByName(final String name) {
		User result = null;
		try {
			result = getNamedParameterJdbcTemplate().queryForObject("select USER_ID, USER_NM from USER where USER_NM = :name", new MapSqlParameterSource("name", name),  new UserMapper());
		} 
		catch (DataAccessException e) { // NOPMD by kahwgs on 5/22/14 12:34 PM
			// do nothing
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.UserDAO#updateUser(com.usg.ssg1.common.dto.User)
	 */
	@Override
	public User updateUser(final User user) {
		final SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
		getNamedParameterJdbcTemplate().update("update USER set USER_NM = :name where USER_ID = :id", parameters); // NOPMD by kahwgs on 5/22/14 12:34 PM
		return user;
	}
}
