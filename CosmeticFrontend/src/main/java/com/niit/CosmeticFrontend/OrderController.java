package com.niit.CosmeticFrontend;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticBackend.Dao.BillingDao;
import com.niit.CosmeticBackend.Dao.BrandDao;
import com.niit.CosmeticBackend.Dao.CardDao;
import com.niit.CosmeticBackend.Dao.CartDao;
import com.niit.CosmeticBackend.Dao.CartItemDao;
import com.niit.CosmeticBackend.Dao.CategoryDao;
import com.niit.CosmeticBackend.Dao.OrderItemDao;
import com.niit.CosmeticBackend.Dao.OrdersDao;
import com.niit.CosmeticBackend.Dao.PayDao;
import com.niit.CosmeticBackend.Dao.ProductDao;
import com.niit.CosmeticBackend.Dao.ShippingDao;
import com.niit.CosmeticBackend.Dao.UserDao;
import com.niit.CosmeticBackend.Model.Billing;
import com.niit.CosmeticBackend.Model.Brand;
import com.niit.CosmeticBackend.Model.Card;
import com.niit.CosmeticBackend.Model.Cart;
import com.niit.CosmeticBackend.Model.CartItem;
import com.niit.CosmeticBackend.Model.Category;
import com.niit.CosmeticBackend.Model.OrderItem;
import com.niit.CosmeticBackend.Model.Orders;
import com.niit.CosmeticBackend.Model.Pay;
import com.niit.CosmeticBackend.Model.Product;
import com.niit.CosmeticBackend.Model.Shipping;
import com.niit.CosmeticBackend.Model.User;
import com.niit.CosmeticFrontend.Otp.OtpGenerator;
import com.niit.CosmeticFrontend.fileInput.fileInput;
@Controller

public class OrderController {

	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItem cartItem;
	@Autowired
	CartItemDao cartItemDao;
	@Autowired
	Card card;
	@Autowired
	CardDao cardDao;
	@Autowired
	Billing billing;
	@Autowired
	BillingDao billingDao;
	@Autowired
	Shipping shipping;
	@Autowired
	ShippingDao shippingDao;
	@Autowired
	Pay pay;
	@Autowired
	PayDao payDao;
	@Autowired
	Orders orders;
	@Autowired
	OrdersDao ordersDao;
	@Autowired
	OrderItem orderItem;
	@Autowired
	OrderItemDao orderItemDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	List<CartItem> cartItems;
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	Brand brand;
	@Autowired
	BrandDao brandDao;
	@Autowired
    private JavaMailSender mailSender;
	
	String o;
	

