package com.venky.payload;

public class Product_Dto {

	private Integer product_id;
	private String product_name;
	private double product_prize;
	private boolean stock = true;
	private Integer product_quantity;
	private boolean live;
	private String product_image_name;
	private String product_desc;
	private Category_Dto category;

	public Product_Dto() {
		super();
	}

	public Product_Dto(Integer product_id, String product_name, double product_prize, boolean stock,
			Integer product_quantity, boolean live, String product_image_name, String product_desc,
			Category_Dto category) {
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

	public Category_Dto getCategory() {
		return category;
	}

	public void setCategory(Category_Dto category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product_Dto [getProduct_id()=" + getProduct_id() + ", getProduct_name()=" + getProduct_name()
				+ ", getProduct_prize()=" + getProduct_prize() + ", isStock()=" + isStock() + ", getProduct_quantity()="
				+ getProduct_quantity() + ", isLive()=" + isLive() + ", getProduct_image_name()="
				+ getProduct_image_name() + ", getProduct_desc()=" + getProduct_desc() + ", getCategory()="
				+ getCategory() + "]";
	}

}
