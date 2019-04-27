package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.BillingDao;
import com.niit.CosmeticBackend.Dao.UserDao;
import com.niit.CosmeticBackend.Model.Billing;
import com.niit.CosmeticBackend.Model.User;

public class BillingTest {

	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
		c.scan("com.niit.*");
		c.refresh();
		
		
		Billing bill = (Billing)c.getBean("billing");
		BillingDao billDao=(BillingDao)c.getBean("billingDao");
		
		User u = (User)c.getBean("user");
		UserDao uDao = (UserDao)c.getBean("userDao");
		
		//save or update
		//adding data
		u=uDao.getUser("10");
		
		bill.setBillId("10");
		bill.setBillName("hfbdjkd");
		bill.setBillCity("juhkjnf");
		bill.setBillState("hcdskjc");
		bill.setBillPhoneNo("9845612378");
		bill.setUser(u);
		
		System.out.println("Bill id :"+bill.getBillId()+"\n Bill Name:"+bill.getBillName()+"\n Bill City:"+bill.getBillCity()+"\n BillState:"+bill.getBillState()+"\nBill PhoneNo"+bill.getBillPhoneNo());
		
	if(billDao.saveorupdate(bill)==true)
	{
		System.out.println("Bill saved succesfully");
		
	}
	else {
		System.out.println("Bill not saved");
	}
	//adding data
	
			u=uDao.getUser("11");
			bill.setBillId("11");
			bill.setBillName("gfyuhsd");
			bill.setBillCity("uhkjnf");
			bill.setBillState("hhyrd");
			bill.setBillPhoneNo("9845612784");
			
			bill.setUser(u);
			System.out.println("Bill id :"+bill.getBillId()+"\n Bill Name:"+bill.getBillName()+"\n Bill City:"+bill.getBillCity()+"\n BillState:"+bill.getBillState()+"\nBill PhoneNo"+bill.getBillPhoneNo());
			
		if(billDao.saveorupdate(bill)==true)
		{
			System.out.println("Bill saved succesfully");
			
		}
		else {
			System.out.println("Bill not saved");
		}
		//adding data
				u=uDao.getUser("12");
				bill.setBillId("12");
				bill.setBillName("udfbdjkd");
				bill.setBillCity("jhcjnf");
				bill.setBillState("hcjfjjc");
				bill.setBillPhoneNo("9845542378");
				bill.setUser(u);
				
				
				System.out.println("Bill id :"+bill.getBillId()+"\n Bill Name:"+bill.getBillName()+"\n Bill City:"+bill.getBillCity()+"\n BillState:"+bill.getBillState()+"\nBill PhoneNo"+bill.getBillPhoneNo());
				
			if(billDao.saveorupdate(bill)==true)
			{
				System.out.println("Bill saved succesfully");
				
			}
			else {
				System.out.println("Bill not saved");
			}
	
	//retrieve
			
			bill=billDao.getBill("10");
			if(bill==null)
			{
				System.out.println("Billing not found");
			}
			else
			{
				System.out.println("Bill id :"+bill.getBillId()+"\n Bill Name:"+bill.getBillName()+"\n Bill City:"+bill.getBillCity()+"\n BillState:"+bill.getBillState()+"\nBill PhoneNo"+bill.getBillPhoneNo());
				
			}
					
			//delete
			bill=billDao.getBill("11");
			if(bill==null)
			{
				System.out.println("Bill not found");
			}
			else if(billDao.delete(bill)==true)
			{
				System.out.println("Bill deleted");
			}
			else{
				System.out.println("Not Deleted");
			}
			
			//retrieve List
			List<Billing>billlist=billDao.getBillList();
			for(Billing b : billlist) {
				System.out.println("Bill id :"+b.getBillId()+"\n Bill Name:"+b.getBillName()+"\n Bill City:"+b.getBillCity()+"\n BillState:"+b.getBillState()+"\nBill PhoneNo"+b.getBillPhoneNo());
				
			}
			
	//end of main
	}
	
}
