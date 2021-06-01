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
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Orders> {
	public static final Logger LOGGER = LogManager.getLogger();

	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("Order_id");
		Long customer_id = resultSet.getLong("customer_id");
		Long Item_id = resultSet.getLong("Item_id");
		Long quantity = resultSet.getLong("quantity");
		Long total_cost = resultSet.getLong("total_cost");
		
		return new Orders(order_id, customer_id, Item_id, quantity, total_cost);
	}
	@Override
	public List<Orders> readAll() {

		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY Order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders create(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(customer_id, item_id, quantity, total_cost) VALUES (?, ?, ?, ?)");) {
			statement.setLong(1, order.getCustomer_id());
			statement.setLong(2, order.getItem_id());
			statement.setLong(3, order.getQuantity());
			statement.setDouble
			(4, order.getTotal_cost());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public Orders read(Long Order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE Order_id = ?");) {
			statement.setLong(1, Order_id);
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


	@Override
	public Orders update(Orders Order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE Orders SET customer_id = ?, item_id = ?, quantity = ? total_cost = ? WHERE order_id = ?");) {
			statement.setLong(1, Order.getOrder_id());
			statement.setLong(2, Order.getCustomer_id());
			statement.setLong(3, Order.getItem_id());
			statement.setLong(4, Order.getQuantity());
			statement.executeUpdate();
			return read(Order.getOrder_id());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders WHERE Order_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
