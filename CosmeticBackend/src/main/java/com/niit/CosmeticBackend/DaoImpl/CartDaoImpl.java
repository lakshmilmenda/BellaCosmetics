package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.CartDao;
import com.niit.CosmeticBackend.Model.Cart;

@Repository("cartDao")
@Transactional

public class CartDaoImpl  implements CartDao{

	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	public boolean saveorupdate(Cart cart) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	public boolean delete(Cart cart) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(cart);
		return true;
	}

	public Cart getCart(String cartId) {
		// TODO Auto-generated method stub
		String q1 = "from Cart where cartId='"+cartId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		
		List<Cart> list= (List<Cart>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	public List<Cart> getCartList() {
		// TODO Auto-generated method stub
		List<Cart>carts=(List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	return carts;
	}

}