	@RequestMapping("/Buyall")
	  public ModelAndView orderall(Model model,HttpSession session) {
		System.out.println("Buyall working");
	 	   ModelAndView mv = new ModelAndView();
    	   List<Category> Categories = categoryDao.getCatList();
   		mv.addObject("Catgeories", Categories);
   		List<Brand> Brands = brandDao.getBrandList();
   		mv.addObject("Brands", Brands);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getEmail(currusername);
			cart = user.getCart();
			product=null;
			cartItems = cartItemDao.getlist(cart.getCartId());
			if(cartItems==null || cartItems.isEmpty())
			{
				System.out.println("True for cartitems");
				return new ModelAndView("redirect:/checkout");
			}
			else
			{
				System.out.println("Else for cartitems");
				billing = billingDao.getUserId(user.getuId());
				List<Shipping> shippings = shippingDao.getUserId(user.getuId());
				
				model.addAttribute("billing", billing);
				model.addAttribute("user", user);
				model.addAttribute("shippings", shippings);
				model.addAttribute("shipping", new Shipping());
				session.setAttribute("p", product);
			}
			mv.setViewName("BillingAndShipping");
			return mv;
		} else {
			return new ModelAndView( "redirect:/");
		}

	}

	@RequestMapping("/Buy/{proId}/{cartItemsId}")
	public ModelAndView  order(@PathVariable("proId") String id, Model model,HttpSession session) {
		System.out.println(234244324);
		 ModelAndView mv = new ModelAndView();
	  	   List<Category> Categories = categoryDao.getCatList();
	 		mv.addObject("Catgeories", Categories);
	 		List<Brand> Brands = brandDao.getBrandList();
	 		mv.addObject("Brands", Brands);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getEmail(currusername);
			cart = user.getCart();
			cartItems=null;
			product = productDao.getProduct(id);
			billing = billingDao.getUserId(user.getuId());
			List<Shipping> shippings = shippingDao.getUserId(user.getuId());
			
			model.addAttribute("billing", billing);
			model.addAttribute("user", user);
			model.addAttribute("shippings", shippings);
			model.addAttribute("shipping", new Shipping());
			session.setAttribute("p", product);
			mv.setViewName("BillingAndShipping");
			return mv;
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	@RequestMapping("/orderConfirm")
	public ModelAndView payment(@ModelAttribute("shipping") Shipping sh, Model model) {
//		if(cartItems==null || cartItems.isEmpty())
//		{
//			System.out.println("sorry");
//		}	
		System.out.println(568657667);
		ModelAndView mv = new ModelAndView();
	  	   List<Category> Categories = categoryDao.getCatList();
	 		mv.addObject("Catgeories", Categories);
	 		List<Brand> Brands = brandDao.getBrandList();
	 		mv.addObject("Brands", Brands);
		sh.setUser(user);
		shipping = sh;
		model.addAttribute("billing", billing);
		model.addAttribute("shipping", shipping);
		model.addAttribute("pro", product);
		model.addAttribute("cartItems",cartItems);
		model.addAttribute("cart",cart);
		mv.setViewName("orderconfirm");
		return mv;

	}

	@RequestMapping("/previous")
	public ModelAndView previous(Model model) {
		ModelAndView mv = new ModelAndView();
	  	   List<Category> Categories = categoryDao.getCatList();
	 		mv.addObject("Catgeories", Categories);
	 		List<Brand> Brands = brandDao.getBrandList();
	 		mv.addObject("Brands", Brands);
		List<Shipping> shippings = shippingDao.getUserId(user.getuId());
		model.addAttribute("shippings", shippings);
		model.addAttribute("billing", billing);
		model.addAttribute("shipping", shipping);
		model.addAttribute("product", product);
		mv.setViewName("BillingAndShipping");
		return mv;
	}

	@RequestMapping("/pay")
	public ModelAndView pay(Model model, @ModelAttribute("card") Card c) {
	System.out.println("in pay");
		ModelAndView mv = new ModelAndView();
	  	   List<Category> Categories = categoryDao.getCatList();
	 		mv.addObject("Catgeories", Categories);
	 		List<Brand> Brands = brandDao.getBrandList();
	 		mv.addObject("Brands", Brands);
//		List<Card> cards = cardDao.getCardUser(user.getuId());
//		model.addAttribute("cards", cards);
//		model.addAttribute("card",c);

	 		mv.setViewName("Payment");
			return mv;

	}

	@RequestMapping("/Paying")
			public ModelAndView paying(Model model,@RequestParam("payb")String str) {
		System.out.println("in paying");
			ModelAndView mv = new ModelAndView();
		  	   List<Category> Categories = categoryDao.getCatList();
		 		mv.addObject("Catgeories", Categories);
		 		List<Brand> Brands = brandDao.getBrandList();
		 		mv.addObject("Brands", Brands);
//			List<Card> cards = cardDao.getCardUser(user.getuId());
//			model.addAttribute("cards", cards);
//			model.addAttribute("card", new Card());
		 		
		 		if(str.equals(o))
		 		{	
		 			
					pay.setPayMethod("COD");
					pay.setPayStatus("yes");
		 		return new ModelAndView("redirect:/orderconfirmation");
		}
		 		else {
		 			mv.setViewName("error");
		 			return mv;
		 		}
	}
	@RequestMapping("/addCard")
	public ModelAndView addCard(@ModelAttribute("card") Card c) {
		System.out.println("in card");
		
		ModelAndView mv = new ModelAndView();
		if (cardDao.saveorupdate(c) == true) {
			System.out.println("Card Saved");
			mv.addObject("msg", "Card Saved");
		} else {
			System.out.println("Card Not Saved");
			mv.addObject("msg", "Card not Saved");

		}
		mv.setViewName("redirect:/Payment");

		return mv;
	}

	@RequestMapping("/Payment")
	public ModelAndView payment( @ModelAttribute("card") Card c, Model model) {
		System.out.println(266520);
		ModelAndView mv = new ModelAndView();
	  	   List<Category> Categories = categoryDao.getCatList();
	 		mv.addObject("Catgeories", Categories);
	 		List<Brand> Brands = brandDao.getBrandList();
	 		mv.addObject("Brands", Brands);
 		System.out.println(1324);
	
			pay.setPayMethod("card");
			pay.setPayStatus("yes");	
//			pay.setCart(cart);
//			pay.setOrders(orders);
			payDao.saveorupdate(pay);
			
			cardDao.saveorupdate(c);
			
		return new ModelAndView("redirect:/orderconfirmation");
	}

	@RequestMapping("/orderconfirmation")
	public ModelAndView orderconformation(HttpSession session) {
		System.out.println(894581263);
		ModelAndView mv = new ModelAndView();
	  	   List<Category> Categories = categoryDao.getCatList();
	 		mv.addObject("Catgeories", Categories);
	 		List<Brand> Brands = brandDao.getBrandList();
	 		mv.addObject("Brands", Brands);
		System.out.println(32);
		orders.setBilling(billing);
		orders.setShipping(shipping);
		orders.setPay(pay);
		orders.setUser(user);
		System.out.println(524);
		if (cartItems == null || cartItems.isEmpty()) 
		{
			orders.setGrandTotal(product.getProPrice());
			ordersDao.saveorupdate(orders);
			orderItem.setOrders(orders);
			orderItem.setProductId(product.getProId());
			orderItemDao.saveorupdate(orderItem);
			cart.setGrandTotal(cart.getGrandTotal() - cartItem.getPrice());
			cart.setTotalItems(cart.getTotalItems() - 1);
			session.setAttribute("items", cart.getTotalItems());
			cartDao.saveorupdate(cart);
			
			String cartItem1=cartItemDao.getlistall(cart.getCartId(),product.getProId()).getCartItemsId();
			cartItem=cartItemDao.getCartItem(cartItem1);
			cartItemDao.delete(cartItem);
			System.out.println(324);
		}
		else
		{ 
			System.out.println(656);
			orders.setGrandTotal(cart.getGrandTotal());
			ordersDao.saveorupdate(orders);
			for(CartItem c:cartItems)
			{
				System.out.println(3444);
				orderItem.setOrders(orders);
				orderItem.setProductId(c.getProduct().getProId());
				System.out.println(3443);
				orderItemDao.saveorupdate(orderItem);
		
				cartItemDao.delete(c);
			}
				cart.setGrandTotal(0.0);
			cart.setTotalItems(0);

			System.out.println(346);
			session.setAttribute("items", cart.getTotalItems());
			cartDao.saveorupdate(cart);
		}
		cartItems=null;
		cartItem=null;
		product=null;
		orders=new Orders();
		orderItem=new OrderItem();
		System.out.println(565);
		mv.setViewName("thankyou");
		return mv;
	}


@RequestMapping(value="/SendMail")
public void SendMail() {
	System.out.println(21312);
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
if (!(authentication instanceof AnonymousAuthenticationToken)) {
	String currusername = authentication.getName();
	user = userDao.getEmail(currusername);      
	OtpGenerator ot=new OtpGenerator();
//	String o=ot.Otpga();
	o=ot.Otpga();
	String recipientAddress = user.getuEmail();
	String subject="OTP";
//String subject = request.getParameter("subject");
String message = "your one time password is "+o+" ";

// prints debug info
System.out.println("To:" + recipientAddress);
System.out.println("Subject: " + subject);
System.out.println("Message: " + message);

    
//System.out.println("OTP:"+ otp);
// creates a simple e-mail object
SimpleMailMessage email = new SimpleMailMessage();
email.setTo(recipientAddress);
email.setSubject(subject);
email.setText(message);
//email.setSubject(otp);
// sends the e-mail
mailSender.send(email);

 
// forwards to the view named "Result"
//return "Result";
}
}
	
}
