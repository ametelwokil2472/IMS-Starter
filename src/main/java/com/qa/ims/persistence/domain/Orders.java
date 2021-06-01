package com.qa.ims.persistence.domain;

public class Orders {
	private Long order_id;
	private Long customer_id;
	private Long Item_id;
	private Long quantity;
	private double total_cost;
	


	public Orders() {
		super();
	}

	public Orders( Long customer_id, Long item_id, Long quantity, double total_cost) {
		super();
		
		this.customer_id = customer_id;
		Item_id = item_id;
		this.quantity = quantity;
		this.total_cost = total_cost;
	}

	public Orders(Long order_id, Long customer_id, Long item_id, Long quantity, double total_cost) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		Item_id = item_id;
		this.quantity = quantity;
		this.total_cost = total_cost;
	}

	
	public Long getOrder_id() {
		return order_id;
	}



	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}



	public Long getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}



	public Long getItem_id() {
		return Item_id;
	}



	public void setItem_id(Long item_id) {
		Item_id = item_id;
	}



	public Long getQuantity() {
		return quantity;
	}



	public void setQuantity(Long quantity) {
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
		return "Orders [order_id=" + order_id + ", customer_id=" + customer_id + ", Item_id=" + Item_id + ", quantity="
				+ quantity + ", total_cost=" + total_cost + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Item_id == null) ? 0 : Item_id.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		Orders other = (Orders) obj;
		if (Item_id == null) {
			if (other.Item_id != null)
				return false;
		} else if (!Item_id.equals(other.Item_id))
			return false;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (Double.doubleToLongBits(total_cost) != Double.doubleToLongBits(other.total_cost))
			return false;
		return true;
	}
	
	
	}