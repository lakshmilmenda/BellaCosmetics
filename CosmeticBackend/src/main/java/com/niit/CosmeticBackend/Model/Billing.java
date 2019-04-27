package com.niit.CosmeticBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component


public class Billing {
	
@Id

private String billId;
private String billName;
private String billCity;
private String billState;
private String billPhoneNo;

@OneToOne
@JoinColumn(name="userId")
private User user;

//constructor
public Billing()
{
	this.billId="BILL"+UUID.randomUUID().toString().substring(30).toUpperCase();
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
 * @return the billId
 */
public String getBillId() {
	return billId;
}
/**
 * @param billId the billId to set
 */
public void setBillId(String billId) {
	this.billId = billId;
}
/**
 * @return the billName
 */
public String getBillName() {
	return billName;
}
/**
 * @param billName the billName to set
 */
public void setBillName(String billName) {
	this.billName = billName;
}
/**
 * @return the billCity
 */
public String getBillCity() {
	return billCity;
}
/**
 * @param billCity the billCity to set
 */
public void setBillCity(String billCity) {
	this.billCity = billCity;
}
/**
 * @return the billState
 */
public String getBillState() {
	return billState;
}
/**
 * @param billState the billState to set
 */
public void setBillState(String billState) {
	this.billState = billState;
}
/**
 * @return the billPhoneNo
 */
public String getBillPhoneNo() {
	return billPhoneNo;
}
/**
 * @param billPhoneNo the billPhoneNo to set
 */
public void setBillPhoneNo(String billPhoneNo) {
	this.billPhoneNo = billPhoneNo;
}


	
	
	
}
