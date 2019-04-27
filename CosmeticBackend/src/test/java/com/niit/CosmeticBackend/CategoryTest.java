package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.CategoryDao;
import com.niit.CosmeticBackend.Model.Category;

public class CategoryTest {
	
	public static void main(String arg[])
	{
		
		
		
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
		c.scan("com.niit.*");
		c.refresh();
		
		Category cat = (Category)c.getBean("category");
	CategoryDao catDao= (CategoryDao)c.getBean("categoryDao");
	
   cat.setCatId("10");
	cat.setCatName("Lakshmi");
	
	System.out.println(cat.getCatId()+"\n"+cat.getCatName());
	
//save or update
	if(catDao.saveorupdate(cat)==true) 
	{
		System.out.println("Category saved Successfully");
	}
	else {
		System.out.println("Category Not Saved");
	}
	//adding data
	cat.setCatId("11");
	cat.setCatName("Varsha");
	
	System.out.println(cat.getCatId()+"\n"+cat.getCatName());
	if(catDao.saveorupdate(cat)==true)
	{
		System.out.println("Category Saved");
	}
	else {
		System.out.println("Category Not saved");
	}
	//adding data
	cat.setCatId("13");
	cat.setCatName("Hema");
	
	System.out.println(cat.getCatId()+"\n"+cat.getCatName());
	if(catDao.saveorupdate(cat)==true)
	{
		System.out.println("Category Saved");
	}
	else {
		System.out.println("Category Not saved");
	}
	//adding data
	cat.setCatId("12");
	cat.setCatName("Komal");
	
	System.out.println(cat.getCatId()+"\n"+cat.getCatName());
	if(catDao.saveorupdate(cat)==true)
	{
		System.out.println("Category Saved");
	}
	else {
		System.out.println("Category Not saved");
	}
	//adding data
	cat.setCatId("11");
	cat.setCatName("Varsha");
	
	System.out.println(cat.getCatId()+"\n"+cat.getCatName());
	if(catDao.saveorupdate(cat)==true)
	{
		System.out.println("Category Saved");
	}
	else {
		System.out.println("Category Not saved");
	}
	//Retrieve
	cat=catDao.getCategory("13");
	if(cat==null)
	{
		System.out.println("Category Not Found");
	}
	else
	{
		System.out.println("Category Id:"+cat.getCatId());
		System.out.println("Category Name:"+cat.getCatName());
	}
	
	//Delete
	cat=catDao.getCategory("12");
	if(cat==null)
	{
	System.out.println("Category Not Found");	
	}
	else if(catDao.delete(cat)==true)
	{
		System.out.println("Category deleted");
	}
	else
	{
		System.out.println("Not Deleted");
		
	}
	
	//Retrieve List
	List<Category>catlist = catDao.getCatList();
	for(Category c1 : catlist)
	{
		System.out.println("Cat Id :" + c1.getCatId());
		System.out.println("Cat Name:"+c1.getCatName() );
	}
	
	//end of main
	}
}


