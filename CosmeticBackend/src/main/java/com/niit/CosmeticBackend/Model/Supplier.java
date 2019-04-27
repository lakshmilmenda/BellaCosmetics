package com.niit.CosmeticBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component


public class Supplier {

	@Id
	
	private String supId;
	private String supName;
	private String supAdd;
	private String supPhoneNo;
	
	
	@OneToMany(mappedBy="supplier")
	private List<Product>product;
	
	public Supplier()
	{
		this.supId="SUP"+UUID.randomUUID().toString().substring(30).toUpperCase();
		}
	
	
	/**
	 * @return the supId
	 */
	public String getSupId() {
		return supId;
	}
	/**
	 * @param supId the supId to set
	 */
	public void setSupId(String supId) {
		this.supId = supId;
	}
	/**
	 * @return the supName
	 */
	public String getSupName() {
		return supName;
	}
	/**
	 * @param supName the supName to set
	 */
	public void setSupName(String supName) {
		this.supName = supName;
	}
	/**
	 * @return the supAdd
	 */
	public String getSupAdd() {
		return supAdd;
	}
	/**
	 * @param supAdd the supAdd to set
	 */
	public void setSupAdd(String supAdd) {
		this.supAdd = supAdd;
	}
	/**
	 * @return the supPhoneNo
	 */
	public String getSupPhoneNo() {
		return supPhoneNo;
	}
	/**
	 * @param supPhoneNo the supPhoneNo to set
	 */
	public void setSupPhoneNo(String supPhoneNo) {
		this.supPhoneNo = supPhoneNo;
	}
	
	
}
