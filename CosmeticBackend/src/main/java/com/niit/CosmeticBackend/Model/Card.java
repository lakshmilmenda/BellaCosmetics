package com.niit.CosmeticBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table

public class Card {

	@Id
	
	String cardId;
	String cardNum;
	String cardHolderName;
	int cardCvv;
	
	public Card()
	{
		this.cardId="CARD"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	
	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}
	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	/**
	 * @return the cardNum
	 */
	public String getCardNum() {
		return cardNum;
	}
	/**
	 * @param cardNum the cardNum to set
	 */
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	/**
	 * @return the cardHolderName
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}
	/**
	 * @param cardHolderName the cardHolderName to set
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	/**
	 * @return the cardCvv
	 */
	public int getCardCvv() {
		return cardCvv;
	}
	/**
	 * @param cardCvv the cardCvv to set
	 */
	public void setCardCvv(int cardCvv) {
		this.cardCvv = cardCvv;
	}
	
	
	
	
}
