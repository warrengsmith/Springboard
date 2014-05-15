package com.wgs.virago.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.usg.ssg1.common.dao.UserDAO;
import com.usg.ssg1.common.dto.User;

/**
 * The Class JdbcTemplateUserDAOImpl.
 * @author Warren Smith
 * @version 1.0
 */
public class JdbcTemplateUserDAOImpl implements UserDAO {

    /** The jdbc template. */
	private transient JdbcTemplate jdbcTemplate;
	
	/**
     * Sets the data source.
     *
     * @param dataSource the new data source
     */
    @Autowired
    public void setDataSource(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.UserDAO#addUser(java.lang.String)
	 */
	@Override
	public User addUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.UserDAO#updateUser(com.usg.ssg1.common.dto.User)
	 */
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.UserDAO#deleteUser(int)
	 */
	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.UserDAO#findAllUsers()
	 */
	@Override
	public List<User> findAllUsers() {
		return jdbcTemplate.query("select BOOK_ID, TITLE, PRICE, DESCRIPTION, AUTHOR from BOOK", new UserMapper());
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.UserDAO#findUserById(int)
	 */
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.UserDAO#findUserByName(java.lang.String)
	 */
	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

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
}
