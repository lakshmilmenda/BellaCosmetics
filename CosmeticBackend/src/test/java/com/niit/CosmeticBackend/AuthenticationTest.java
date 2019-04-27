package com.niit.CosmeticBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticBackend.Dao.AuthenticationDao;
import com.niit.CosmeticBackend.Model.Authentication;

public class AuthenticationTest {

	public static void main(String arg[]) {
		
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
		c.scan("com.niit.*");
		c.refresh();
		
		Authentication auth = (Authentication)c.getBean("authentication");
		AuthenticationDao authDao=(AuthenticationDao)c.getBean("authenticationDao");
		
		//save or update
		//adding data
		auth.setRoleId("10");
		auth.setRoleName("dhgbs");
		auth.setUserName("hgvjh");
		
		System.out.println(auth.getRoleId()+"\n"+auth.getRoleName()+"\n"+auth.getUserName());
		
		if(authDao.saveorupdate(auth)==true)
		{
			System.out.println("Authentication Saved");
		}
		else
		{
			System.out.println("Authentication not saved");
		}
		
		//adding data
		auth.setRoleId("11");
		auth.setRoleName("udjd");
		auth.setUserName("usisdcn");
		
		System.out.println(auth.getRoleId()+"\n"+auth.getRoleName()+"\n"+auth.getUserName());
		
		if(authDao.saveorupdate(auth)==true)
		{
			System.out.println("Authentication Saved");
		}
		else
		{
			System.out.println("Authentication not saved");
		}
		
		//adding data
		auth.setRoleId("12");
		auth.setRoleName("kdehjk");
		auth.setUserName("ichnc");
		
		System.out.println(auth.getRoleId()+"\n"+auth.getRoleName()+"\n"+auth.getUserName());
		
		if(authDao.saveorupdate(auth)==true)
		{
			System.out.println("Authentication Saved");
		}
		else
		{
			System.out.println("Authentication not saved");
		}
		
		
		//retrieve
		
		auth=authDao.getAuthentication("10");
		if(auth==null) {
			System.out.println("Authentication not found");
		}
		else {
			System.out.println("Authenticatio Role name :"+auth.getRoleId()+"\n Authentication Role Name:"+auth.getRoleName()+"\n Authication User Name:"+auth.getUserName());
		}
		
		
		//delete
		auth =authDao.getAuthentication("11");
		if(auth==null)
		{
			System.out.println("Authentication not found");
		}
		else if(authDao.delete(auth)==true)
		{
			System.out.println("Authentication Deleted");
		}
		else {
			System.out.println("Not Deleted");
		}
		
		
		//retrieve list
		List<Authentication> authentications =  authDao.authenticationList();
		for(Authentication a: authentications)
		{
			System.out.println("Authenticatio Role name :"+a.getRoleId()+"\n Authentication Role Name:"+a.getRoleName()+"\n Authication User Name:"+a.getUserName());
			
		}
		//end of main
	}
	
	
	
}
