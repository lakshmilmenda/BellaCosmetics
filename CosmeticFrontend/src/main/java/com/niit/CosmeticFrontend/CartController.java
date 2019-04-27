package com.niit.CosmeticFrontend;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticBackend.Dao.BrandDao;
import com.niit.CosmeticBackend.Dao.CartDao;
import com.niit.CosmeticBackend.Dao.CartItemDao;
import com.niit.CosmeticBackend.Dao.CategoryDao;
import com.niit.CosmeticBackend.Dao.PayDao;
import com.niit.CosmeticBackend.Dao.ProductDao;
import com.niit.CosmeticBackend.Dao.UserDao;
import com.niit.CosmeticBackend.Model.Brand;
import com.niit.CosmeticBackend.Model.Cart;
import com.niit.CosmeticBackend.Model.CartItem;
import com.niit.CosmeticBackend.Model.Category;
import com.niit.CosmeticBackend.Model.Pay;
import com.niit.CosmeticBackend.Model.Product;
import com.niit.CosmeticBackend.Model.User;

@Controller

public class CartController {

	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	Cart cart;
	
	@Autowired
	CartItem cartItem;
	
	@Autowired
	CartItemDao cartItemDao;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;

	@Autowired
	Brand brand;
	
	@Autowired
	BrandDao brandDao;
	
	@Autowired 
	Pay pay;
	
	@Autowired
	PayDao payDao;
	
	@RequestMapping("/addtocart/{proId}")
	public ModelAndView cart(@PathVariable("proId") String id,HttpSession session) 
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
	User user = userDao.getEmail(currusername);
	if (user == null)
	{
		return new ModelAndView("redirect:/account");
	} 
	else
	{
		cart = user.getCart();
		Product product = productDao.getProduct(id);
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setPrice(product.getProPrice());
		cartItem.setProduct(product);
		
		cartItemDao.saveorupdate(cartItem);
		cart.setGrandTotal(cart.getGrandTotal() + product.getProPrice());
		cart.setTotalItems(cart.getTotalItems() + 1);
	
		cartDao.saveorupdate(cart);
		session.setAttribute("items", cart.getTotalItems());
		session.setAttribute("gd", cart.getGrandTotal());
	
		return new ModelAndView("redirect:/checkout");
		}
	}
		
		else {
			return new ModelAndView("redirect:/account");
		}
	}
		
		
	
		
	
	           @RequestMapping(value="/checkout")
	           public ModelAndView viewcart(Model model,HttpSession session)
	           {
	        	   ModelAndView mv = new ModelAndView();
	        	   List<Category> Categories = categoryDao.getCatList();
	       		mv.addObject("Catgeories", Categories);
	       		List<Brand> Brands = brandDao.getBrandList();
	       		mv.addObject("Brands", Brands);
	        	   Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	        	   if(!(authentication instanceof AnonymousAuthenticationToken))
                     {
                    	 String currusername=authentication.getName();
                    	 User user=userDao.getEmail(currusername);
                    	 Cart cart=user.getCart();
                    	 List<CartItem> cartItem=cartItemDao.getlist(user.getCart().getCartId());
                    	 if(cartItem==null||cartItem.isEmpty())
                    	 {
                    		 System.out.println(67567);
                    		 session.setAttribute("items",0);
                    		 model.addAttribute("gtotal",0.0);
                    		 model.addAttribute("msg", "no items is added to cart");
                    		mv.setViewName("cart");
                    		return mv;
                    	 }
                    	 System.out.println(54354);
                    	 model.addAttribute("cartItem", cartItem);
            			 model.addAttribute("grandtotal", cart.getGrandTotal());
            			 session.setAttribute("items", cart.getTotalItems());
            			 session.setAttribute("cartid", cart.getCartId());
            			 List<Category> categories=categoryDao.getCatList();
            			 model.addAttribute("lcat", categories);
            				mv.setViewName("cart");
                    		return mv;
                     }
                    	 else
                    	 {
                    	 return  new ModelAndView("redirect:/account");
                     }
			
	           }
                     @RequestMapping(value="/Remove/{cartItemsId}")
                     public ModelAndView RemoveFromCart(@PathVariable("cartItemsId")String id)
                     {
                    	 ModelAndView mv=new ModelAndView("redirect:/checkout");
                    	 cartItem= cartItemDao.getCartItem(id);
                    	 cart=cartItem.getCart();
                    	 cart.setGrandTotal(cart.getGrandTotal()-cartItem.getPrice());
                    	 cart.setTotalItems(cart.getTotalItems()-1);
                    	 cartDao.saveorupdate(cart);
                    	 cartItemDao.delete(cartItem);
                    	 return mv;
                     }
                     
                     
                     @RequestMapping(value="/RemoveAll")
                     public String RemoveAllFromCart(Model model, HttpSession session)
                     {
                    	 Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
                    	 if(!(authentication instanceof AnonymousAuthenticationToken))
                    	 {
                    		 String currusername=authentication.getName();
                        	 User u=userDao.getEmail(currusername);
                        	 Cart c=cartDao.getCart(u.getCart().getCartId());
                        	 List<CartItem> cartItem=cartItemDao.getlist(u.getCart().getCartId()); 
                        	 for(CartItem c1:cartItem)
                        	 {
                        		 cartItemDao.delete(c1);
                        	 }
                        	 c.setGrandTotal(0.0);
                        	 c.setTotalItems(0);
                        	 cartDao.saveorupdate(c);
                        	 session.setAttribute("items",c.getTotalItems());
                        	 return "redirect:/checkout";                    	 
                     }
                     
                     else
                     {
                    	 return ("redirect:/");
                     }
                     }
	}
