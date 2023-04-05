package com.venky.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venky.payload.Category_Dto;
import com.venky.service.Category_Service;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private Category_Service categoryService;

	@PostMapping("/save")
	public ResponseEntity<Category_Dto> createCategory(@RequestBody Category_Dto category_Dto) {

		return new ResponseEntity<Category_Dto>(categoryService.createCategory(category_Dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/getone/{categoryId}")
	public ResponseEntity<Category_Dto> getOneCategory(@PathVariable Integer categoryId){
		return new ResponseEntity<Category_Dto>(categoryService.getOneCategory(categoryId),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Category_Dto>> getAllCategory(){
		
		return new ResponseEntity<List<Category_Dto>>(categoryService.getAllCategory(),HttpStatus.OK);
	}
	
	@DeleteMapping("//delete/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer categoryId){
		
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<String>("Category Deleted Succesfully.....",HttpStatus.OK);
	}
	@PutMapping("/update/{categoryId}")
	public ResponseEntity<Category_Dto> updateCategory(@RequestBody Category_Dto category_Dto,@PathVariable Integer categoryId){
	
		return new ResponseEntity<Category_Dto>(categoryService.updateCategory(category_Dto, categoryId),HttpStatus.OK);
	}
}
