package com.venky.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import jakarta.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ManyToAny;

@Entity
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer product_id;
	@Column(name = "product_name", nullable = false)
	private String product_name;
	@Column(name = "product_prize", nullable = false)
	private double product_prize;
	@Column(name = "stock", nullable = false)
	private boolean stock = true;
	@Column(name = "product_quantity", nullable = false)
	private Integer product_quantity;
	@Column(name = "live", nullable = false)
	private boolean live;
	@Column(name = "product_image_name", nullable = false)
	private String product_image_name;
	@Column(name = "product_desc", nullable = false)
	private String product_desc;

	@ManyToMany(fetch = FetchType.EAGER)
	private Category category;

	public ProductModel() {
		super();
	}

	public ProductModel(Integer product_id, String product_name, double product_prize, boolean stock,
			Integer product_quantity, boolean live, String product_image_name, String product_desc, Category category) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_prize = product_prize;
		this.stock = stock;
		this.product_quantity = product_quantity;
		this.live = live;
		this.product_image_name = product_image_name;
		this.product_desc = product_desc;
		this.category = category;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_prize() {
		return product_prize;
	}

	public void setProduct_prize(double product_prize) {
		this.product_prize = product_prize;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public String getProduct_image_name() {
		return product_image_name;
	}

	public void setProduct_image_name(String product_image_name) {
		this.product_image_name = product_image_name;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductModel [getProduct_id()=" + getProduct_id() + ", getProduct_name()=" + getProduct_name()
				+ ", getProduct_prize()=" + getProduct_prize() + ", isStock()=" + isStock() + ", getProduct_quantity()="
				+ getProduct_quantity() + ", isLive()=" + isLive() + ", getProduct_image_name()="
				+ getProduct_image_name() + ", getProduct_desc()=" + getProduct_desc() + ", getCategory()="
				+ getCategory() + "]";
	}

}
