package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.BrandDao;
import com.niit.CosmeticBackend.Model.Brand;


	@Repository("brandDao")
	@Transactional

	public class BrandDaoImpl implements BrandDao {
		
		@Autowired
		SessionFactory sessionFactory;
		
		public BrandDaoImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		

		public boolean saveorupdate(Brand brand){
			// TODO Auto-generated method stub
			
			sessionFactory.getCurrentSession().saveOrUpdate(brand);
			return true;
			
		}

		public boolean delete(Brand brand) {
			// TODO Auto-generated method stub
			

			sessionFactory.getCurrentSession().delete(brand);
			return true;
			
		}

		public Brand getBrand(String brandId) {
			// TODO Auto-generated method stub

			String q1 = "from Brand where brandId = '"+brandId+"'";
			Query w = sessionFactory.getCurrentSession().createQuery(q1);
			
			List<Brand> list = (List<Brand>)w.list();
			if(list==null||list.isEmpty())
			{
				return null;
			}
			return list.get(0);
			
			
		}

		public List<Brand> getBrandList() {
			// TODO Auto-generated method stub


			List<Brand>brands = (List<Brand>)sessionFactory.getCurrentSession().createCriteria(Brand .class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			
			return brands;
			
		}


		

	}

	
	

