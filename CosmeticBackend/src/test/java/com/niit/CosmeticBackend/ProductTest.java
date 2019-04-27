package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.BrandDao;
import com.niit.CosmeticBackend.Dao.CategoryDao;
import com.niit.CosmeticBackend.Dao.ProductDao;
import com.niit.CosmeticBackend.Dao.SupplierDao;
import com.niit.CosmeticBackend.Model.Brand;
import com.niit.CosmeticBackend.Model.Category;
import com.niit.CosmeticBackend.Model.Product;
import com.niit.CosmeticBackend.Model.Supplier;

public class ProductTest {

	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
		c.scan("com.niit.*");
		c.refresh();
		
		Product pro = (Product)c.getBean("product");
		ProductDao proDao= (ProductDao)c.getBean("productDao");
	
	
	Category cat = (Category)c.getBean("category");
	CategoryDao catDao=(CategoryDao)c.getBean("categoryDao");
	
	
	Supplier sup = (Supplier)c.getBean("supplier");
	SupplierDao supDao=(SupplierDao)c.getBean("supplierDao");
	
	Brand brand = (Brand)c.getBean("brand");
	BrandDao brandDao = (BrandDao)c.getBean("brandDao");
	
	sup=supDao.getSupplier("10");
	
	cat = catDao.getCategory("10");
	
	brand=brandDao.getBrand("10");
	pro.setProId("10");
	pro.setProName("product1");
	pro.setProPrice(10000);
	pro.setProQuant(2);
	pro.setProDes("hellooooo");
	pro.setCategory(cat);
	pro.setSupplier(sup);
	pro.setBrand(brand);
	
	System.out.println(pro.getProId()+"\n"+pro.getProName()+"\n"+pro.getProPrice()+"\n"+pro.getProQuant()+"\n"+pro.getProDes());
	//save or update
		if(proDao.saveorupdate(pro)==true) 
		{
			System.out.println("Product  saved Successfully");
		}
		else {
			System.out.println("Product  Not Saved");
		}
		//adding data
		brand=brandDao.getBrand("11");
		sup=supDao.getSupplier("11");
		cat = catDao.getCategory("11");
		pro.setProId("11");
		pro.setProName("product2");
		pro.setProPrice(20000);
		pro.setProQuant(3);
		pro.setProDes("hiiiii");
		pro.setCategory(cat);
		pro.setSupplier(sup);
		pro.setBrand(brand);
		
		System.out.println(pro.getProId()+"\n"+pro.getProName()+"\n"+pro.getProPrice()+"\n"+pro.getProQuant()+"\n"+pro.getProDes());
		//save or update
			if(proDao.saveorupdate(pro)==true) 
			{
				System.out.println("Product  saved Successfully");
			}
			else {
				System.out.println("Product  Not Saved");
			}
			
			//adding data
			
			brand=brandDao.getBrand("12");
			sup=supDao.getSupplier("12");
			cat = catDao.getCategory("12");
			pro.setProId("12");
			pro.setProName("product3");
			pro.setProPrice(30000);
			pro.setProQuant(4);
			pro.setProDes("hollaa");
			pro.setCategory(cat);
			pro.setSupplier(sup);
			pro.setBrand(brand);
			
			System.out.println(pro.getProId()+"\n"+pro.getProName()+"\n"+pro.getProPrice()+"\n"+pro.getProQuant()+"\n"+pro.getProDes());
			//save or update
				if(proDao.saveorupdate(pro)==true) 
				{
					System.out.println("Product  saved Successfully");
				}
				else {
					System.out.println("Product  Not Saved");
				}
				//Retrieve
				pro=proDao.getProduct("10");
				if(pro==null)
				{
					System.out.println("Product Not Found");
				}
				else
				{
					System.out.println("Product Id:"+pro.getProId());
					System.out.println("Product Name:"+pro.getProName());
					System.out.println("Product Price:"+pro.getProPrice());
					System.out.println("Product Quant:"+pro.getProQuant());
					System.out.println("Product Description:"+pro.getProDes());
				}
				
				//Delete
				pro=proDao.getProduct("12");
				if(pro==null)
				{
				System.out.println("Product Not Found");	
				}
				else if(proDao.delete(pro)==true)
				{
					System.out.println("Product deleted");
				}
				else
				{
					System.out.println("Not Deleted");
					
				}
				
				//Retrieve List
				List<Product>prolist = proDao.getProList();
				for(Product p1 : prolist)
				{
					System.out.println("Product Id :" + p1.getProId());
					System.out.println("Product Name:"+p1.getProName() );
					System.out.println("Product Price:"+p1.getProPrice());
					System.out.println("Product Quantity:"+p1.getProQuant());
					System.out.println("Product description:"+p1.getProDes());
				}
				
				//end of main
		
	
	}
	
}
