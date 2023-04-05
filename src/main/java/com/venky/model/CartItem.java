package com.venky.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;



@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;
	private int quantity;
	private double totalprice;
	//Relationship with other table
	
	@ManyToOne
	private Cart cart;
	@OneToOne
	private ProductModel product;
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
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	
	
	
}