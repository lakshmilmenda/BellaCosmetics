package com.niit.CosmeticBackend.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component


public class Product {

@Id
	

	
	private String proId;
	private String proName;
	private double proPrice;
	private int proQuant;
	
   @Column( length = 100000 )
	private String proDes;
	
	@ManyToOne
	@JoinColumn(name="catId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supId")	
	private Supplier supplier;	
	
	
	@ManyToOne
	@JoinColumn(name="brandId")	
	private Brand brand;	
	
	@Transient
	private MultipartFile ping;
	
	
	public Product()
	{
		this.proId="PRO"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	
	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}



	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}



	/**
	 * @return the ping
	 */
	public MultipartFile getPing() {
		return ping;
	}



	/**
	 * @param ping the ping to set
	 */
	public void setPing(MultipartFile ping) {
		this.ping = ping;
	}



	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}
	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	/**
	 * @return the proId
	 */
	public String getProId() {
		return proId;
	}
	/**
	 * @param proId the proId to set
	 */
	public void setProId(String proId) {
		this.proId = proId;
	}
	/**
	 * @return the proName
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * @param proName the proName to set
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * @return the proPrice
	 */
	public double getProPrice() {
		return proPrice;
	}
	/**
	 * @param proPrice the proPrice to set
	 */
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	/**
	 * @return the proQuant
	 */
	public int getProQuant() {
		return proQuant;
	}
	/**
	 * @param proQuant the proQuant to set
	 */
	public void setProQuant(int proQuant) {
		this.proQuant = proQuant;
	}
	/**
	 * @return the proDes
	 */
	public String getProDes() {
		return proDes;
	}
	/**
	 * @param proDes the proDes to set
	 */
	public void setProDes(String proDes) {
		this.proDes = proDes;
	}
	
	
	
}
