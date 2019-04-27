package com.niit.CosmeticBackend.Dao;

import java.util.List;

import com.niit.CosmeticBackend.Model.Card;



public interface CardDao {

	public boolean saveorupdate(Card card);
	public boolean delete(Card card);
	public Card getCard(String cardId);
	public List<Card>getCardList();
	public List<Card> getCardUser(String uId);
	

	
}
