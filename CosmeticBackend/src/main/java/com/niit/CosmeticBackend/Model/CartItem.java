package com.niit.CosmeticBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class CartItem {
	
@Id

private String cartItemsId;
private double price;

@ManyToOne
@JoinColumn(name="cartId")
private Cart cart;

@OneToOne
@JoinColumn(name="proId")
private Product product;

public CartItem()
{
	this.cartItemsId="CARTITEM"+UUID.randomUUID().toString().substring(30).toUpperCase();
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
 * @return the product
 */
public Product getProduct() {
	return product;
}
/**
 * @param product the product to set
 */
public void setProduct(Product product) {
	this.product = product;
}
/**
 * @return the cartItemsId
 */
public String getCartItemsId() {
	return cartItemsId;
}
/**
 * @param cartItemsId the cartItemsId to set
 */
public void setCartItemsId(String cartItemsId) {
	this.cartItemsId = cartItemsId;
}
/**
 * @return the price
 */


/**
 * @return the price
 */
public double getPrice() {
	return price;
}


/**
 * @param price the price to set
 */
public void setPrice(double price) {
	this.price = price;
}




}
