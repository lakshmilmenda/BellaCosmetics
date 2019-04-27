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


public class Brand {

	@Id
		
		private String brandId;
		private String brandName;

		@Transient
		private MultipartFile bimg;
		
		@Transient
		private MultipartFile logo;
		
		
		/**
		 * @return the logo
		 */
		public MultipartFile getLogo() {
			return logo;
		}


		/**
		 * @param logo the logo to set
		 */
		public void setLogo(MultipartFile logo) {
			this.logo = logo;
		}


		@OneToMany(mappedBy="brand")
		private List<Product>product;
		
		
		//constructor for unique id generation
		public Brand()
		{
			this.brandId="BRAND"+UUID.randomUUID().toString().substring(30).toUpperCase();
		}


		/**
		 * @return the brandId
		 */
		public String getBrandId() {
			return brandId;
		}


		/**
		 * @param brandId the brandId to set
		 */
		public void setBrandId(String brandId) {
			this.brandId = brandId;
		}


		/**
		 * @return the brandName
		 */
		public String getBrandName() {
			return brandName;
		}


		/**
		 * @param brandName the brandName to set
		 */
		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}


		/**
		 * @return the bimg
		 */
		public MultipartFile getBimg() {
			return bimg;
		}


		/**
		 * @param bimg the bimg to set
		 */
		public void setBimg(MultipartFile bimg) {
			this.bimg = bimg;
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


	
		
		

		
		
	
}
