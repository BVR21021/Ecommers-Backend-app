package com.venky.payload;

import java.util.Set;

import com.venky.model.ProductModel;

public class Category_Dto {

	private Integer categoryId;
	private String title;

	private Set<ProductModel> model;

	public Category_Dto() {
		super();
	}

	public Category_Dto(Integer categoryId, String title, Set<ProductModel> model) {
		super();
		this.categoryId = categoryId;
		this.title = title;
		this.model = model;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<ProductModel> getModel() {
		return model;
	}

	public void setModel(Set<ProductModel> model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Category_Dto [getCategoryId()=" + getCategoryId() + ", getTitle()=" + getTitle() + ", getModel()="
				+ getModel() + "]";
	}

}
