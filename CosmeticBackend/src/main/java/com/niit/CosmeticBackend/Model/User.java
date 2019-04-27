package com.niit.CosmeticBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component


public class User {

@Id
	
	private String uId;
	private String uName;
	private String uAdd;
	private String uPhoneNo;
	private String uEmail;
	private String uPassword;

	
	
	@OneToOne
	@JoinColumn(name="billId")
	private Billing billing;
	
	@OneToOne
	@JoinColumn(name="cartId")
	private Cart cart;

	public User() {
		this.uId="USER"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	/**
	 * @return the billing
	 */
	public Billing getBilling() {
		return billing;
	}
	/**
	 * @param billing the billing to set
	 */
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}
	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	/**
	 * @return the uId
	 */
	public String getuId() {
		return uId;
	}
	/**
	 * @param uId the uId to set
	 */
	public void setuId(String uId) {
		this.uId = uId;
	}
	/**
	 * @return the uName
	 */
	public String getuName() {
		return uName;
	}
	/**
	 * @param uName the uName to set
	 */
	public void setuName(String uName) {
		this.uName = uName;
	}
	/**
	 * @return the uAdd
	 */
	public String getuAdd() {
		return uAdd;
	}
	/**
	 * @param uAdd the uAdd to set
	 */
	public void setuAdd(String uAdd) {
		this.uAdd = uAdd;
	}
	/**
	 * @return the uPhoneNo
	 */
	public String getuPhoneNo() {
		return uPhoneNo;
	}
	/**
	 * @param uPhoneNo the uPhoneNo to set
	 */
	public void setuPhoneNo(String uPhoneNo) {
		this.uPhoneNo = uPhoneNo;
	}
	/**
	 * @return the uEmail
	 */
	public String getuEmail() {
		return uEmail;
	}
	/**
	 * @param uEmail the uEmail to set
	 */
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	/**
	 * @return the uPassword
	 */
	public String getuPassword() {
		return uPassword;
	}
	/**
	 * @param uPassword the uPassword to set
	 */
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	
	

}
