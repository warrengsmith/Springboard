package com.wgs.virago.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.usg.ssg1.common.dao.BookDAO;
import com.usg.ssg1.common.dto.Book;

/**
 * The Class JdbcTemplateBookDAOImpl.
 * @author Warren Smith
 * @version 1.0
 */
public class JdbcTemplateBookDAOImpl implements BookDAO {

	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;
	
    /**
     * Sets the data source.
     *
     * @param dataSource the new data source
     */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.BookDAO#findAllBooks()
	 */
	@Override
	public List<Book> findAllBooks() {
		return jdbcTemplate.query("select BOOK_ID, TITLE, PRICE, DESCRIPTION, AUTHOR from BOOK", new BookMapper());
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.BookDAO#findBookByTitle(java.lang.String)
	 */
	@Override
	public Book findBookByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.BookDAO#findBookById(int)
	 */
	@Override
	public Book findBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.BookDAO#searchByTitle(java.lang.String)
	 */
	@Override
	public List<Book> searchByTitle(String titleSubString) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * The Class BookMapper.
	 */
	private static final class BookMapper implements RowMapper<Book> {
	    
    	/* (non-Javadoc)
    	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
    	 */
		@Override
    	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Book book = new Book();
	        book.setId(rs.getInt(1));
	        book.setTitle(rs.getString(2));
	        book.setPrice(rs.getBigDecimal(3));
	        book.setDescription(rs.getString(4));
	        book.setAuthor(rs.getString(5));
	        return book;
	    }
	}
}
