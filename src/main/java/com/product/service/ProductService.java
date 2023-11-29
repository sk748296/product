package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.product.entity.Product;
import com.product.repository.ProductRepository;



@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getProduct(){
		return productRepository.findAll();
	}
	
	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public void deleteProductById(int id) {
		 productRepository.deleteById(id);
	}
	
	public Product updateProductById(Product product) {
		return productRepository.save(product);
	}
	


	
	

}
