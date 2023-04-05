package com.venky.service;

import java.util.List;

import com.venky.payload.Category_Dto;

public interface Category_Service {
	
	public Category_Dto createCategory(Category_Dto category_Dto);
	
	public Category_Dto getOneCategory(Integer categoryId);
	
	public List<Category_Dto> getAllCategory();
	
	public void deleteCategory(Integer categoryId);
	
	public Category_Dto updateCategory( Category_Dto category_Dto, Integer categoryId);

}
