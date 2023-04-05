package com.venky.ServiceImp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venky.Exception.Resourses_Not_Found;
import com.venky.model.Category;
import com.venky.payload.Category_Dto;
import com.venky.repository.Category_Repository;
import com.venky.service.Category_Service;

@Service
public class CategoryServiceImp implements Category_Service {

	@Autowired
	private Category_Repository category_Repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Category_Dto createCategory(Category_Dto category_Dto) {

		Category category = mapper.map(category_Dto, Category.class);

		Category save = category_Repository.save(category);

		return mapper.map(save, Category_Dto.class);
	}

	@Override
	public Category_Dto getOneCategory(Integer categoryId) {

		Category category = category_Repository.findById(categoryId)
				.orElseThrow(() -> new Resourses_Not_Found(String.format("CAtegory Id:%d is not found", categoryId)));

		return mapper.map(category, Category_Dto.class);
	}

	@Override
	public List<Category_Dto> getAllCategory() {

		List<Category> category = category_Repository.findAll();

		return (List<Category_Dto>) mapper.map(category, Category_Dto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {

		category_Repository.findById(categoryId)
				.orElseThrow(() -> new Resourses_Not_Found(String.format("Category Id:%d is Not Found", categoryId)));

		category_Repository.deleteById(categoryId);

	}

	@Override
	public Category_Dto updateCategory(Category_Dto category_Dto, Integer categoryId) {

		Category category = category_Repository.findById(categoryId)
				.orElseThrow(() -> new Resourses_Not_Found(String.format("Category Id :%d is Not Found", categoryId)));

		return mapper.map(category, Category_Dto.class);
	}

}
