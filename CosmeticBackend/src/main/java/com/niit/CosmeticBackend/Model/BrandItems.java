package com.niit.CosmeticBackend.Model;

import java.util.UUID;

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

public class BrandItems {

	@Id
		

		
		private String brandItemsId;
		private String brandItemsName;
		private double brandItemsPrice;
		private int brandItemsQuant;
		private String brandItemsDes;
		
		@ManyToOne
		@JoinColumn(name="brandId")
		private Brand brand;
				
		@Transient
		private MultipartFile biimg;
		
		
		public BrandItems()
		{
			this.brandItemsId="	BANDITEMS"+UUID.randomUUID().toString().substring(30).toUpperCase();
		}


		/**
		 * @return the brandItemsId
		 */
		public String getBrandItemsId() {
			return brandItemsId;
		}


		/**
		 * @param brandItemsId the brandItemsId to set
		 */
		public void setBrandItemsId(String brandItemsId) {
			this.brandItemsId = brandItemsId;
		}


		/**
		 * @return the brandItemsName
		 */
		public String getBrandItemsName() {
			return brandItemsName;
		}


		/**
		 * @param brandItemsName the brandItemsName to set
		 */
		public void setBrandItemsName(String brandItemsName) {
			this.brandItemsName = brandItemsName;
		}


		/**
		 * @return the brandItemsPrice
		 */
		public double getBrandItemsPrice() {
			return brandItemsPrice;
		}


		/**
		 * @param brandItemsPrice the brandItemsPrice to set
		 */
		public void setBrandItemsPrice(double brandItemsPrice) {
			this.brandItemsPrice = brandItemsPrice;
		}


		/**
		 * @return the brandItemsQuant
		 */
		public int getBrandItemsQuant() {
			return brandItemsQuant;
		}


		/**
		 * @param brandItemsQuant the brandItemsQuant to set
		 */
		public void setBrandItemsQuant(int brandItemsQuant) {
			this.brandItemsQuant = brandItemsQuant;
		}


		/**
		 * @return the brandItemsDes
		 */
		public String getBrandItemsDes() {
			return brandItemsDes;
		}


		/**
		 * @param brandItemsDes the brandItemsDes to set
		 */
		public void setBrandItemsDes(String brandItemsDes) {
			this.brandItemsDes = brandItemsDes;
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
		 * @return the biimg
		 */
		public MultipartFile getBiimg() {
			return biimg;
		}


		/**
		 * @param biimg the biimg to set
		 */
		public void setBiimg(MultipartFile biimg) {
			this.biimg = biimg;
		}
		
		
		
		

	
	
}
