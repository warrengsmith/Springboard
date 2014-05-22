package com.wgs.virago.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.usg.ssg1.common.dao.OrderDAO;
import com.usg.ssg1.common.dto.Order;
import com.usg.ssg1.common.dto.OrderDetail;
import com.usg.ssg1.common.dto.PaymentType;

/**
 * The Class JdbcTemplateOrderDAOImpl.
 * 
 * @author Warren Smith
 * @version 1.0
 */
@Repository
public class JdbcTemplateOrderDAOImpl extends NamedParameterJdbcDaoSupport implements OrderDAO { // NOPMD by kahwgs on 5/22/14 9:26 AM

	/**
	 * The Class OrderDetailMapper.
	 */
	private static final class OrderDetailMapper implements RowMapper<OrderDetail> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
		 * int)
		 */
		public OrderDetail mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
			final OrderDetail orderDetail = new OrderDetail();
			orderDetail.setId(resultSet.getInt(1));
			orderDetail.setOrderId(resultSet.getInt(2));
			orderDetail.setBookId(resultSet.getInt(3));
			return orderDetail;
		}
	}

	/**
	 * The Class OrderMapper.
	 */
	private static final class OrderMapper implements RowMapper<Order> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
		 * int)
		 */
		public Order mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
			final Order order = new Order();
			order.setId(resultSet.getInt(1));
			order.setUserId(resultSet.getInt(2));
			order.setPaymentTypeId(resultSet.getInt(3));
			order.setTimestamp(resultSet.getTimestamp(4));
			return order;
		}
	}

	/**
	 * The Class PaymentTypeMapper.
	 */
	private static final class PaymentTypeMapper implements RowMapper<PaymentType> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
		 * int)
		 */
		public PaymentType mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
			final PaymentType paymentType = new PaymentType();
			paymentType.setId(resultSet.getInt(1));
			paymentType.setName(resultSet.getString(2));
			return paymentType;
		}
	}

	/**
	 * Instantiates a new jdbc template order dao impl.
	 *
	 * @param dataSource
	 *            the data source
	 */
	@Autowired
	public JdbcTemplateOrderDAOImpl(final DataSource dataSource) {
		super();
		this.setDataSource(dataSource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.usg.ssg1.common.dao.OrderDAO#addOrder(int, int)
	 */
	@Override
	public Order addOrder(final int userId, final int paymentTypeId) {
		final Order returnOrder = new Order();
		returnOrder.setUserId(userId);
		returnOrder.setPaymentTypeId(paymentTypeId);
		final Timestamp timestamp = new Timestamp(new Date().getTime());
		returnOrder.setTimestamp(timestamp);
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		final SqlParameterSource parameters = new BeanPropertySqlParameterSource(returnOrder);
		getNamedParameterJdbcTemplate().update("insert into SSG1_ORDER(USER_ID, PYMT_TYPE_ID, ORDER_TS) values(:userId, :paymentTypeId, :timestamp)", // NOPMD by kahwgs on 5/22/14 9:31 AM
				parameters, keyHolder);
		returnOrder.setId((Integer) keyHolder.getKey());
		return returnOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.usg.ssg1.common.dao.OrderDAO#addOrderDetail(int, int)
	 */
	@Override
	public OrderDetail addOrderDetail(final int orderId, final int bookId) {
		final OrderDetail returnOrderDetail = new OrderDetail();
		returnOrderDetail.setOrderId(orderId);
		returnOrderDetail.setBookId(bookId);
		final SqlParameterSource parameters = new BeanPropertySqlParameterSource(returnOrderDetail);
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update("insert into SSG1_ORDER_DTL(ORDER_ID, BOOK_ID) values(:orderId, :bookId)", parameters, keyHolder); // NOPMD by kahwgs on 5/22/14 9:31 AM
		returnOrderDetail.setId((Integer) keyHolder.getKey());
		return returnOrderDetail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.usg.ssg1.common.dao.OrderDAO#deleteOrder(int)
	 */
	@Override
	public void deleteOrder(final int orderId) {
		getNamedParameterJdbcTemplate().update("delete from SSG1_ORDER where ORDER_ID = :orderId", new MapSqlParameterSource("orderId", orderId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.usg.ssg1.common.dao.OrderDAO#findAllOrders()
	 */
	@Override
	public List<Order> findAllOrders() {
		return getNamedParameterJdbcTemplate().query("select ORDER_ID, USER_ID, PYMT_TYPE_ID, ORDER_TS from SSG1_ORDER", new OrderMapper());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.usg.ssg1.common.dao.OrderDAO#findAllPaymentTypes()
	 */
	@Override
	public List<PaymentType> findAllPaymentTypes() {
		return getNamedParameterJdbcTemplate().query("select PYMT_TYPE_ID, PYMT_TYPE_NM from PYMT_TYPE", new PaymentTypeMapper());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.usg.ssg1.common.dao.OrderDAO#findOrderDetails(int)
	 */
	@Override
	public List<OrderDetail> findOrderDetails(final int orderId) {
		return getNamedParameterJdbcTemplate().query("select ORDER_DTL_ID, ORDER_ID, BOOK_ID from SSG1_ORDER_DTL where ORDER_ID = :id",
				new MapSqlParameterSource("id", orderId), new OrderDetailMapper());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.usg.ssg1.common.dao.OrderDAO#findPaymentTypeById(int)
	 */
	@Override
	public PaymentType findPaymentTypeById(final int paymentTypeId) {
		PaymentType result = null;
		try {
			result = getNamedParameterJdbcTemplate().queryForObject("select PYMT_TYPE_ID, PYMT_TYPE_NM from PYMT_TYPE where PYMT_TYPE_ID = :paymentTypeId",
					new MapSqlParameterSource("paymentTypeId", paymentTypeId), new PaymentTypeMapper());
		} catch (DataAccessException e) { // NOPMD by kahwgs on 5/22/14 9:25 AM
			// do nothing
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.usg.ssg1.common.dao.OrderDAO#findUserOrders(int)
	 */
	@Override
	public List<Order> findUserOrders(final int userId) {
		return getNamedParameterJdbcTemplate().query("select ORDER_ID, USER_ID, PYMT_TYPE_ID, ORDER_TS from SSG1_ORDER where USER_ID = :userId",
				new MapSqlParameterSource("userId", userId), new OrderMapper());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.usg.ssg1.common.dao.OrderDAO#updateOrder(com.usg.ssg1.common.dto.Order)
	 */
	@Override
	public Order updateOrder(final Order order) {
		final Timestamp timestamp = new Timestamp(new Date().getTime());
		order.setTimestamp(timestamp);
		final SqlParameterSource parameters = new BeanPropertySqlParameterSource(order);
		getNamedParameterJdbcTemplate().update( // NOPMD by kahwgs on 5/22/14 9:31 AM
				"update SSG1_ORDER set USER_ID = :userId, PYMT_TYPE_ID = :paymentTypeId, ORDER_TS = :timestamp where ORDER_ID = :id", parameters);
		return order;
	}
}
