package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.CartDao;
import com.niit.CosmeticBackend.Model.Cart;

public class CartTest {

public static void main(String arg[])
{
	AnnotationConfigApplicationContext ctx =new  AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	
	
	Cart c =(Cart)ctx.getBean("cart");
	CartDao cDao=(CartDao)ctx.getBean("cartDao");
	
	//save or update
	//adding data
	c.setCartId("10");
	c.setGrandTotal(100.0);
	c.setTotalItems(1);
	
	System.out.println("Cart Id :"+c.getCartId()+"\n Grand Total:"+c.getGrandTotal()+"\nTotal items"+c.getTotalItems());
	
	if(cDao.saveorupdate(c)==true)
	{
		System.out.println("Cart saved");
		
	}
	else {
		System.out.println("Cart not Saved");
	}
	
	//adding data
		c.setCartId("11");
		c.setGrandTotal(1000000.0);
		c.setTotalItems(10);
		
		System.out.println("Cart Id :"+c.getCartId()+"\n Grand Total:"+c.getGrandTotal()+"\nTotal items"+c.getTotalItems());
		
		if(cDao.saveorupdate(c)==true)
		{
			System.out.println("Cart saved");
			
		}
		else {
			System.out.println("Cart not Saved");
		}
		
		//adding data
		c.setCartId("12");
		c.setGrandTotal(3000.0);
		c.setTotalItems(2);
		
		System.out.println("Cart Id :"+c.getCartId()+"\n Grand Total:"+c.getGrandTotal()+"\nTotal items"+c.getTotalItems());
		
		if(cDao.saveorupdate(c)==true)
		{
			System.out.println("Cart saved");
			
		}
		else {
			System.out.println("Cart not Saved");
		}
		
	//retrieve
		c=cDao.getCart("10");
		if(c==null)
		{
			System.out.println("Cart not found");
		}
		else {
			System.out.println("Cart Id :"+c.getCartId()+"\n Grand Total:"+c.getGrandTotal()+"\nTotal items"+c.getTotalItems());
		}
		
		//delete
		c=cDao.getCart("11");
		if(c==null)
		{
			System.out.println("Cart not deleted");
		}
		else if(cDao.delete(c)==true)
		{
			System.out.println("Cart Deleted");
		}
		else {
			System.out.println("Not found");
		}
		
		//retrieve list
		List<Cart> cartlist = cDao.getCartList();
		for(Cart c1:cartlist )
		{
			System.out.println("Cart Id :"+c1.getCartId()+"\n Grand Total:"+c1.getGrandTotal()+"\nTotal items"+c1.getTotalItems());
		}
		
		//end of main	
}
}
