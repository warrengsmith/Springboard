package com.wgs.virago.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.usg.ssg1.common.dao.BookDAO;
import com.usg.ssg1.common.dto.Book;

/**
 * The Class JdbcTemplateBookDAOImpl.
 * @author Warren Smith
 * @version 1.0
 */
@Repository
public class JdbcTemplateBookDAOImpl extends NamedParameterJdbcDaoSupport implements BookDAO {

	@Autowired
	public JdbcTemplateBookDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	/**
	 * The Class BookMapper. Demonstrate row mapping using column names.
	 */
	private static final class BookMapper implements RowMapper<Book> {
	    
    	/* (non-Javadoc)
    	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
    	 */
		@Override
    	public Book mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
	        final Book book = new Book();
	        book.setId(resultSet.getInt("BOOK_ID"));
	        book.setTitle(resultSet.getString("TITLE"));
	        book.setPrice(resultSet.getBigDecimal("PRICE"));
	        book.setDescription(resultSet.getString("DESCRIPTION"));
	        book.setAuthor(resultSet.getString("AUTHOR"));
	        return book;
	    }
	}
	
	/**
	 * The Class BookListExtractor. Demonstrate ResultSetExtractor using column numbers.
	 */
	private static final class BookListExtractor implements ResultSetExtractor<List<Book>> {

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.ResultSet)
		 */
		@Override
		public List<Book> extractData(final ResultSet resultSet) throws SQLException,
				DataAccessException {
			final List<Book> results = new ArrayList<Book>();
			while (resultSet.next()) {
				final Book book = new Book(); // NOPMD by kahwgs on 5/14/14 10:08 AM
				book.setId(resultSet.getInt(1));
				book.setTitle(resultSet.getString(2));
				book.setPrice(resultSet.getBigDecimal(3));
				book.setDescription(resultSet.getString(4));
				book.setAuthor(resultSet.getString(5));
				results.add(book);
			}
			return results;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.BookDAO#findAllBooks()
	 */
	@Override
	public List<Book> findAllBooks() {
		return getJdbcTemplate().query("select BOOK_ID, TITLE, PRICE, DESCRIPTION, AUTHOR from BOOK", new BookMapper());
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.BookDAO#findBookById(int)
	 */
	@Override
	public Book findBookById(final int bookId) {
		return getNamedParameterJdbcTemplate().queryForObject("select BOOK_ID, TITLE, PRICE, DESCRIPTION, AUTHOR from BOOK where BOOK_ID = :BOOK_ID", new MapSqlParameterSource("BOOK_ID", bookId), new BookMapper());
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.BookDAO#findBookByTitle(java.lang.String)
	 */
	@Override
	public Book findBookByTitle(final String title) {
		return getNamedParameterJdbcTemplate().queryForObject("select BOOK_ID, TITLE, PRICE, DESCRIPTION, AUTHOR from BOOK where TITLE = :TITLE", new MapSqlParameterSource("TITLE", title), new BookMapper());
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.BookDAO#searchByTitle(java.lang.String)
	 */
	@Override
	public List<Book> searchByTitle(final String titleSubString) {
		final String searchArg = new StringBuilder().append('%')
				.append(titleSubString.trim()).append('%').toString();
		return getNamedParameterJdbcTemplate()
				.query("select BOOK_ID, TITLE, PRICE, DESCRIPTION, AUTHOR from BOOK where TITLE like :SEARCH_ARG", new MapSqlParameterSource("SEARCH_ARG", searchArg), 
						new BookListExtractor());
	}
}
