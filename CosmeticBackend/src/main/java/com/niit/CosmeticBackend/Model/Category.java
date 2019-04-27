package com.niit.CosmeticBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component

public class Category {

@Id
	
	private String catId;
	private String catName;

	@Transient
	private MultipartFile cimg;
	

	@Transient
	private MultipartFile clogo;
	
	
	@OneToMany(mappedBy="category")
	private List<Product>product;
	
	
	//constructor for unique id generation
	public Category()
	{
		this.catId="CAT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	

	
	/**
	 * @return the cimg
	 */
	public MultipartFile getCimg() {
		return cimg;
	}




	/**
	 * @param cimg the cimg to set
	 */
	public void setCimg(MultipartFile cimg) {
		this.cimg = cimg;
	}




	/**
	 * @return the clogo
	 */
	public MultipartFile getClogo() {
		return clogo;
	}




	/**
	 * @param clogo the clogo to set
	 */
	public void setClogo(MultipartFile clogo) {
		this.clogo = clogo;
	}




	/**
	 * @return the product
	 */
	public List<Product> getProduct() {
		return product;
	}




	/**
	 * @param product the product to set
	 */
	public void setProduct(List<Product> product) {
		this.product = product;
	}




	/**
	 * @return the catId
	 */
	public String getCatId() {
		return catId;
	}
	/**
	 * @param catId the catId to set
	 */
	public void setCatId(String catId) {
		this.catId = catId;
	}
	/**
	 * @return the catName
	 */
	public String getCatName() {
		return catName;
	}
	/**
	 * @param catName the catName to set
	 */
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
}
