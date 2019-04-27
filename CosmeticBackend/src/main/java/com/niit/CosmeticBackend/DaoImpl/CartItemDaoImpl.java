package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.CosmeticBackend.Dao.CartItemDao;
import com.niit.CosmeticBackend.Model.CartItem;
import com.niit.CosmeticBackend.Model.User;

@Repository("cartItemDao")
@Transactional

public class CartItemDaoImpl implements CartItemDao{
	
	@Autowired
	SessionFactory sessionFactory;
	public CartItemDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean saveorupdate(CartItem cartItem) {
		// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
	return true;
	}

	public boolean delete(CartItem cartItem) {
		// TODO Auto-generated method stub
//		CartItem cartItems= new CartItem();
//	String c=cartItems.setCartItemsId(cartItems.getCartItemsId());
		sessionFactory.getCurrentSession().delete(cartItem);
		return true;
		
	}

	public CartItem getCartItem(String cartItemsId) {
		// TODO Auto-generated method stub
		
		String q1="from CartItem where cartItemsId='"+cartItemsId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		
		List<CartItem> list = (List<CartItem>)w.list();
		if(list==null||list.isEmpty()) {
			return null;
		}
		return list.get(0);
		
	}

	public List<CartItem> getCartItemList() {
		// TODO Auto-generated method stub
		List<CartItem>cart=(List<CartItem>)sessionFactory.getCurrentSession().createCriteria(CartItem.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cart;
	}

	@Override
	public List<CartItem> getlist(String cartId) {
		String q1="from CartItem where cartId='"+cartId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		
		List<CartItem> list = (List<CartItem>)w.list();
		if(list==null||list.isEmpty()) {
			return null;
		}
		return list;
		
	}

	

	@Override
	public CartItem getlistall(String cartId, String proId) {
		// TODO Auto-generated method stub

		String q1 ="from CartItem where cartId='"+cartId+"' and proId = '"+proId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<CartItem> list = (List<CartItem>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		else {
			return list.get(0);
		}
	} 
	

}
