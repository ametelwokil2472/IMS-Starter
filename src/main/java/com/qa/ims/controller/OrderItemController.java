package com.qa.ims.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class OrderItemController implements CrudController<OrderItem> {
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderItemDAO orderItemDAO;
	private Utils utils;
	
	public OrderItemController(OrderItemDAO orderItemDAO, Utils utils) {
		super();
		this.orderItemDAO = orderItemDAO;
		this.utils = utils;
	}

	@Override
	public List<OrderItem> readAll() {
		List<OrderItem> orderItems = orderItemDAO.readAll();
		for (OrderItem orderItem : orderItems) {
			LOGGER.info(orderItem);
		}
		return orderItems;
	}

	public Double calculateTotalCost(Long item_id) {

		Double getValue = 0.0;
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * from item");) {
		while (resultSet.next()) {

			if (item_id == resultSet.getLong("Item_id")) {
					getValue = resultSet.getDouble("Value");
				}
			}
			return getValue;
	} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
 	return getValue;

	}
	
	@Override
	public OrderItem create() {
		LOGGER.info("Please enter a order id");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter a item id");
		Long item_id = utils.getLong();
		LOGGER.info("Please enter a quantity");
		Long quantity = utils.getLong();
		double total_cost = calculateTotalCost(item_id) * quantity;
		OrderItem orderItem = orderItemDAO.create(new OrderItem(order_id, item_id,quantity,total_cost));
		LOGGER.info("Order Item created");
		return orderItem;
	}

	@Override
	public OrderItem update() {
		LOGGER.info("Please enter the id of the order Item you would like to update");
		Long orderItem_id = utils.getLong();
		LOGGER.info("Please enter Order   id");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter Order Item  id");
		Long itm_Id = utils.getLong();
		LOGGER.info("Please enter quantity");
		Long quantity = utils.getLong();
		double total_cost = calculateTotalCost(itm_Id) * quantity;
		OrderItem orderItem = orderItemDAO.update(new OrderItem(orderItem_id, order_id, itm_Id,quantity,total_cost));
		LOGGER.info("Order Updated");
		return orderItem;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order item you would like to delete");
		Long orderItem_id = utils.getLong();
		int order = orderItemDAO.delete(orderItem_id);
		LOGGER.info("Order Item Deleted");
		return order;
	}
}
