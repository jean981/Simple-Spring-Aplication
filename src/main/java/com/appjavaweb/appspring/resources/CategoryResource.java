package com.appjavaweb.appspring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appjavaweb.appspring.entities.Category;
import com.appjavaweb.appspring.repositories.CategoryRepository;

//public class CategoryResource {

	@RestController
	@RequestMapping(value = "/categories")
	public class CategoryResource {

	/* This is wrong. That's not how you compose objects this way.
	private CategoryRepository categoryRepository = new CategoryRepository();
		
		Use spring boot dependency injection.*/
		@Autowired
		private CategoryRepository categoryRepository;
		
		@GetMapping
		public ResponseEntity<List<Category>> findAll() {
			List<Category> list = categoryRepository.findAll();
			return ResponseEntity.ok().body(list);
		}

		@GetMapping(value = "/{id}")
		public ResponseEntity<Category> findById(@PathVariable Long id) {
			//@pathvariable recognizes the ID parameter of the called method.
			Category cat = categoryRepository.findById(id);
			return ResponseEntity.ok().body(cat);
		}

		public CategoryRepository getCategoryRepository() {
			return categoryRepository;
		}

		public void setCategoryRepository(CategoryRepository categoryRepository) {
			this.categoryRepository = categoryRepository;
		}
}
