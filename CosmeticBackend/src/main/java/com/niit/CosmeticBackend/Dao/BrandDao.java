package com.niit.CosmeticBackend.Dao;

import java.util.List;

import com.niit.CosmeticBackend.Model.Brand;

public interface BrandDao {

	
	public boolean saveorupdate(Brand  brand);
	public boolean delete(Brand brand);
	public Brand getBrand(String brandId);
	public List<Brand> getBrandList();
	
	
}
