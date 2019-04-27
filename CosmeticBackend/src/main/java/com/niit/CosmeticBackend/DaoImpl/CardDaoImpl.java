package com.niit.CosmeticBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticBackend.Dao.CardDao;
import com.niit.CosmeticBackend.Model.Card;

@Repository("cardDao")
@Transactional


public class CardDaoImpl implements CardDao {

	@Autowired
	SessionFactory sessionFactory;
	public CardDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(Card card) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(card);
		return true;
	}

	@Override
	public boolean delete(Card card) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(card);
		return true; 
	}

	@Override
	public Card getCard(String cardId) {
		// TODO Auto-generated method stub
		String q1= "from Card where cardId ='"+cardId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Card> list = (List<Card>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Card> getCardList() {
		// TODO Auto-generated method stub
		List<Card> cardList =  (List<Card>)sessionFactory.getCurrentSession().createCriteria(Card.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cardList;
	}

	@Override
	public List<Card> getCardUser(String uId) {
		// TODO Auto-generated method stub
		String q1= "from Card where uId ='"+uId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Card> list = (List<Card>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list;
	}
	

	
	
}
