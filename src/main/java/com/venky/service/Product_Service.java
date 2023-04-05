package com.venky.service;

import java.util.List;

import com.venky.payload.ProductResponse;
import com.venky.payload.Product_Dto;

public interface Product_Service {
	
	public Product_Dto createProduct(Product_Dto dto,Integer categoryId);
	
	public ProductResponse get_All_Products(int pageNumber,int pageSize,String sortBy,String sortDir);
	
	public Product_Dto get_product_By_Id(Integer product_id );
	
	public Product_Dto update_Product(Product_Dto model,Integer product_id);
	
	public void delete_Product(Integer product_id);
	
	public List<Product_Dto> findProductByCategory(Integer categoryId);
	
	
		
	

}
