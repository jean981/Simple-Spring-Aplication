package com.appjavaweb.appspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appjavaweb.appspring.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}

