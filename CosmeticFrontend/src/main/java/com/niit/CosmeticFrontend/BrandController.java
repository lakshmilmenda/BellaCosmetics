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
public class BrandController {


		@Autowired
		Brand brand; 
		
		@Autowired
		BrandDao brandDao;

		@Autowired
		Category category; 
		
		@Autowired
		CategoryDao categoryDao;
		
		String path="C:\\Users\\lakshmi\\eclipse-workspace2\\CosmeticFrontend\\src\\main\\webapp\\resources\\images\\";
	
		@RequestMapping("/brand")
		public ModelAndView Brandpg() {
			ModelAndView mv = new ModelAndView();
			List<Category>Categories = categoryDao.getCatList();
			mv.addObject("Catgeories", Categories);
			mv.addObject("brand", new Brand());
			List<Brand>Brands = brandDao.getBrandList();
			mv.addObject("Brands", Brands);
			mv.setViewName("Brand");
			return mv;

		}

		@RequestMapping(value="/addBrand", method=RequestMethod.POST)
		public ModelAndView addBrand(@ModelAttribute("brand") Brand brand) {
			ModelAndView mv = new ModelAndView();
			fileInput.upload(path, brand.getBimg(), brand.getBrandId()+".jpg");
			fileInput.upload(path, brand.getLogo(), brand.getBrandName()+".jpg");
			if (brandDao.saveorupdate(brand) == true) {
				System.out.println("brand Saved");
				mv.addObject("msg", "brand Saved");
			} else {
				System.out.println("brand Not Saved");
				mv.addObject("msg", "brand not Saved");

			}
			mv.setViewName("redirect:/brand");

			return mv;
		}

		@RequestMapping("/editBrand/{brandId}")
		public ModelAndView editBrand(@PathVariable("brandId") String brandId) {
			ModelAndView mv = new ModelAndView();
			brand=brandDao.getBrand(brandId);
			mv.addObject("brand", brand);
			List<Brand> Brands = brandDao.getBrandList();
			mv.addObject("Brands", Brands);
			mv.setViewName("Brand");
			return mv;

		}

		@RequestMapping("/deleteBrand/{brandId}")
		public ModelAndView deleteBrand(@PathVariable("brandId") String brandId) {
			ModelAndView mv = new ModelAndView();
			brand = brandDao.getBrand(brandId);
			if (brandDao.delete(brand) == true) {
				System.out.println("Brand Deleted");
				mv.addObject("msg", "Brand Deleted");
			} else {
				System.out.println("Not Deleted ");
				mv.addObject("msg", "Brand not Deleted");

			}
			mv.setViewName("redirect:/brand");

			return mv;

		}

	}

	