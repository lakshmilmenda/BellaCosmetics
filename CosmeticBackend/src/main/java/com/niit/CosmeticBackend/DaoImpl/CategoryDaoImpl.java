package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.CategoryDao;
import com.niit.CosmeticBackend.Model.Category;

@Repository("categoryDao")
@Transactional

public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	

	public boolean saveorupdate(Category category) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
		
	}

	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		

		sessionFactory.getCurrentSession().delete(category);
		return true;
		
	}

	public Category getCategory(String catId) {
		// TODO Auto-generated method stub

		String q1 = "from Category where catId = '"+catId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		
		List<Category> list = (List<Category>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
		
		
	}

	public List<Category> getCatList() {
		// TODO Auto-generated method stub


		List<Category>categories = (List<Category>)sessionFactory.getCurrentSession().createCriteria(Category .class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return categories;
		
	}
	

}
