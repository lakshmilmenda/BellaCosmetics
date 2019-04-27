package com.niit.CosmeticBackend.Dao;

import java.util.List;

import com.niit.CosmeticBackend.Model.OrderItem;

public interface OrderItemDao {

	public boolean saveorupdate(OrderItem orderItem);
	public boolean delete(OrderItem orderItem);
	public OrderItem getOrderItem(String orderItemId);
	public List<OrderItem>orderList();
	
}
