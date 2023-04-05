package com.venky.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	@Column(name = "title", nullable = false)
	private String title;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ProductModel> model;

	public Category() {
		super();
	}

	public Category(Integer categoryId, String title, Set<ProductModel> model) {
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
		return "Category [getCategoryId()=" + getCategoryId() + ", getTitle()=" + getTitle() + ", getModel()="
				+ getModel() + "]";
	}

}
