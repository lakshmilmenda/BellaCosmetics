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


public class Cart {

	@Id
	
	private String cartId;
	private double grandTotal;
	private int totalItems;
	
	@OneToMany(mappedBy="cart",cascade=CascadeType.ALL)
	private List<CartItem>cartItem;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="payId")
	private Pay pay;
	
	/**
	 * @return the cartItem
	 */
	public List<CartItem> getCartItem() {
		return cartItem;
	}

	/**
	 * @param cartItem the cartItem to set
	 */
	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
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

	//constructor
	public Cart()
	{
		this.cartId="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	/**
	 * @return the cartId
	 */
	public String getCartId() {
		return cartId;
	}
	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	/**
	 * @return the grandTotal
	 */
	public double getGrandTotal() {
		return grandTotal;
	}
	/**
	 * @param grandTotal the grandTotal to set
	 */
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	/**
	 * @return the totalItems
	 */
	public int getTotalItems() {
		return totalItems;
	}
	/**
	 * @param totalItems the totalItems to set
	 */
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	
	
}
