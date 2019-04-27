package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.AuthenticationDao;
import com.niit.CosmeticBackend.Model.Authentication;

@Repository("authenticationDao")
@Transactional

public class AuthenticationDaoImpl  implements AuthenticationDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public  AuthenticationDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	

	public boolean saveorupdate(Authentication authentication) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
		
				
	}

	public boolean delete(Authentication authentication) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(authentication);
		return true;
	}

	public Authentication getAuthentication(String roleId) {
		// TODO Auto-generated method stub
		String q1 = "from Authentication where roleId='"+roleId+"'";
		Query w= sessionFactory.getCurrentSession().createQuery(q1);
		
		List<Authentication>list=(List<Authentication>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
			
	}

	public List<Authentication> authenticationList() {
		// TODO Auto-generated method stub
		List<Authentication> authentications= (List<Authentication>)sessionFactory.getCurrentSession().createCriteria(Authentication.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return authentications;
	}

}
