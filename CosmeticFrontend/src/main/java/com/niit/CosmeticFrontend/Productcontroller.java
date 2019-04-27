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
import com.niit.CosmeticBackend.Dao.ProductDao;
import com.niit.CosmeticBackend.Dao.SupplierDao;
import com.niit.CosmeticBackend.Model.Brand;
import com.niit.CosmeticBackend.Model.Category;
import com.niit.CosmeticBackend.Model.Product;
import com.niit.CosmeticBackend.Model.Supplier;
import com.niit.CosmeticFrontend.fileInput.fileInput;
@Controller
public class Productcontroller {
	@Autowired
	Product product; 
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Category  category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	
	@Autowired
	Brand brand;
	
	@Autowired
	BrandDao brandDao;
	
	
	String path="C:\\Users\\lakshmi\\eclipse-workspace2\\CosmeticFrontend\\src\\main\\webapp\\resources\\images\\";
	@RequestMapping("/product")

	public ModelAndView Productpg() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", new Product());
		List<Product>Products = productDao.getProList();
		mv.addObject("Products", Products);
	
		List<Category>Categories = categoryDao.getCatList();
		mv.addObject("Categories", Categories);
		List<Supplier>Suppliers = supplierDao.getSupList();
		mv.addObject("Suppliers", Suppliers);
		List<Brand>Brands = brandDao.getBrandList();
		mv.addObject("Brands",Brands);
		mv.setViewName("Product");
		return mv;
	}

	@RequestMapping(value="/addPro", method = RequestMethod.POST)
	public ModelAndView addPro(@ModelAttribute("product") Product pro) {
		ModelAndView mv = new ModelAndView();
		fileInput.upload(path, pro.getPing(), pro.getProId()+".jpg");
		if (productDao.saveorupdate(pro) == true) {
			
			System.out.println("Product Saved");
			mv.addObject("msg", "Product Saved");
		
		} else {
			System.out.println("Product Not Saved");
			mv.addObject("msg", "Product not Saved");

		}
		mv.setViewName("redirect:/product");

		return mv;
	}

	@RequestMapping("/editProduct/{proId}")
	public ModelAndView editPro(@PathVariable("proId") String proId) {
		ModelAndView mv = new ModelAndView();
		List<Category>Categories = categoryDao.getCatList();
		mv.addObject("Categories", Categories);
		List<Supplier>Suppliers = supplierDao.getSupList();
		mv.addObject("Suppliers", Suppliers);
		List<Brand>Brands = brandDao.getBrandList();
		mv.addObject("Brands",Brands);
		product=productDao.getProduct(proId);
		mv.addObject("product", product);
		List<Product> Products =productDao.getProList();
		mv.addObject("Products", Products);
		mv.setViewName("Product");
		return mv;

	}

	@RequestMapping("/deleteProduct/{proId}")
	public ModelAndView deletePro(@PathVariable("proId") String proId) {
		ModelAndView mv = new ModelAndView();
		product = productDao.getProduct(proId);
		if (productDao.delete(product) == true) {
			System.out.println("product Deleted");
			mv.addObject("msg", "product Deleted");
		} else {
			System.out.println("Not Deleted ");
			mv.addObject("msg", "product not Deleted");

		}
		mv.setViewName("redirect:/product");

		return mv;

	}
}
