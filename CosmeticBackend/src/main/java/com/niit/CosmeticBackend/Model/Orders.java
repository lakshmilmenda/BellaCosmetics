package com.niit.CosmeticBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Orders {
	@Id
	
	private String orderId;
	private double grandTotal;
	
	@OneToMany(mappedBy="orders",cascade=CascadeType.ALL)
	private List<OrderItem>orderItem;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="uId")
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="payId")
	private Pay pay;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shipId")
	private Shipping shipping;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billId")
	private Billing billing;
	
	public Orders()
	{
		this.orderId="ORDERS"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	/**
	 * @return the orderItem
	 */
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	/**
	 * @param orderItem the orderItem to set
	 */
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the pay
	 */
	public Pay getPay() {
		return pay;
	}
	/**
	 * @param pay the pay to set
	 */
	public void setPay(Pay pay) {
		this.pay = pay;
	}
	/**
	 * @return the shipping
	 */
	public Shipping getShipping() {
		return shipping;
	}
	/**
	 * @param shipping the shipping to set
	 */
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
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
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the grandTotal
	 */
	public double getGrandTotal() {
		return grandTotal;
	}
	/**
	 * @param d the grandTotal to set
	 */
	public void setGrandTotal(double grandtTotal) {
		this.grandTotal = grandTotal;
	}
	
	

}
