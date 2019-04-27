package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.UserDao;
import com.niit.CosmeticBackend.Model.Authentication;
import com.niit.CosmeticBackend.Model.Billing;
import com.niit.CosmeticBackend.Model.Cart;
import com.niit.CosmeticBackend.Model.User;

@Repository("userDao")
@Transactional


public class UserDaoImpl  implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	public boolean saveorupdate(User user) {
		// TODO Auto-generated method stub
		Authentication auth = new Authentication();
		auth.setUserName(user.getuEmail());
		Billing bill = new Billing();
		bill.setBillName(user.getuName());
		bill.setBillCity(user.getuAdd());
		bill.setBillState(user.getuAdd());
		bill.setBillPhoneNo(user.getuPhoneNo());
		sessionFactory.getCurrentSession().saveOrUpdate(bill);
		bill.setUser(user);
		Cart c = new Cart();
		user.setBilling(bill);
		user.setCart(c);
		sessionFactory.getCurrentSession().saveOrUpdate(user.getBilling());
		sessionFactory.getCurrentSession().saveOrUpdate(user.getCart());
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		sessionFactory.getCurrentSession().saveOrUpdate(auth);
		
		return true;
		
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	public User getUser(String uId) {
		// TODO Auto-generated method stub
		
		String q1 = "from User where uId = '"+uId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		
		List<User> list = (List<User>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
		
	}

	public List<User> getUList() {
		// TODO Auto-generated method stub
		List<User>users = (List<User>)sessionFactory.getCurrentSession().createCriteria(User .class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return users;

		
	}


	@Override
	public User isValid(String umail, String pwd) {
		// TODO Auto-generated method stub
	
		String q1 ="from User where uEmail='"+umail+"' and Password = '"+pwd+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<User> list = (List<User>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}
		
	public User getEmail(String curusername)
	{
		String user = "from User where uEmail='"+curusername+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(user);
		List<User> ulist = (List<User>)q.list();
		if(ulist==null||ulist.isEmpty())
		{
			return null;
		}
		else {
			return ulist.get(0);
		}
	}
	
}
