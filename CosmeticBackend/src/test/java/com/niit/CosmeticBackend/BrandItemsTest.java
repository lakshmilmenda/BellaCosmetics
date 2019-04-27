package com.niit.CosmeticBackend;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.BrandDao;
import com.niit.CosmeticBackend.Dao.BrandItemsDao;
import com.niit.CosmeticBackend.Model.Brand;
import com.niit.CosmeticBackend.Model.BrandItems;

public class BrandItemsTest {

		public static void main(String arg[])
		{
			
			AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
			c.scan("com.niit.*");
			c.refresh();
			
			BrandItems bi = (BrandItems)c.getBean("brandItems");
			BrandItemsDao biDao= (BrandItemsDao)c.getBean("brandItemsDao");
		
		
		Brand brand = (Brand)c.getBean("brand");
		BrandDao brandDao=(BrandDao)c.getBean("brandDao");
		
		
	
		
	
		
		bi.setBrandItemsId("10");
		bi.setBrandItemsName("product1");
		bi.setBrandItemsPrice(10000);
		bi.setBrandItemsQuant(2);
		bi.setBrandItemsDes("hellooooo");
		brand=brandDao.getBrand("10");
		bi.setBrand(brand);
		
		
		System.out.println(bi.getBrandItemsId()+"\n"+bi.getBrandItemsName()+"\n"+bi.getBrandItemsPrice()+"\n"+bi.getBrandItemsQuant()+"\n"+bi.getBrandItemsDes());
		//save or update
			if(biDao.saveorupdate(bi)==true) 
			{
				System.out.println("BrandItems  saved Successfully");
			}
			else {
				System.out.println("BrandItems  Not Saved");
			}
			//adding data
			
			bi.setBrandItemsId("11");
			bi.setBrandItemsName("product2");
			bi.setBrandItemsPrice(10000);
			bi.setBrandItemsQuant(3);
			bi.setBrandItemsDes("hi");
			brand=brandDao.getBrand("11");
			bi.setBrand(brand);
			
			
			
			System.out.println(bi.getBrandItemsId()+"\n"+bi.getBrandItemsName()+"\n"+bi.getBrandItemsPrice()+"\n"+bi.getBrandItemsQuant()+"\n"+bi.getBrandItemsDes());
			//save or update
				if(biDao.saveorupdate(bi)==true) 
				{
					System.out.println("BrandItems  saved Successfully");
				}
				else {
					System.out.println("BrandItems  Not Saved");
				}
				//adding data
				
				
				bi.setBrandItemsId("12");
				bi.setBrandItemsName("product3");
				bi.setBrandItemsPrice(30000);
				bi.setBrandItemsQuant(2);
				bi.setBrandItemsDes("Hola");
				brand=brandDao.getBrand("12");
				bi.setBrand(brand);
				
				
				
				System.out.println(bi.getBrandItemsId()+"\n"+bi.getBrandItemsName()+"\n"+bi.getBrandItemsPrice()+"\n"+bi.getBrandItemsQuant()+"\n"+bi.getBrandItemsDes());
				//save or update
					if(biDao.saveorupdate(bi)==true) 
					{
						System.out.println("BrandItems  saved Successfully");
					}
					else {
						System.out.println("BrandItems  Not Saved");
					}
					//Retrieve
					bi=biDao.getBrandItems("10");
					if(bi==null)
					{
						System.out.println("BrandItems Not Found");
					}
					else
					{
						System.out.println("BrandItems Id:"+bi.getBrandItemsId());
						System.out.println("BrandItems Name:"+bi.getBrandItemsName());
						System.out.println("BrandItems Price:"+bi.getBrandItemsPrice());
						System.out.println("BrandItems Quant:"+bi.getBrandItemsQuant());
						System.out.println("BrandItems Description:"+bi.getBrandItemsDes());
					}
					
					//Delete
					bi=biDao.getBrandItems("12");
					if(bi==null)
					{
					System.out.println("BrandItems Not Found");	
					}
					else if(biDao.delete(bi)==true)
					{
						System.out.println("BrandItems deleted");
					}
					else
					{
						System.out.println("Not Deleted");
						
					}
					
					//Retrieve List
					List<BrandItems>bilist = biDao.getBrandItemsList();
					for(BrandItems p1 : bilist)
					{
						System.out.println("BrandItems Id :" + p1.getBrandItemsId());
						System.out.println("BrandItems Name:"+p1.getBrandItemsName() );
						System.out.println("BrandItems Price:"+p1.getBrandItemsPrice());
						System.out.println("BrandItems Quantity:"+p1.getBrandItemsQuant());
						System.out.println("BrandItems description:"+p1.getBrandItemsDes());
					}
					
					//end of main
			
		
		}
		
	}

	
	
