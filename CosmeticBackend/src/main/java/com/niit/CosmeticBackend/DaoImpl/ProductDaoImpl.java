package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.ProductDao;
import com.niit.CosmeticBackend.Model.Product;
import com.niit.CosmeticBackend.Model.User;

@Repository("productDao")
@Transactional

public class ProductDaoImpl implements ProductDao  {

	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	public boolean saveorupdate(Product product) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
		
	}

	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		
		
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	public Product getProduct(String proId) {
		// TODO Auto-generated method stub
		
		String q1 = "from Product where proId = '"+proId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		
		List<Product> list = (List<Product>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	
	}

	public List<Product> getProList() {
		// TODO Auto-generated method stub
		
List<Product>products = (List<Product>)sessionFactory.getCurrentSession().createCriteria(Product .class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return products;
		
	}


	@Override
	public List<Product> getCatProList(String catId) {
		// TODO Auto-generated method stub
		
		String q1 =  "from Product where catId = '"+catId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Product> products = (List<Product>)w.list();
		if(products ==  null || products.isEmpty())
		{
			return null;
		}
		return products;
		
		
		
	}

	@Override
	public List<Product> getBrandProList(String brandId) {
		// TODO Auto-generated method stub
		
		String q1 =  "from Product where brandId = '"+brandId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Product> products = (List<Product>)w.list();
		if(products ==  null || products.isEmpty())
		{
			return null;
		}
		return products;
		
		
		
	}
	

}
