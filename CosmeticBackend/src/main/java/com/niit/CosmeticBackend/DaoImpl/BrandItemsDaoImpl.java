package com.niit.CosmeticBackend.DaoImpl;

	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.BrandItemsDao;
import com.niit.CosmeticBackend.Model.BrandItems;


	@Repository("brandItemsDao")
	@Transactional

	public class BrandItemsDaoImpl implements BrandItemsDao  {

		@Autowired
		SessionFactory sessionFactory;
		
		public BrandItemsDaoImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		
		
		public boolean saveorupdate(BrandItems brandItems) {
			// TODO Auto-generated method stub
			
			sessionFactory.getCurrentSession().saveOrUpdate(brandItems);
			return true;
			
		}

		public boolean delete(BrandItems brandItems) {
			// TODO Auto-generated method stub
			
			
			sessionFactory.getCurrentSession().delete(brandItems);
			return true;
		}

		public BrandItems getBrandItems(String brandItemsId) {
			// TODO Auto-generated method stub
			
			String q1 = "from BrandItems where brandItemsId = '"+brandItemsId+"'";
			Query w = sessionFactory.getCurrentSession().createQuery(q1);
			
			List<BrandItems> list = (List<BrandItems>)w.list();
			if(list==null||list.isEmpty())
			{
				return null;
			}
			return list.get(0);
		
		}

		public List<BrandItems> getBrandItemsList() {
			// TODO Auto-generated method stub
			
	List<BrandItems>brandItems = (List<BrandItems>)sessionFactory.getCurrentSession().createCriteria(BrandItems .class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			
			return brandItems;
			
		}


		@Override
		public List<BrandItems> getCatBrandList(String brandId) {
			// TODO Auto-generated method stub
			
			String q1 =  "from BrandItems where brandId = '"+brandId+"'";
			Query w = sessionFactory.getCurrentSession().createQuery(q1);
			List<BrandItems> brandItems = (List<BrandItems>)w.list();
			if(brandItems ==  null || brandItems.isEmpty())
			{
				return null;
			}
			return brandItems;
			
			
			
		}


	


	

	}

	
