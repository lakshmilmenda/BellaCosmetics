package com.niit.CosmeticBackend.Dao;

import java.util.List;

import com.niit.CosmeticBackend.Model.Product;

public interface ProductDao {

	public boolean saveorupdate(Product product);
	public boolean delete(Product product);
	public Product getProduct(String proId);
	public List<Product> getProList();
	public List<Product> getCatProList(String catId);
	public List<Product> getBrandProList(String brandId);

}
