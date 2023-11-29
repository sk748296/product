package com.product.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product) {
		return null;
		
			
	}

}
