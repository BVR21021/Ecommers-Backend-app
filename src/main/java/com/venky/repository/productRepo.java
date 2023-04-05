package com.venky.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venky.model.Category;
import com.venky.model.ProductModel;
import com.venky.payload.Product_Dto;

@Repository
public interface productRepo extends JpaRepository<ProductModel, Integer> {

	List<Product_Dto> findByCategory(Category category);

}
