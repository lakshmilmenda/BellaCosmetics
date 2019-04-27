package com.niit.CosmeticBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Shipping {

	@Id
	
	private String shipId;
	private String shipName;
	private String shipCity;
	private String shipState;
	private String shipPhoneNo;
	
	
	@ManyToOne
	@JoinColumn(name="uId")
	private User user;
	
	public Shipping()
	{
		this.shipId="SHIP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the shipId
	 */
	public String getShipId() {
		return shipId;
	}
	/**
	 * @param shipId the shipId to set
	 */
	public void setShipId(String shipId) {
		this.shipId = shipId;
	}
	/**
	 * @return the shipName
	 */
	public String getShipName() {
		return shipName;
	}
	/**
	 * @param shipName the shipName to set
	 */
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	/**
	 * @return the shipCity
	 */
	public String getShipCity() {
		return shipCity;
	}
	/**
	 * @param shipCity the shipCity to set
	 */
	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}
	/**
	 * @return the shipState
	 */
	public String getShipState() {
		return shipState;
	}
	/**
	 * @param shipState the shipState to set
	 */
	public void setShipState(String shipState) {
		this.shipState = shipState;
	}
	/**
	 * @return the shipPhoneNo
	 */
	public String getShipPhoneNo() {
		return shipPhoneNo;
	}
	/**
	 * @param shipPhoneNo the shipPhoneNo to set
	 */
	public void setShipPhoneNo(String shipPhoneNo) {
		this.shipPhoneNo = shipPhoneNo;
	}
	
	
}
