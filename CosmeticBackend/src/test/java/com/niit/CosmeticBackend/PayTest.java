package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.PayDao;
import com.niit.CosmeticBackend.Model.Pay;

public class PayTest {
	
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
		c.scan("com.niit.*");
		c.refresh();
		
		Pay p =(Pay)c.getBean("pay");
		PayDao pDao = (PayDao)c.getBean("payDao");
		//save or update
		//adding data
		p.setPayId("10");
		p.setPayMethod("hgfbcms");
		p.setPayStatus("jgfbv");
		
		System.out.println("Pay Id : "+p.getPayId()+"\nPay Method :"+p.getPayMethod()+"\nPay Status:"+p.getPayStatus());
		if(pDao.saveorupdate(p)==true)
		{
			System.out.println("Saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		//adding data
				p.setPayId("11");
				p.setPayMethod("dgfbcms");
				p.setPayStatus("ajgfbv");
				
				System.out.println("Pay Id : "+p.getPayId()+"\nPay Method :"+p.getPayMethod()+"\nPay Status:"+p.getPayStatus());
				if(pDao.saveorupdate(p)==true)
				{
					System.out.println("Saved");
				}
				else
				{
					System.out.println("Not saved");
				}
				
				//adding data
				p.setPayId("12");
				p.setPayMethod("ahgfbcms");
				p.setPayStatus("cjbvgfbv");
				
				System.out.println("Pay Id : "+p.getPayId()+"\nPay Method :"+p.getPayMethod()+"\nPay Status:"+p.getPayStatus());
				if(pDao.saveorupdate(p)==true)
				{
					System.out.println("Saved");
				}
				else
				{
					System.out.println("Not saved");
				}
		
				//retrieve
				p=pDao.getPay("10");
				if(p==null)
				{
					System.out.println("Not found");
				}
				else {
					System.out.println("Pay Id : "+p.getPayId()+"\nPay Method :"+p.getPayMethod()+"\nPay Status:"+p.getPayStatus());
				}
				
				//delete
				p=pDao.getPay("11");
				if(p==null)
				{
					System.out.println("Not found");
				}
				else if(pDao.delete(p)==true)
				{
					System.out.println("Deleted ");
				}
				else {
					System.out.println("Not deleted");
				}
				
				//retrieve List
				
				List<Pay> pays = pDao.getPayList();
				for(Pay p1:pays)
				{
					System.out.println("Pay Id : "+p1.getPayId()+"\nPay Method :"+p1.getPayMethod()+"\nPay Status:"+p1.getPayStatus());
				}
		//end of main
	}
}
