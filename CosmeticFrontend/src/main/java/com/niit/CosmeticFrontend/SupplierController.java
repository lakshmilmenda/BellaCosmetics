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
import com.niit.CosmeticBackend.Dao.SupplierDao;
import com.niit.CosmeticBackend.Model.Brand;
import com.niit.CosmeticBackend.Model.Category;
import com.niit.CosmeticBackend.Model.Supplier;

@Controller
public class SupplierController {

		@Autowired
			Supplier supplier; 
		
		@Autowired
		SupplierDao supplierDao;
		
		@Autowired
		Category category; 
		
		@Autowired
		CategoryDao categoryDao;

		@Autowired
		Brand brand;
		
		@Autowired
		BrandDao brandDao;

		@RequestMapping("/supplier")

		public ModelAndView Supplier() {
			ModelAndView mv = new ModelAndView();
			List<Category>Categories = categoryDao.getCatList();
			mv.addObject("Catgeories", Categories);
			List<Brand> Brands = brandDao.getBrandList();
			mv.addObject("Brands", Brands);
			mv.addObject("supplier", new Supplier());
			List<Supplier>Suppliers= supplierDao.getSupList();
			mv.addObject("Suppliers", Suppliers);
			mv.setViewName("Supplier");
			return mv;

		}

		@RequestMapping("/addSup")
		public ModelAndView addPro(@ModelAttribute("supplier") Supplier sup) {
			ModelAndView mv = new ModelAndView();
			if (supplierDao.saveorupdate(sup) == true) {
				System.out.println("Supplier Saved");
				mv.addObject("msg", "Supplier  Saved");
			} else {
				System.out.println("Supplier Not Saved");
				mv.addObject("msg", "Supplier not Saved");

			}
			mv.setViewName("redirect:/supplier");

			return mv;
		}

		@RequestMapping("/editSupplier/{supId}")
		public ModelAndView editPro(@PathVariable("supId") String supId) {
			ModelAndView mv = new ModelAndView();
			supplier=supplierDao.getSupplier(supId);
			mv.addObject("supplier", supplier);
			List<Supplier>Suppliers=supplierDao.getSupList();
			mv.addObject("Suppliers", Suppliers);
			mv.setViewName("Supplier");
			return mv;

		}

		@RequestMapping("/deleteSupplier/{supId}")
		public ModelAndView deletePro(@PathVariable("supId") String supId) {
			ModelAndView mv = new ModelAndView();
			supplier = supplierDao.getSupplier(supId);
			if (supplierDao.delete(supplier) == true) {
				System.out.println("Supplier Deleted");
				mv.addObject("msg", "Supplier Deleted");
			} else {
				System.out.println("Not Deleted ");
				mv.addObject("msg", "Supplier not Deleted");

			}
			mv.setViewName("redirect:/supplier");

			return mv;

		}
	}

	
	
