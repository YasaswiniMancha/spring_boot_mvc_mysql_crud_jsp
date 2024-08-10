package com.example.product.crudmvc.wrapper;
import com.example.product.crudmvc.entity.Product;

import java.util.*;


public class ProductListWrapper {
	
    private List<Product> products;

    public ProductListWrapper() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
