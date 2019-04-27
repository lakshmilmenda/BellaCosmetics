package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.ShippingDao;
import com.niit.CosmeticBackend.Model.Shipping;

@Repository("shippingDao")
@Transactional

public class ShippingDaoImpl implements ShippingDao{

	@Autowired
	SessionFactory sessionFactory;
	public ShippingDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	public boolean saveorupdate(Shipping shipping) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return true;
	}

	public boolean delete(Shipping shipping) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(shipping);
		return true;
	}

	public Shipping getShipping(String shipId) {
		// TODO Auto-generated method stub
		
		String q1 = "from Shipping where shipId='"+shipId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		
		List<Shipping>list = (List<Shipping>)w.list();
		if(list==null||list.isEmpty())
		{
			return null; 
		}
		return list.get(0);
	}

	public List<Shipping> getshipList() {
		// TODO Auto-generated method stub
		List<Shipping> lists = (List<Shipping>)sessionFactory.getCurrentSession().createCriteria(Shipping.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return lists;
	}
	
	public List<Shipping> getUserId(String uId)
	{
		String q1 = "from Shipping where uId='"+uId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		
		List<Shipping>list = (List<Shipping>)w.list();
		if(list==null||list.isEmpty())
		{
			return null; 
		}
		return list;
	}

}
