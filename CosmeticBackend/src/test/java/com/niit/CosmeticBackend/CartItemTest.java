package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.CartDao;
import com.niit.CosmeticBackend.Dao.CartItemDao;
import com.niit.CosmeticBackend.Dao.ProductDao;
import com.niit.CosmeticBackend.Model.Cart;
import com.niit.CosmeticBackend.Model.CartItem;
import com.niit.CosmeticBackend.Model.Product;

public class CartItemTest {
	
	public static void main(String arg[]) {
		
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
		c.scan("com.niit.*");
		c.refresh();
		
		CartItem ci =(CartItem)c.getBean("cartItem");
		CartItemDao ciDao = (CartItemDao)c.getBean("cartItemDao");
		
		Cart car = (Cart)c.getBean("cart");
		CartDao carDao=(CartDao)c.getBean("cartDao");
		
		Product pro=(Product)c.getBean("product");
		ProductDao proDao=(ProductDao)c.getBean("productDao");
		
		
		//save or update
		//adding data
		
		car=carDao.getCart("10");
		pro=proDao.getProduct("10");
		
		ci.setCartItemsId("10");
		ci.setPrice(100.0f);
		
		ci.setCart(car);
		ci.setProduct(pro);
		
		System.out.println("Cart Item Id:"+ci.getCartItemsId()+"\n Cart Item Price:"+ci.getPrice());
		if(ciDao.saveorupdate(ci)==true)
		{
			System.out.println("Cart Item saved");
			
		}
		else {
			System.out.println("Cart Item not saved");
		}
		
		//adding data
				car=carDao.getCart("11");
				pro=proDao.getProduct("11");
				
				ci.setCartItemsId("11");
				ci.setPrice(200.0f);
				
				ci.setCart(car);
				ci.setProduct(pro);
				
				
				System.out.println("Cart Item Id:"+ci.getCartItemsId()+"\n Cart Item Price:"+ci.getPrice());
				if(ciDao.saveorupdate(ci)==true)
				{
					System.out.println("Cart Item saved");
					
				}
				else {
					System.out.println("Cart Item not saved");
				}
				
				//adding data
				car=carDao.getCart("12");
				pro=proDao.getProduct("12");
				
				ci.setCartItemsId("12");
				ci.setPrice(300.0f);
				
				ci.setCart(car);
				ci.setProduct(pro);
				
				System.out.println("Cart Item Id:"+ci.getCartItemsId()+"\n Cart Item Price:"+ci.getPrice());
				if(ciDao.saveorupdate(ci)==true)
				{
					System.out.println("Cart Item saved");
					
				}
				else {
					System.out.println("Cart Item not saved");
				}
					
				//retrieve
				
				ci=ciDao.getCartItem("10");
				if(ci==null)
				{
					System.out.println("Cart Item not found");
					
				}
				else {
					System.out.println("Cart Item Id:"+ci.getCartItemsId()+"\n Cart Item Price:"+ci.getPrice());
					
				}
				
				//delete
				ci=ciDao.getCartItem("11");
				if(ci==null)
				{
					System.out.println("Item not Found");
				}
				else if(ciDao.delete(ci)==true)
				{
					System.out.println("Item Deleted");
				}
				else {
					System.out.println("Not deleted");
				}
				//retrieve list
				
				List<CartItem>items=ciDao.getCartItemList();
				for(CartItem i:items)
				{
					System.out.println("Cart Item Id:"+i.getCartItemsId()+"\n Cart Item Price:"+i.getPrice());
				}
		//end of main
	}

}
