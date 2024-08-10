package com.example.product.crudmvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.product.crudmvc.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value="select max(item_number) from PRODUCT_MVC_TBL", nativeQuery = true)
	public Integer getItemId();

}
