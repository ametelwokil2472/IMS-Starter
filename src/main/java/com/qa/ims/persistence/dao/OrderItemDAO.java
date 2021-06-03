package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAO implements Dao<OrderItem>{

	public static final Logger LOGGER = LogManager.getLogger();
	@Override
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderItem_id = resultSet.getLong("orderItems_id");
		Long order_id = resultSet.getLong("order_id");
		Long Items_id = resultSet.getLong("Item_id");
		Long quantity = resultSet.getLong("quantity");
		Long total_cost = resultSet.getLong("total_cost");
		return new OrderItem(orderItem_id, order_id, Items_id,quantity,total_cost);
	}

	
	@Override
	public List<OrderItem> readAll() {
			try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items");) {
			List<OrderItem> orderItems = new ArrayList<>();
			while (resultSet.next()) {
				orderItems.add(modelFromResultSet(resultSet));
			}
			return orderItems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public OrderItem read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_items WHERE order_id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	public OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY orderItems_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItem create(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items(order_id, Item_id, quantity, total_cost) VALUES (?, ?, ?, ?)");) {
			statement.setLong(1, orderItem.getOrder_id());
			statement.setLong(2, orderItem.getItems_id());
			statement.setLong(3, orderItem.getQuantity());
			statement.setDouble(4,orderItem.getTotal_cost());
			
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItem update(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE order_items SET order_id = ?, Item_id = ?, quantity = ?, total_cost = ? WHERE orderItems_id = ?");) {
			statement.setLong(1, orderItem.getOrderItems_id());
			statement.setLong(2, orderItem.getOrder_id());
			statement.setLong(3, orderItem.getItems_id());
			statement.setLong(4, orderItem.getQuantity());
			statement.setDouble(5, orderItem.getTotal_cost());
			statement.executeUpdate();
			return read(orderItem.getOrder_id());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE orderItems_id = ?");) {
			statement.setLong(1, order_id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	}

	

	
	
	

