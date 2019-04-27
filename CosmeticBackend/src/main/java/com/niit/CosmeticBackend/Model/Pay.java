package com.niit.CosmeticBackend.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Pay {

@Id

private String payId;
private String payMethod;
private String payStatus;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="cartId")
private Cart cart;


@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="orderId")
private Orders orders;

public Pay()
{
	this.payId="PAY"+UUID.randomUUID().toString().substring(30).toUpperCase();
}


/**
 * @return the orders
 */
public Orders getOrders() {
	return orders;
}


/**
 * @param orders the orders to set
 */
public void setOrders(Orders orders) {
	this.orders = orders;
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
 * @return the payId
 */
public String getPayId() {
	return payId;
}
/**
 * @param payId the payId to set
 */
public void setPayId(String payId) {
	this.payId = payId;
}
/**
 * @return the payMethod
 */
public String getPayMethod() {
	return payMethod;
}
/**
 * @param payMethod the payMethod to set
 */
public void setPayMethod(String payMethod) {
	this.payMethod = payMethod;
}
/**
 * @return the payStatus
 */
public String getPayStatus() {
	return payStatus;
}
/**
 * @param payStatus the payStatus to set
 */
public void setPayStatus(String payStatus) {
	this.payStatus = payStatus;
}



}
