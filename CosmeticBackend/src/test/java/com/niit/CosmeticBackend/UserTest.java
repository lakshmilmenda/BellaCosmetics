package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.BillingDao;
import com.niit.CosmeticBackend.Dao.CartDao;
import com.niit.CosmeticBackend.Dao.UserDao;
import com.niit.CosmeticBackend.Model.Billing;
import com.niit.CosmeticBackend.Model.Cart;
import com.niit.CosmeticBackend.Model.User;

public class UserTest {

	public static void main (String arg[])
	{
		
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
		c.scan("com.niit.*");
		c.refresh();
		
		User u = (User)c.getBean("user");
		UserDao uDao= (UserDao)c.getBean("userDao");
		
		Cart car=(Cart)c.getBean("cart");
		CartDao carDao = (CartDao)c.getBean("cartDao");
		
		Billing bill = (Billing)c.getBean("billing");
		BillingDao billDao = (BillingDao)c.getBean("billingDao");
		
		//save or update
		
		car=carDao.getCart("10");
		bill=billDao.getBill("10");
		u.setuId("10");
		u.setuName("Lakshmi");
		u.setuEmail("laks@gmail.com");
		u.setuAdd("Bangalore");
		u.setuPassword("lakshmi");
		u.setuPhoneNo("9874563210");
		
		u.setCart(car);
		u.setBilling(bill);
		
		System.out.println(u.getuId()+"\n"+u.getuName()+"\n"+u.getuEmail()+"\n"+u.getuAdd()+"\n"+u.getuPassword()+"\n"+u.getuPhoneNo());
		
		//save or update
		if(uDao.saveorupdate(u)==true) 
		{
			System.out.println("User saved Successfully");
		}
		else {
			System.out.println("User Not Saved");
		}
		
		//adding data
		
		car=carDao.getCart("11");
		bill=billDao.getBill("11");
		u.setuId("11");
		u.setuName("vjfbjsn");
		u.setuEmail("hgdbcnms@gmail.com");
		u.setuAdd("Bangalore");
		u.setuPassword("ygkjf");
		u.setuPhoneNo("9874562222");
		
		u.setBilling(bill);
		u.setCart(car);
		
		System.out.println(u.getuId()+"\n"+u.getuName()+"\n"+u.getuEmail()+"\n"+u.getuAdd()+"\n"+u.getuPassword()+"\n"+u.getuPhoneNo());
		
		//save or update
		if(uDao.saveorupdate(u)==true) 
		{
			System.out.println("User saved Successfully");
		}
		else {
			System.out.println("User Not Saved");
		}
		
		//adding data
		
		car=carDao.getCart("12");
		bill=billDao.getBill("12");
		u.setuId("12");
		u.setuName("pdjkasbd");
		u.setuEmail("vdjgdhcb@gmail.com");
		u.setuAdd("Mysore");
		u.setuPassword("kcccsd");
		u.setuPhoneNo("9123456780");
		
		u.setBilling(bill);
		u.setCart(car);
		
		System.out.println(u.getuId()+"\n"+u.getuName()+"\n"+u.getuEmail()+"\n"+u.getuAdd()+"\n"+u.getuPassword()+"\n"+u.getuPhoneNo());
		
		//save or update
		if(uDao.saveorupdate(u)==true) 
		{
			System.out.println("User saved Successfully");
		}
		else {
			System.out.println("User Not Saved");
		}
		
		//Retrieve
		u=uDao.getUser("10");
		if(u==null)
		{
			System.out.println("User Not Found");
		}
		else
		{
			System.out.println("User Id:"+u.getuId());
			System.out.println("User  Name:"+u.getuName());
			System.out.println("User  Email Id:"+u.getuEmail());
			System.out.println("User Address:"+u.getuAdd());
			System.out.println("User  Password:"+u.getuPassword());
			System.out.println("User Phone Number:"+u.getuPhoneNo());
		}
		
		//Delete
		u=uDao.getUser("11");
		if(u==null)
		{
		System.out.println("User Not Found");	
		}
		else if(uDao.delete(u)==true)
		{
			System.out.println("User deleted");
		}
		else
		{
			System.out.println("Not Deleted");
			
		}
		
		//Retrieve List
		List<User>ulist = uDao.getUList();
		for(User  u1 : ulist)
		{
			System.out.println("User Id:"+u1.getuId());
			System.out.println("User  Name:"+u1.getuName());
			System.out.println("User  Email Id:"+u1.getuEmail());
			System.out.println("User Address:"+u1.getuAdd());
			System.out.println("User  Password:"+u1.getuPassword());
			System.out.println("User Phone Number:"+u1.getuPhoneNo());
		}
		
		//end of main
	}
	
	
}
