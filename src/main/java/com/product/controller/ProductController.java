package com.product.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.JasperService;
import com.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	public ProductService productService;
	
	@Autowired
	public JasperService jasperService;
	
	@GetMapping("/")
	public String index() {
		return"welcome the product details";
	}
	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
		
			
	}
	@GetMapping("/getProduct")
	public List<Product> getProducts(){
		return productService.getProduct();
	}
	@GetMapping("/getProduct/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProductById(@PathVariable int id) {
		productService.deleteProductById(id);
	}
	@PutMapping("/updateProduct/{id}")
	public Product updateProductById(@RequestBody Product product) {
		return productService.updateProductById(product);
	}
	
	@GetMapping("/Report/{formatt}")
	public String generateReport(@PathVariable String  formatt)  throws FileNotFoundException{
		System.out.println("format generate successfully  "+formatt);
		return jasperService.generateReport(formatt);
	}
	

}
