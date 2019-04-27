package com.niit.CosmeticBackend.Dao;

import java.util.List;

import com.niit.CosmeticBackend.Model.CartItem;

public interface CartItemDao {

	public boolean saveorupdate(CartItem cartItem);
	public boolean delete(CartItem cartItemsId);
	public CartItem getCartItem(String cartItemsId);
	public List<CartItem>getCartItemList();
	public List<CartItem> getlist(String cartId);
	public CartItem getlistall(String cartId, String proId);
	
	
}
