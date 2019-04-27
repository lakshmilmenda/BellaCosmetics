package com.niit.CosmeticBackend.Dao;

import java.util.List;

import com.niit.CosmeticBackend.Model.Billing;


public interface BillingDao {

	public boolean saveorupdate(Billing billing);
	public boolean delete(Billing billing);
	public Billing getBill(String billId);
	public List<Billing>getBillList();
	public Billing getUserId(String uId);

}
