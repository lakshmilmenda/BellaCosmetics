package com.niit.CosmeticBackend.Dao;

import java.util.List;

import com.niit.CosmeticBackend.Model.Shipping;

public interface ShippingDao {

	public boolean saveorupdate(Shipping shipping);
	public boolean delete(Shipping shipping);
	public Shipping getShipping(String shipId);
	public List<Shipping>getshipList();
	public List<Shipping> getUserId(String uId);

}
