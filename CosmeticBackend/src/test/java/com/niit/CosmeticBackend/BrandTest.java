package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.BrandDao;
import com.niit.CosmeticBackend.Model.Brand;

public class BrandTest {
		
		public static void main(String arg[])
		{
				
			AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
			c.scan("com.niit.*");
			c.refresh();
			
			Brand brand = (Brand)c.getBean("brand");
			BrandDao brandDao= (BrandDao)c.getBean("brandDao");
		
			brand.setBrandId("BRANDC6C345");
			brand.setBrandName("Lakshmi");
		
		System.out.println(brand.getBrandId()+"\n"+brand.getBrandName());
		
	//save or update
		if(brandDao.saveorupdate(brand)==true) 
		{
			System.out.println("brand saved Successfully");
		}
		else {
			System.out.println("brand Not Saved");
		}
		//adding data
		brand.setBrandId("BRAND6AD49C");
		brand.setBrandName("Varsha");
		
		System.out.println(brand.getBrandId()+"\n"+brand.getBrandName());
		if(brandDao.saveorupdate(brand)==true)
		{
			System.out.println("brand Saved");
		}
		else {
			System.out.println("brand Not saved");
		}
		//adding data
		brand.setBrandId("12");
		brand.setBrandName("Hema");
		
		System.out.println(brand.getBrandId()+"\n"+brand.getBrandName());
		if(brandDao.saveorupdate(brand)==true)
		{
			System.out.println("brand Saved");
		}
		else {
			System.out.println("brand Not saved");
		}
	
		//Retrieve
		brand=brandDao.getBrand("12");
		if(brand==null)
		{
			System.out.println("brand Not Found");
		}
		else
		{
			System.out.println("brand Id:"+brand.getBrandId());
			System.out.println("brand Name:"+brand.getBrandName());
		}
		
		//Delete
		brand=brandDao.getBrand("12");
		if(brand==null)
		{
		System.out.println("brand Not Found");	
		}
		else if(brandDao.delete(brand)==true)
		{
			System.out.println("brand deleted");
		}
		else
		{
			System.out.println("Not Deleted");
			
		}
		
		//Retrieve List
		List<Brand>brandlist = brandDao.getBrandList();
		for(Brand c1 : brandlist)
		{
			System.out.println("Cat Id :" + c1.getBrandId());
			System.out.println("Cat Name:"+c1.getBrandName() );
		}
		
		//end of main
		}
	}



	
	

