package com.niit.CosmeticFrontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticBackend.Dao.BrandDao;
import com.niit.CosmeticBackend.Dao.CategoryDao;
import com.niit.CosmeticBackend.Model.Brand;
import com.niit.CosmeticBackend.Model.Category;
import com.niit.CosmeticFrontend.fileInput.fileInput;

@Controller

public class CategoryController {

	@Autowired
	Category category; 
	
	@Autowired
	CategoryDao categoryDao;

	@Autowired
	Brand brand;
	
	@Autowired
	BrandDao brandDao;
	
	String path="C:\\Users\\lakshmi\\eclipse-workspace2\\CosmeticFrontend\\src\\main\\webapp\\resources\\images\\";
	@RequestMapping("/category")

	public ModelAndView Categorypg() {
		ModelAndView mv = new ModelAndView();
		List<Category>Categories = categoryDao.getCatList();
		mv.addObject("Catgeories", Categories);
		List<Brand> Brands = brandDao.getBrandList();
		mv.addObject("Brands", Brands);
		mv.addObject("category", new Category());
		List<Category> Cat = categoryDao.getCatList();
		mv.addObject("Categories", Cat);
		mv.setViewName("Category");
		return mv;

	}

	@RequestMapping(value="/addCat", method=RequestMethod.POST)
	public ModelAndView addCat(@ModelAttribute("category") Category cat) {
		ModelAndView mv = new ModelAndView();
		fileInput.upload(path, cat.getCimg(), cat.getCatId()+".jpg");
		fileInput.upload(path, cat.getClogo(), cat.getCatName()+".jpg");
		if (categoryDao.saveorupdate(cat) == true) {
			System.out.println("Category Saved");
			mv.addObject("msg", "Category Saved");
		} else {
			System.out.println("Category Not Saved");
			mv.addObject("msg", "Category not Saved");

		}
		mv.setViewName("redirect:/category");

		return mv;
	}

	@RequestMapping("/editCategory/{catId}")
	public ModelAndView editCat(@PathVariable("catId") String catId) {
		ModelAndView mv = new ModelAndView();
		category=categoryDao.getCategory(catId);
		mv.addObject("category", category);
		List<Category> Categories = categoryDao.getCatList();
		mv.addObject("Catgeories", Categories);
		mv.setViewName("Category");
		return mv;

	}

	@RequestMapping("/deleteCategory/{catId}")
	public ModelAndView deleteCat(@PathVariable("catId") String catId) {
		ModelAndView mv = new ModelAndView();
		category = categoryDao.getCategory(catId);
		if (categoryDao.delete(category) == true) {
			System.out.println("Category Deleted");
			mv.addObject("msg", "Category Deleted");
		} else {
			System.out.println("Not Deleted ");
			mv.addObject("msg", "Category not Deleted");

		}
		mv.setViewName("redirect:/category");

		return mv;

	}

}
