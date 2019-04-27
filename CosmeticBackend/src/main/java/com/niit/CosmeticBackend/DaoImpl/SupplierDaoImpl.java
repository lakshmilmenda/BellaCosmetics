package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.SupplierDao;
import com.niit.CosmeticBackend.Model.Supplier;

@Repository("supplierDao")
@Transactional


public class SupplierDaoImpl implements SupplierDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean saveorupdate(Supplier supplier) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		
	}

	public boolean delete(Supplier supplier) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(supplier);
    	return true;

	}

	public Supplier getSupplier(String supId) {
		// TODO Auto-generated method stub
		
		String q1 = "from Supplier where supId = '"+supId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		
		List<Supplier> list = (List<Supplier>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	public List<Supplier> getSupList() {
		// TODO Auto-generated method stub


		List<Supplier>suppliers = (List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier .class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
 		return suppliers;
	}
		
}
