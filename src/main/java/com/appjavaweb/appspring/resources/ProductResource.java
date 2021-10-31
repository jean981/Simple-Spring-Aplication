package com.appjavaweb.appspring.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appjavaweb.appspring.entities.Product;
import com.appjavaweb.appspring.repositories.ProductRepository;

//public class ProductResource {

	@RestController
	@RequestMapping(value = "/products")
	public class ProductResource {

	/* This is wrong. That's not how you compose objects this way.
	private ProductRepository productRepository = new ProductRepository();
		
		Use spring boot dependency injection.*/
		@Autowired
		private ProductRepository categoryRepository;
		
		@GetMapping
		public ResponseEntity<List<Product>> findAll() {
			List<Product> list = categoryRepository.findAll();
			return ResponseEntity.ok().body(list);
		}

		@GetMapping(value = "/{id}")
		//@pathvariable recognizes the ID parameter of the called method.
		public ResponseEntity<Product> findById(@PathVariable Long id) {
			Product cat = categoryRepository.findById(id);
			return ResponseEntity.ok().body(cat);
		}

		public ProductRepository getProductRepository() {
			return categoryRepository;
		}

		public void setProductRepository(ProductRepository categoryRepository) {
			this.categoryRepository = categoryRepository;
		}
}
