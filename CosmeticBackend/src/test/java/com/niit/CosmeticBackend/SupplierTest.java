package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.SupplierDao;
import com.niit.CosmeticBackend.Model.Supplier;

public class SupplierTest {

public static void main(String arg[]) {
		
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
		c.scan("com.niit.*");
		c.refresh();
		
		Supplier sup = (Supplier)c.getBean("supplier");
		SupplierDao supDao= (SupplierDao)c.getBean("supplierDao");
	
		
		
		
		sup.setSupId("10");
		sup.setSupName("jhaban");
		sup.setSupAdd("Bangalore");
		sup.setSupPhoneNo("98962359523");
		
		
		System.out.println(sup.getSupId()+"\n"+sup.getSupName()+"\n"+sup.getSupAdd()+"\n"+sup.getSupPhoneNo());
		//save or update
		if(supDao.saveorupdate(sup)==true) 
		{
			System.out.println("Supplier saved Successfully");
		}
		else {
			System.out.println("Supplier Not Saved");
		}
		//adding data
		sup.setSupId("11");
		sup.setSupName("hcdmajs");
		sup.setSupAdd("Mysore");
		sup.setSupPhoneNo("9896235425");
		
		
		System.out.println(sup.getSupId()+"\n"+sup.getSupName()+"\n"+sup.getSupAdd()+"\n"+sup.getSupPhoneNo());
		//save or update
		if(supDao.saveorupdate(sup)==true) 
		{
			System.out.println("Supplier saved Successfully");
		}
		else {
			System.out.println("Supplier Not Saved");
		}
		//adding data
				sup.setSupId("12");
				sup.setSupName("hgcdjashb");
				sup.setSupAdd("Bangalore");
				sup.setSupPhoneNo("9896239898");
				
				
				System.out.println(sup.getSupId()+"\n"+sup.getSupName()+"\n"+sup.getSupAdd()+"\n"+sup.getSupPhoneNo());
				//save or update
				if(supDao.saveorupdate(sup)==true) 
				{
					System.out.println("Supplier saved Successfully");
				}
				else {
					System.out.println("Supplier Not Saved");
				}
				
				
				//Retrieve
				sup=supDao.getSupplier("11");
				if(sup==null)
				{
					System.out.println("Supplier Not Found");
				}
				else
				{
					System.out.println("Supplier  Id :" + sup.getSupId());
					System.out.println("Supplier Name:"+sup.getSupName() );
					System.out.println("Supplier Address:"+sup.getSupAdd());
					System.out.println("Supplier Phone Number:"+sup.getSupPhoneNo());
				}
				
				//Delete
				sup=supDao.getSupplier("12");
				if(sup==null)
				{
				System.out.println("Supplier Not Found");	
				}
				else if(supDao.delete(sup)==true)
				{
					System.out.println("Supplier deleted");
				}
				else
				{
					System.out.println("Not Deleted");
					
				}
				
				//Retrieve List
				List<Supplier>suplist = supDao.getSupList();
				for(Supplier s1 : suplist)
				{
					System.out.println("Supplier  Id :" + s1.getSupId());
					System.out.println("Supplier Name:"+s1.getSupName() );
					System.out.println("Supplier Address:"+s1.getSupAdd());
					System.out.println("Supplier Phone Number:"+s1.getSupPhoneNo());
				}
				
		//end of main
		
	}
	
}
