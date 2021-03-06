package net.kzn.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
 	@RequestMapping(value = {"/", "home", "/index"})
	public ModelAndView index() {
		
		logger.info("Info: Inside page controller index method..");
		logger.debug("Debug: Inside page controller index method..");
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickHome", true);
		mv.addObject("title", "Home");
		
		//passing list of categories
		mv.addObject("categories", categoryDAO.list());
		
		return mv;
		
	}
	
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAbout", true);
		mv.addObject("title", "About Us");
		return mv;
		
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickContact", true);
		mv.addObject("title", "Contact Us");
		return mv;
		
	}
	
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("userClickCategoryProducts", false);
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		return mv;
		
	}
	
	
	
	
	/*Method to load all the products and based on category.
	 * 
	*/	
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable(value = "id")int id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		//Category to fetch a single category.
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		mv.addObject("userClickAllProducts", false);
		return mv;
		
	} 
	
	/* Viewing a single product.
	 * 
	*/	
	@RequestMapping(value = {"/show/{id}/product"})
	public ModelAndView showSingleProduct(@PathVariable(value = "id")int id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		//Update the view count for a product.
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	} 
	
}
