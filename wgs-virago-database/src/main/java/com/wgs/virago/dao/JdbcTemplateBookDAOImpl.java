package com.wgs.virago.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
	
	/**
	 * The Class BookMapper.
	 */
	private static final class BookMapper implements RowMapper<Book> {
	    
    	/* (non-Javadoc)
    	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
    	 */
		@Override
    	public Book mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
	        final Book book = new Book();
	        book.setId(resultSet.getInt(1));
	        book.setTitle(resultSet.getString(2));
	        book.setPrice(resultSet.getBigDecimal(3));
	        book.setDescription(resultSet.getString(4));
	        book.setAuthor(resultSet.getString(5));
	        return book;
	    }
	}
	
	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.BookDAO#findAllBooks()
	 */
	@Override
	public List<Book> findAllBooks() {
		return jdbcTemplate.query("select BOOK_ID, TITLE, PRICE, DESCRIPTION, AUTHOR from BOOK", new BookMapper());
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.BookDAO#findBookById(int)
	 */
	@Override
	public Book findBookById(final int bookId) {
		return jdbcTemplate.queryForObject("select BOOK_ID, TITLE, PRICE, DESCRIPTION, AUTHOR from BOOK where BOOK_ID = ?", new Object[] {bookId}, new BookMapper());
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.BookDAO#findBookByTitle(java.lang.String)
	 */
	@Override
	public Book findBookByTitle(final String title) {
		return jdbcTemplate.queryForObject("select BOOK_ID, TITLE, PRICE, DESCRIPTION, AUTHOR from BOOK where TITLE = ?", new Object[] {title}, new BookMapper());
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.BookDAO#searchByTitle(java.lang.String)
	 */
	@Override
	public List<Book> searchByTitle(final String titleSubString) {
		final String searchArg = new StringBuilder().append('%')
				.append(titleSubString.trim()).append('%').toString();
		return jdbcTemplate
				.query("select BOOK_ID, TITLE, PRICE, DESCRIPTION, AUTHOR from BOOK where TITLE like ?", new Object[] {searchArg}, 
						new ResultSetExtractor<List<Book>>() {
							@Override
							public List<Book> extractData(final ResultSet resultSet)
									throws SQLException, DataAccessException {
								final List<Book> results = new ArrayList<Book>();
								while (resultSet.next()) {
									final Book book = new Book();
									book.setId(resultSet.getInt(1));
									book.setTitle(resultSet.getString(2));
									book.setPrice(resultSet.getBigDecimal(3));
									book.setDescription(resultSet.getString(4));
									book.setAuthor(resultSet.getString(5));
									results.add(book);
								}
								return results;
							}
						});
	}
}
