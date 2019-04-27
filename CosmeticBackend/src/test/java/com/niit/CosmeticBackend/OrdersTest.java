package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.BillingDao;
import com.niit.CosmeticBackend.Dao.OrdersDao;
import com.niit.CosmeticBackend.Dao.PayDao;
import com.niit.CosmeticBackend.Dao.ShippingDao;
import com.niit.CosmeticBackend.Dao.UserDao;
import com.niit.CosmeticBackend.Model.Billing;
import com.niit.CosmeticBackend.Model.Orders;
import com.niit.CosmeticBackend.Model.Pay;
import com.niit.CosmeticBackend.Model.Shipping;
import com.niit.CosmeticBackend.Model.User;

public class OrdersTest {

	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
		c.scan("com.niit.*");
		c.refresh();				
		
		Orders o = (Orders)c.getBean("orders");
		OrdersDao oDao=(OrdersDao)c.getBean("ordersDao");
		
		User u =(User)c.getBean("user");
		UserDao uDao=(UserDao)c.getBean("userDao");
		
		Pay p = (Pay)c.getBean("pay");
		PayDao pDao = (PayDao)c.getBean("payDao");
		
		Shipping s =(Shipping)c.getBean("shipping");
		ShippingDao sDao = (ShippingDao)c.getBean("shippingDao");
		
		Billing bill=(Billing)c.getBean("billing");
		BillingDao billDao=(BillingDao)c.getBean("billingDao");
		
		
		
		
		//save or update
		//adding data
		
		u=uDao.getUser("10");
		p=pDao.getPay("10");
		bill=billDao.getBill("10");
		s=sDao.getShipping("10");
		
		o.setOrderId("10");
		o.setGrandTotal(100);
		
		o.setUser(u);
		o.setPay(p);
		o.setShipping(s);
		o.setBilling(bill);
		
		System.out.println("Order id:"+o.getOrderId()+"\n Order Grand Total:"+o.getGrandTotal());
		
		if(oDao.saveorupdate(o)==true)
		{
			System.out.println("Order saved");
		}
		else
		{
			System.out.println("Order Not Saved");
		}
		//adding data
		
		u=uDao.getUser("11");
		p=pDao.getPay("11");
		bill=billDao.getBill("11");
		s=sDao.getShipping("11");
		
		o.setOrderId("11");
		o.setGrandTotal(200);
		

		o.setUser(u);
		o.setPay(p);
		o.setShipping(s);
		o.setBilling(bill);
		
		System.out.println("Order id:"+o.getOrderId()+"\n Order Grand Total:"+o.getGrandTotal());
		
		if(oDao.saveorupdate(o)==true)
		{
			System.out.println("Order saved");
		}
		else
		{
			System.out.println("Order Not Saved");
		}
		//adding data
		
		u=uDao.getUser("12");
		p=pDao.getPay("12");
		bill=billDao.getBill("12");
		s=sDao.getShipping("12");
		
		o.setOrderId("12");
		o.setGrandTotal(300);
		

		o.setUser(u);
		o.setPay(p);
		o.setShipping(s);
		o.setBilling(bill);
		
		System.out.println("Order id:"+o.getOrderId()+"\n Order Grand Total:"+o.getGrandTotal());
		
		if(oDao.saveorupdate(o)==true)
		{
			System.out.println("Order saved");
		}
		else
		{
			System.out.println("Order Not Saved");
		}
		
		//retrieve
		o=oDao.getOrders("10");
		if(o==null)
		{
			System.out.println("Not found");
			
		}
		else {
			System.out.println("Order id:"+o.getOrderId()+"\n Order Grand Total:"+o.getGrandTotal());
		}
		
		//delete
		o=oDao.getOrders("11");
		if(o==null)
		{
			System.out.println("Not Found");
		}
		else if(oDao.delete(o)==true)
		{
			System.out.println("Order Deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
		//retrieve List
		List<Orders> or = oDao.getOrdersList();
		for(Orders o1 : or)
		{
			System.out.println("Order id:"+o1.getOrderId()+"\n Order Grand Total:"+o1.getGrandTotal());
		}
		//end of main
	}
	
	
}
