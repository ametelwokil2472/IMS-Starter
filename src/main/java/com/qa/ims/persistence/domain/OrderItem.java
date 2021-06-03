package com.qa.ims.persistence.domain;

public class OrderItem {
private long orderItems_id;
private long order_id;
private long Items_id;
private long quantity;
private double total_cost;

public OrderItem(long orderItems_id, long order_id, long items_id, long quantity, double total_cost) {
	
	this.orderItems_id = orderItems_id;
	this.order_id = order_id;
	this.Items_id = items_id;
	this.quantity = quantity;
	this.total_cost = total_cost;
}
public OrderItem(long order_id, long items_id, long quantity, double total_cost) {
	this.order_id = order_id;
	this.Items_id = items_id;
	this.quantity = quantity;
	this.total_cost = total_cost;
}
public OrderItem(long order_id, long items_id, long quantity) {
	this.order_id = order_id;
	this.Items_id = items_id;
	this.quantity = quantity;

}

public long getOrderItems_id() {
	return orderItems_id;
}

public void setOrderItems_id(long orderItems_id) {
	this.orderItems_id = orderItems_id;
}

public long getOrder_id() {
	return order_id;
}

public void setOrder_id(long order_id) {
	this.order_id = order_id;
}

public long getItems_id() {
	return Items_id;
}

public void setItems_id(long items_id) {
	Items_id = items_id;
}

public long getQuantity() {
	return quantity;
}

public void setQuantity(long quantity) {
	this.quantity = quantity;
}

public double getTotal_cost() {
	return total_cost;
}

public void setTotal_cost(double total_cost) {
	this.total_cost = total_cost;
}

@Override
public String toString() {
	return "OrderItem [orderItems_id=" + orderItems_id + ", order_id=" + order_id + ", Items_id=" + Items_id
			+ ", quantity=" + quantity + ", total_cost=" + total_cost + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (Items_id ^ (Items_id >>> 32));
	result = prime * result + (int) (orderItems_id ^ (orderItems_id >>> 32));
	result = prime * result + (int) (order_id ^ (order_id >>> 32));
	result = prime * result + (int) (quantity ^ (quantity >>> 32));
	long temp;
	temp = Double.doubleToLongBits(total_cost);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	OrderItem other = (OrderItem) obj;
	if (Items_id != other.Items_id)
		return false;
	if (orderItems_id != other.orderItems_id)
		return false;
	if (order_id != other.order_id)
		return false;
	if (quantity != other.quantity)
		return false;
	if (Double.doubleToLongBits(total_cost) != Double.doubleToLongBits(other.total_cost))
		return false;
	return true;
}

}
