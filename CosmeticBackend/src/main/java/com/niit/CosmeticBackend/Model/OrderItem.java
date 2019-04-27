package com.niit.CosmeticBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class OrderItem {
@Id

private String orderItemId;
private String productId;

@ManyToOne
@JoinColumn(name="orderId")
private Orders orders;

public OrderItem()
{
this.orderItemId="ORDERITEM"+UUID.randomUUID().toString().substring(30).toUpperCase();	
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
 * @return the orderItemId
 */
public String getOrderItemId() {
	return orderItemId;
}
/**
 * @param orderItemId the orderItemId to set
 */
public void setOrderItemId(String orderItemId) {
	this.orderItemId = orderItemId;
}
/**
 * @return the productId
 */
public String getProductId() {
	return productId;
}
/**
 * @param productId the productId to set
 */
public void setProductId(String productId) {
	this.productId = productId;
}


}
