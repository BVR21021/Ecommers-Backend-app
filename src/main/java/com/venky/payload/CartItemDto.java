package com.venky.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CartItemDto {
	private int cartItemId;
	private int quantity;
	private double totalprice;
	@JsonIgnore
	private CartDto cart;
	private Product_Dto product;
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
	public CartDto getCart() {
		return cart;
	}
	public void setCart(CartDto cart) {
		this.cart = cart;
	}
	public Product_Dto getProduct() {
		return product;
	}
	public void setProduct(Product_Dto product) {
		this.product = product;
	}
	
	
	
}