package com.venky.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venky.payload.ApiConstants;
import com.venky.payload.ProductResponse;
import com.venky.payload.Product_Dto;
import com.venky.service.Product_Service;

@RestController
@RequestMapping("/products")
public class Product_Controller {

	@Autowired
	Product_Service product_Service;

	@PostMapping("/save/{categoryId}")
	public ResponseEntity<Product_Dto> save_Product(@RequestBody Product_Dto model, Integer categoryId) {

		return new ResponseEntity<>(product_Service.createProduct(model, categoryId), HttpStatus.CREATED);
	}

	@GetMapping("/getoneproduct/{product_id}")
	public ResponseEntity<Product_Dto> get_product_by_id(@PathVariable Integer product_id) {

		return new ResponseEntity<>(product_Service.get_product_By_Id(product_id), HttpStatus.OK);

	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<ProductResponse> get_All_Products(
			@RequestParam(value = "pageNumber", defaultValue = ApiConstants.PAGE_NUMBER_STRING, required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = ApiConstants.PAZE_SIZE_STRING, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = ApiConstants.SORT_BY_STRING, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = ApiConstants.SORT_DIR_STRING, required = false) String sortDir) {
		
		ProductResponse productResponse=product_Service.get_All_Products( pageNumber,pageSize,sortBy,sortDir);

		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}

	@DeleteMapping("/deleteproduct/{product_id}")
	public ResponseEntity<String> delete_Product(@PathVariable Integer product_id) {

		product_Service.delete_Product(product_id);

		return new ResponseEntity<>("Product Deleted Succesfully....", HttpStatus.OK);

	}

	@PutMapping("/updateProoduct/{product_id}")
	public ResponseEntity<Product_Dto> update_Product(@RequestBody Product_Dto model,
			@PathVariable Integer product_id) {

		return new ResponseEntity<Product_Dto>(product_Service.update_Product(model, product_id), HttpStatus.OK);
	}
	
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<Product_Dto>> getProductbyCategory(@PathVariable Integer categoryId){
		
	
		List<Product_Dto>findProductByCategory=product_Service.findProductByCategory(categoryId);
	
		return new ResponseEntity<>(findProductByCategory,HttpStatus.ACCEPTED);
	}

}
