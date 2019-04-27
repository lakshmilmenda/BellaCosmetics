package com.niit.CosmeticFrontend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticBackend.Dao.BrandDao;
import com.niit.CosmeticBackend.Dao.CategoryDao;
import com.niit.CosmeticBackend.Dao.UserDao;
import com.niit.CosmeticBackend.Model.Brand;
import com.niit.CosmeticBackend.Model.Category;
import com.niit.CosmeticBackend.Model.User;

@Controller

public class LoginController {
	
	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Brand brand;
	
	@Autowired
	BrandDao brandDao;
	
	
	@RequestMapping("/account")
	
	public ModelAndView login(@RequestParam(value="error",required=false)String error,
			@RequestParam(value="logout",required=false)String logout,Model model)
	{
		  ModelAndView mv = new ModelAndView();
   	   List<Category> Categories = categoryDao.getCatList();
  		mv.addObject("Catgeories", Categories);
  		List<Brand> Brands = brandDao.getBrandList();
  		mv.addObject("Brands", Brands);
		System.out.println("Entering into login page");
		if(error != null)
			System.out.println("error");
			model.addAttribute("error","invalid username or password");
		if(logout != null)
			System.out.println("logout");
			model.addAttribute("logout","logout successfully");	
		mv.setViewName("account");
		return mv;
	}
	
	@RequestMapping(value="/j_spring_security_check")
	
	  public String Login(@RequestParam("j_name")String umail,@RequestParam("j_password")String pwd,Model model,HttpSession session)
	{
	User u=userDao.isValid(umail,pwd);
	if(u==null)
	{
		System.out.println("Login null");
		model.addAttribute("msg","Invalid username pwd");
		return "redirect:/";
	}
	else
	{
		System.out.println("Login success");
		session.setAttribute("user",u.getuId());
		session.setAttribute("name",u.getuName());

	return "redirect:/";
}
}
@RequestMapping(value="/j_spring_security_logout")
public String logout(HttpServletRequest request,HttpSession session,Model model)
{
	System.out.println("Logged out successfully");
	session.invalidate();
	session=request.getSession(true);
	model.addAttribute("logout","logout Successfully");
	return "redirect:/";
}
}

