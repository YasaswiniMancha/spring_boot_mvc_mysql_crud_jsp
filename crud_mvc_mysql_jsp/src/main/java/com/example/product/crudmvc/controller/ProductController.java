package com.example.product.crudmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.product.crudmvc.entity.Product;
import com.example.product.crudmvc.service.ProductServiceImpl;
import com.example.product.crudmvc.wrapper.ProductListWrapper;



@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	

	@GetMapping("/homepage")
	public ModelAndView homepage() {
		ModelAndView mv = new ModelAndView("homepage");
        mv.addObject("productList",productService.showAllItems());
		return mv;
		
	}
	
	@GetMapping("/deleteitem")
	public ModelAndView deleteItem(@RequestParam Integer id) {
		ModelAndView mv = new ModelAndView("redirect:/homepage");
		productService.deleteItem(id);
		return mv;	
	}

	@GetMapping("/insertItemPage")
    public ModelAndView addDetails() {
		ModelAndView mv = new ModelAndView("insertItemPage");
		 mv.addObject("id",productService.getItemNumber());
		return mv;	
    }
    
	
	
	@PostMapping("/addingitem")
	public ModelAndView display(@ModelAttribute Product productList) {
		ModelAndView mv = new ModelAndView("redirect:/homepage");
	    productService.saveItem(productList);
		return mv;
	}
	
	
	@GetMapping("/editItemPage")
    public ModelAndView updateDetails(@RequestParam Integer id) {
		ModelAndView mv = new ModelAndView("editItemPage");
		 mv.addObject("Item", productService.getDetails(id));
		return mv;	
    }
	
	@PostMapping("/updatingitem")
    public ModelAndView update(@ModelAttribute Product product) {
		productService.saveItem(product);
		ModelAndView mv = new ModelAndView("redirect:/homepage");
		return mv;
	}
	
   
	
	
	
	@GetMapping("/insertMultiItemsPage")
	public ModelAndView showInsertMultiItemsPage() {
	    return new ModelAndView("insertMultiItemsPage"); // JSP page to input the number of products
	}


	@PostMapping("/addProducts")
	public ModelAndView addProducts(@RequestParam("numberOfProducts") int numberOfProducts) {
	    ModelAndView modelAndView = new ModelAndView("addProducts"); // JSP page to input product details
	    modelAndView.addObject("numberOfProducts", numberOfProducts);
	    return modelAndView;
	}

	@PostMapping("/saveProducts")
	public ModelAndView saveProducts(@ModelAttribute("productList") ProductListWrapper productListWrapper) {
	    System.out.println("Received products: " + productListWrapper.getProducts());
	    productService.saveProducts(productListWrapper.getProducts());
	    ModelAndView mv= new ModelAndView("redirect:/homepage");
	    return mv;
	}



}