package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.BillingDao;
import com.niit.CosmeticBackend.Model.Billing;
import com.niit.CosmeticBackend.Model.User;

@Repository("billingDao")
@Transactional

public class BillingDaoImpl implements BillingDao {

	SessionFactory sessionFactory;
	
	public BillingDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public boolean saveorupdate(Billing billing) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(billing);
		return true;
	
	}

	public boolean delete(Billing billing) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(billing);
		return true;
	
	}

	public Billing getBill(String billId) {
		// TODO Auto-generated method stub
		
	String q1="from Billing where billId='"+billId+"'";
	Query w =sessionFactory.getCurrentSession().createQuery(q1);
	List<Billing>list=(List<Billing>)w.list();
	if(list==null || list.isEmpty())
	{
		return null;
	}
	return list.get(0);
	
	}

	public List<Billing> getBillList() {
		// TODO Auto-generated method stub
		
		List<Billing> billings =(List<Billing>)sessionFactory.getCurrentSession().createCriteria(Billing.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return billings;
		
	}

	@Override
	public Billing getUserId(String userId) {
		// TODO Auto-generated method stub
			String Id = "from Billing where userId='"+userId+"'";
			Query q = sessionFactory.getCurrentSession().createQuery(Id);
			List<Billing> ulist = (List<Billing>)q.list();
			if(ulist==null||ulist.isEmpty())
			{
				return null;
			}
			return ulist.get(0);
			
		}
	
	

}
