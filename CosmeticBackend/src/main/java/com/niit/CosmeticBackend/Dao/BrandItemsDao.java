package com.niit.CosmeticBackend.Dao;

import java.util.List;

import com.niit.CosmeticBackend.Model.BrandItems;


public interface BrandItemsDao {


	public boolean saveorupdate(BrandItems brandItems);
	public boolean delete(BrandItems brandItems);
	public BrandItems getBrandItems(String brandItemsId);
	public List<BrandItems> getBrandItemsList();
	public List<BrandItems> getCatBrandList(String brandId);
	
	
}
