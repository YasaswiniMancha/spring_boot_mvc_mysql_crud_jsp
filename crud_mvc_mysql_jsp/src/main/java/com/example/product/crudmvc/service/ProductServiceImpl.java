package com.example.product.crudmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.crudmvc.entity.Product;
import com.example.product.crudmvc.repo.ProductRepository;

@Transactional
@Service
public class ProductServiceImpl  {

	@Autowired
	private ProductRepository productRepository;

	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	

	
	public Integer getItemNumber() {
	   Integer id;
	   if(productRepository.getItemId() == null)
           id=1;
		else
			id=productRepository.getItemId()+1;
	   return id;   
	}
	
	
	public List<Product> showAllItems() {
		return productRepository.findAll();
	}

	
	public void saveItem(Product itemList) {
		productRepository.save(itemList);
	}

	
	public void deleteItem(Integer id) {
		productRepository.deleteById(id);

	}

	
	public Product getDetails(Integer id) {
		return productRepository.findById(id).get();
	}

	
	public List<Product> saveProducts(List<Product> products) {
	    products.forEach(product -> {
	        System.out.println("Saving product: " + product);
	    });
	    return productRepository.saveAll(products);
	}

	
}
