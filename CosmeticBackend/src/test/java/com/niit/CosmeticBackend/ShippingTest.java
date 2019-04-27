package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.ShippingDao;
import com.niit.CosmeticBackend.Dao.UserDao;
import com.niit.CosmeticBackend.Model.Shipping;
import com.niit.CosmeticBackend.Model.User;

public class ShippingTest {
	
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
		c.scan("com.niit.*");
		c.refresh();
		
		Shipping s = (Shipping)c.getBean("shipping");
		ShippingDao sDao = (ShippingDao)c.getBean("shippingDao");
	
		
		User u =(User)c.getBean("user");
		UserDao uDao=(UserDao)c.getBean("userDao");
		
		//save or update
		//adding data
		
		u=uDao.getUser("10");
		
		s.setShipId("10");
		s.setShipName("hfksjdc");
		s.setShipCity("yhfhsdj");
		s.setShipState("fhjd");
		s.setShipPhoneNo("9845123670");
		s.setUser(u);
		System.out.println("Shippind ID:"+s.getShipId()+"\nShipping Name:"+s.getShipName()+"\nShipping City:"+s.getShipCity()+"\n shipping State:"+s.getShipState()+"\n Shipping Phone no:"+s.getShipPhoneNo());
		if(sDao.saveorupdate(s)==true)
		{
			System.out.println("Shipping saved");
		}
		else{
			System.out.println("Shipping not saved");
		}
		//adding data
		
		u=uDao.getUser("11");
		
		s.setShipId("11");
		s.setShipName("qfksjdc");
		s.setShipCity("qhfhsdj");
		s.setShipState("dhjd");
		s.setShipPhoneNo("8845123670");
		s.setUser(u);
		System.out.println("Shippind ID:"+s.getShipId()+"\nShipping Name:"+s.getShipName()+"\nShipping City:"+s.getShipCity()+"\n shipping State:"+s.getShipState()+"\n Shipping Phone no:"+s.getShipPhoneNo());
		if(sDao.saveorupdate(s)==true)
		{
			System.out.println("Shipping saved");
		}
		else{
			System.out.println("Shipping not saved");
		}
		//adding data
		u=uDao.getUser("12");
		s.setShipId("12");
		s.setShipName("gfksjdc");
		s.setShipCity("tkhfhsdj");
		s.setShipState("dffhjd");
		s.setShipPhoneNo("7845123670");
		s.setUser(u);
		System.out.println("Shippind ID:"+s.getShipId()+"\nShipping Name:"+s.getShipName()+"\nShipping City:"+s.getShipCity()+"\n shipping State:"+s.getShipState()+"\n Shipping Phone no:"+s.getShipPhoneNo());
		if(sDao.saveorupdate(s)==true)
		{
			System.out.println("Shipping saved");
		}
		else{
			System.out.println("Shipping not saved");
		}

			//retrieve
		s=sDao.getShipping("10");
		if(s==null)
		{
			System.out.println("Shipping not found");
		}
		else {
			System.out.println("Shippind ID:"+s.getShipId()+"\nShipping Name:"+s.getShipName()+"\nShipping City:"+s.getShipCity()+"\n shipping State:"+s.getShipState()+"\n Shipping Phone no:"+s.getShipPhoneNo());
			
		}
		//delete
		s=sDao.getShipping("11");
		if(s==null)
		{
			System.out.println("Shipping not found");
			
		}
		else if(sDao.delete(s)==true)
		{
			System.out.println("Shipping deleted");
		}
		else {
			System.out.println("Not deleted");
		}
		//retrieve list
		List<Shipping> items = sDao.getshipList();
		for(Shipping s1:items)
		{
			System.out.println("Shippind ID:"+s1.getShipId()+"\nShipping Name:"+s1.getShipName()+"\nShipping City:"+s1.getShipCity()+"\n shipping State:"+s1.getShipState()+"\n Shipping Phone no:"+s1.getShipPhoneNo());
			
		}
		
		//end of main
	}

}
