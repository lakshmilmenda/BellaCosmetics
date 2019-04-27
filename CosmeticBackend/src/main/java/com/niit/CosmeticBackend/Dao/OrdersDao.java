package com.niit.CosmeticBackend.Dao;

import java.util.List;

import com.niit.CosmeticBackend.Model.Orders;

public interface OrdersDao {

	public boolean saveorupdate(Orders orders);
	public boolean delete(Orders orders);
	public Orders getOrders(String ordersId);
	public List<Orders>getOrdersList();
}
