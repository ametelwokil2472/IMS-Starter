package com.qa.ims.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders>  {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private OrderDAO OrderDAO;
	private Utils utils;
	
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.OrderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Orders> readAll() {
		List<Orders> orders = OrderDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Orders create() {
		LOGGER.info("Please enter Customer Id");
		Long customer_id = utils.getLong();
		LOGGER.info("Please enter Item Id");
		Long Item_id = utils.getLong();
		LOGGER.info("Please enter quantity");
		Long quantity = utils.getLong();
		Double total_cost = getTotalCost(Item_id) * quantity;
		Orders order = OrderDAO.create(new Orders(customer_id, Item_id, quantity,total_cost));
		LOGGER.info("Order created");
		return order;
	}
	
	public Double getTotalCost(Long item_id) {

		Double getValue = 0.0;
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * from item");) {
			while (resultSet.next()) {

				if (item_id == resultSet.getInt("item_id")) {
					getValue = resultSet.getDouble("value");
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
	public Orders update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please customer  id");
		Long cusId = utils.getLong();
		LOGGER.info("Please enter item id");
		Long ItemId = utils.getLong();
		LOGGER.info("Please enter quantity");
		Long quantity = utils.getLong();
		double total_cost = utils.getDouble();
		Orders order = OrderDAO.update(new Orders(id, cusId, ItemId,quantity, total_cost));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long Order_id = utils.getLong();
		int order = OrderDAO.delete(Order_id);
		LOGGER.info("Order Deleted");
		return order;
	}
	}


