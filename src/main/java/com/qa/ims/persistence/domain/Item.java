package com.qa.ims.persistence.domain;

public class Item {
	private Long Item_id;
	private String Item_name;
	private double Value;
	
	public Item(String Item_name, double Value) {
	this.setItem_name(Item_name);
	this.setValue(Value);
}
	
	
	public Item(Long item_id, String Item_name, double value) {
		this.Item_id = item_id;
		this.Item_name = Item_name;
		this.Value = value;
	}

	public Long getItem_id() {
		return Item_id;
	}

	public void setItem_id(Long item_id) {
		Item_id = item_id;
	}

	public String getItem_name() {
		return Item_name;
	}

	public void setItem_name(String item_name) {
		Item_name = item_name;
	}

	public double getValue() {
		return Value;
	}

	
	public void setValue(double value) {
		Value = value;
	}

	@Override
	public String toString() {
		return "Item [Item_id=" + Item_id + ", Item_Name=" + Item_name + ", Value=" + Value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Item_name == null) ? 0 : Item_name.hashCode());
		result = prime * result + ((Item_id == null) ? 0 : Item_id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Value);
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
		Item other = (Item) obj;
		if (Item_name == null) {
			if (other.Item_name != null)
				return false;
		} else if (!Item_name.equals(other.Item_name))
			return false;
		if (Item_id == null) {
			if (other.Item_id != null)
				return false;
		} else if (!Item_id.equals(other.Item_id))
			return false;
		if (Double.doubleToLongBits(Value) != Double.doubleToLongBits(other.Value))
			return false;
		return true;
	}

}