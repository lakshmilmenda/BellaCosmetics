package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.OrdersDao;
import com.niit.CosmeticBackend.Model.Orders;

@Repository("ordersDao")
@Transactional

public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	SessionFactory sessionFactory;
public  OrdersDaoImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
	
	public boolean saveorupdate(Orders orders) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(orders);
		return true;
	}

	public boolean delete(Orders orders) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(orders);
		return true;
	}

	public Orders getOrders(String orderId) {
		// TODO Auto-generated method stub
		String q1="from Orders where orderId='"+orderId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		
		List<Orders>list= (List<Orders>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
		
	}

	public List<Orders> getOrdersList() {
		// TODO Auto-generated method stub
			List<Orders> orders = (List<Orders>)sessionFactory.getCurrentSession().createCriteria(Orders.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return orders;
	}
	

}
