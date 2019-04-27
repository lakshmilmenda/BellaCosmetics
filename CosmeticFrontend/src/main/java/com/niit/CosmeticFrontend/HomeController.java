package com.niit.CosmeticFrontend;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticBackend.Dao.BrandDao;
import com.niit.CosmeticBackend.Dao.CategoryDao;
import com.niit.CosmeticBackend.Dao.ProductDao;
import com.niit.CosmeticBackend.Model.Brand;
import com.niit.CosmeticBackend.Model.Category;
import com.niit.CosmeticBackend.Model.Product;
import com.niit.CosmeticBackend.Model.User;

@Controller
public class HomeController {
	
	@Autowired
	HttpSession session;
	@Autowired
	User user;
	
	@Autowired
	Product product; 
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Category category; 
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Brand brand;
	
	@Autowired
	BrandDao brandDao;
	
	@RequestMapping("/")
	
	public ModelAndView Home() {
		ModelAndView mv = new ModelAndView();
		
		List<Category> Categories = categoryDao.getCatList();
		mv.addObject("Catgeories", Categories);
		List<Brand> Brands = brandDao.getBrandList();
		mv.addObject("Brands", Brands);
		List<Product>Products = productDao.getProList();
		mv.addObject("Products", Products);
		session.setAttribute("user", user);
		mv.setViewName("home");
		return mv;
		
	}
	@RequestMapping("/AllProducts")
	
	public ModelAndView AllProducts() {
		ModelAndView mv = new ModelAndView();
		
		List<Category> Categories = categoryDao.getCatList();
		mv.addObject("Catgeories", Categories);
		List<Brand> Brands = brandDao.getBrandList();
		mv.addObject("Brands", Brands);
		session.setAttribute("user", user);
		List<Product>Products = productDao.getProList();
		mv.addObject("Products", Products);
		mv.setViewName("AllProducts");
		return mv;
		
	}

@RequestMapping("/lakme")
	
public ModelAndView lakme() {
	ModelAndView mv = new ModelAndView();
	
	List<Category> Categories = categoryDao.getCatList();
	mv.addObject("Catgeories", Categories);
	List<Brand> Brands = brandDao.getBrandList();
	mv.addObject("Brands", Brands);
	session.setAttribute("user", user);
	mv.setViewName("lakme");
	return mv;
	
}


@RequestMapping("/nails")
public ModelAndView nails(@PathVariable("catId") String catId) {
	ModelAndView mv = new ModelAndView();
	List<Category> Categories = categoryDao.getCatList();
	mv.addObject("Catgeories", Categories);
	List<Product>Products = productDao.getCatProList(catId);
	mv.addObject("Products", Products);
	mv.setViewName("nails");
	return mv;
}


@RequestMapping("/displayProduct/{catId}")
public ModelAndView displayproduct(@PathVariable("catId") String catId) {
	ModelAndView mv = new ModelAndView();
	List<Category> Categories = categoryDao.getCatList();
	mv.addObject("Catgeories", Categories);
	List<Brand> Brands = brandDao.getBrandList();
	mv.addObject("Brands", Brands);
	Category cat=new Category();
	cat=categoryDao.getCategory(catId);
	mv.addObject("category", cat);
	List<Product>Products = productDao.getCatProList(catId);
	mv.addObject("Products", Products);
	mv.setViewName("nails");
	return mv;
}


@RequestMapping("/display/{brandId}")
public ModelAndView display(@PathVariable("brandId") String brandId) {
	ModelAndView mv = new ModelAndView();
	List<Category> Categories = categoryDao.getCatList();
	mv.addObject("Catgeories", Categories);
	List<Brand> Brands = brandDao.getBrandList();
	mv.addObject("Brands", Brands);
	Brand brand=new Brand();
	brand=brandDao.getBrand(brandId);
	mv.addObject("brand", brand);
	List<Product>Products = productDao.getBrandProList(brandId);
	mv.addObject("Products", Products);
	mv.setViewName("lakme");
	return mv;
}
}
