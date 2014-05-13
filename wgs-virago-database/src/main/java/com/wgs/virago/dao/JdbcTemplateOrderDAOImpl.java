package com.wgs.virago.dao;

import java.util.List;

import com.usg.ssg1.common.dao.OrderDAO;
import com.usg.ssg1.common.dto.Order;
import com.usg.ssg1.common.dto.OrderDetail;
import com.usg.ssg1.common.dto.PaymentType;

/**
 * The Class JdbcTemplateOrderDAOImpl.
 * @author Warren Smith
 * @version 1.0
 */
public class JdbcTemplateOrderDAOImpl implements OrderDAO {

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.OrderDAO#addOrder(int, int)
	 */
	@Override
	public Order addOrder(int userId, int paymentTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.OrderDAO#updateOrder(com.usg.ssg1.common.dto.Order)
	 */
	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.OrderDAO#deleteOrder(int)
	 */
	@Override
	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.OrderDAO#findAllOrders()
	 */
	@Override
	public List<Order> findAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.OrderDAO#findUserOrders(int)
	 */
	@Override
	public List<Order> findUserOrders(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.OrderDAO#addOrderDetail(int, int)
	 */
	@Override
	public OrderDetail addOrderDetail(int orderId, int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.OrderDAO#findOrderDetails(int)
	 */
	@Override
	public List<OrderDetail> findOrderDetails(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.OrderDAO#findAllPaymentTypes()
	 */
	@Override
	public List<PaymentType> findAllPaymentTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usg.ssg1.common.dao.OrderDAO#findPaymentTypeById(int)
	 */
	@Override
	public PaymentType findPaymentTypeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
