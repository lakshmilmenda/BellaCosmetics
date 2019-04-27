package com.niit.CosmeticFrontend;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticBackend.Dao.BrandDao;
import com.niit.CosmeticBackend.Dao.CategoryDao;
import com.niit.CosmeticBackend.Dao.UserDao;
import com.niit.CosmeticBackend.Model.Brand;
import com.niit.CosmeticBackend.Model.Category;
import com.niit.CosmeticBackend.Model.User;

@Controller

public class UserController {

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
			

			@RequestMapping("/user")

			public ModelAndView Userpg() {
				ModelAndView mv = new ModelAndView();
				mv.addObject("user", new User());
				List<Category>Categories = categoryDao.getCatList();
				mv.addObject("Catgeories", Categories);
				List<Brand> Brands = brandDao.getBrandList();
				mv.addObject("Brands", Brands);
				List<User> Users = userDao.getUList();
				mv.addObject("Users",Users);
				mv.setViewName("user");
				return mv;

			}

			@RequestMapping("/addUser")
			public ModelAndView addUser(@ModelAttribute("user") User use) {
				ModelAndView mv = new ModelAndView();
				if (userDao.saveorupdate(use) == true) {
					System.out.println("User Saved");
					mv.addObject("msg", "User Saved");
				} else {
					System.out.println("User Not Saved");
					mv.addObject("msg", "User not Saved");

				}
				mv.setViewName("redirect:/user");

				return mv;
			}

		


		
		
	}

	
