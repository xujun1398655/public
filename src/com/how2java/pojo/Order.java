package com.how2java.pojo;

import java.util.List;

public class Order {
	private int id;
	private String code;
	List<OrderItem> orderItems;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<OrderItem> getOrderItem() {
		return orderItems;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItems = orderItem;
	}
	
	
}
