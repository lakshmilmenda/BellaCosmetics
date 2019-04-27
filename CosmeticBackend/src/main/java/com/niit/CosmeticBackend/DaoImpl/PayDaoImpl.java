package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.PayDao;
import com.niit.CosmeticBackend.Model.Pay;

@Repository("payDao")
@Transactional

public class PayDaoImpl implements PayDao {

	
	@Autowired
	SessionFactory sessionFactory;
	public PayDaoImpl (SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public boolean saveorupdate(Pay pay) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
		return true;
		
	}

	public boolean delete(Pay pay) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(pay);
		return true;
	}

	public Pay getPay(String payId) {
		// TODO Auto-generated method stub
		
		String q1="from Pay where payId='"+payId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		
		List<Pay> paylist = (List<Pay>)w.list();
		if(paylist==null||paylist.isEmpty())
		{
			return null;
		}
		return paylist.get(0); 
		
	}

	public List<Pay> getPayList() {
		// TODO Auto-generated method stub
	
		List<Pay>pays=(List<Pay>)sessionFactory.getCurrentSession().createCriteria(Pay.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return pays;
	}


	
}
