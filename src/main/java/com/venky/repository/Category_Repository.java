package com.venky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venky.model.Category;

@Repository
public interface Category_Repository extends JpaRepository<Category, Integer> {

}
