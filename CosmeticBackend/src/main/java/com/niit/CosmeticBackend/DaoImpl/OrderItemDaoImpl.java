package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.OrderItemDao;
import com.niit.CosmeticBackend.Model.OrderItem;

@Repository("orderItemDao")
@Transactional

public class OrderItemDaoImpl  implements OrderItemDao{

	SessionFactory sessionFactory;
	public OrderItemDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public boolean saveorupdate(OrderItem orderItem) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(orderItem);
		return true;
	
	}

	public boolean delete(OrderItem orderItem) {
		// TODO Auto-generated method stub
	
		sessionFactory.getCurrentSession().delete(orderItem);
		return true;
	
	}

	public OrderItem getOrderItem(String orderItemId) {
		// TODO Auto-generated method stub
		
		String q1 = "from OrderItem where orderItemId='"+orderItemId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		
		List<OrderItem> list = (List<OrderItem>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	public List<OrderItem> orderList() {
		// TODO Auto-generated method stub
		
		List<OrderItem> items = (List<OrderItem>)sessionFactory.getCurrentSession().createCriteria(OrderItem.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return items;
	}
	

}
