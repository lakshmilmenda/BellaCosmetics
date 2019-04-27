package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.OrderItemDao;
import com.niit.CosmeticBackend.Dao.OrdersDao;
import com.niit.CosmeticBackend.Model.OrderItem;
import com.niit.CosmeticBackend.Model.Orders;

public class OrderItemTest {

	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
		c.scan("com.niit.*");
		c.refresh();
		
		OrderItem o = (OrderItem)c.getBean("orderItem");
		OrderItemDao oDao = (OrderItemDao)c.getBean("orderItemDao");
		
		Orders or = (Orders)c.getBean("orders");
		OrdersDao orDao = (OrdersDao)c.getBean("ordersDao");
		
		
		//save or update
		//adding data
		
		or=orDao.getOrders("10");
		o.setOrderItemId("10");
		o.setProductId("10");
		o.setOrders(or);
		System.out.println("Order id :"+o.getOrderItemId()+"\n Product Id:"+o.getProductId());
		if(oDao.saveorupdate(o)==true)
		{
			System.out.println("Order Item not Saved");
		}
		else
		{
			System.out.println("Order Item Saved");
		}
		//adding data
		or=orDao.getOrders("11");
		o.setOrderItemId("11");
		o.setProductId("11");
		o.setOrders(or);
		System.out.println("Order id :"+o.getOrderItemId()+"\n Product Id:"+o.getProductId());
		if(oDao.saveorupdate(o)==true)
		{
			System.out.println("Order Item not Saved");
		}
		else
		{
			System.out.println("Order Item Saved");
		}
		//adding data
		or=orDao.getOrders("12");
		o.setOrderItemId("12");
		o.setProductId("12");
		o.setOrders(or);
		System.out.println("Order id :"+o.getOrderItemId()+"\n Product Id:"+o.getProductId());
		if(oDao.saveorupdate(o)==true)
		{
			System.out.println("Order Item Saved");
		}
		else
		{
			System.out.println("Order Item not Saved");
		}
		
		//retrieve
		 o=oDao.getOrderItem("10");
		 if(o==null)
		 {
			 System.out.println("Not Found");
		 }
		 else
		 {
			 System.out.println("Order id :"+o.getOrderItemId()+"\n Product Id:"+o.getProductId()); 
		 }
		
		 //delete
		 
		 o=oDao.getOrderItem("11");
				 if(o==null)
				 {
					 System.out.println("Not Found");
				 }
				 else if(oDao.delete(o)==true)
				 {
					 System.out.println("Deleted");
				 }
				 else {
					 System.out.println("Not Deleted");
				 }
		 //Retrieve List
		 List<OrderItem> items = oDao.orderList();
		 for(OrderItem o1: items)
		 {
			 System.out.println("Order id :"+o1.getOrderItemId()+"\n Product Id:"+o1.getProductId()); 
		 }
		//end of main
	}
	
}
