package com.venky.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.venky.Exception.Resourses_Not_Found;
import com.venky.model.Category;
import com.venky.model.ProductModel;
import com.venky.payload.Category_Dto;
import com.venky.payload.ProductResponse;
import com.venky.payload.Product_Dto;
import com.venky.repository.Category_Repository;
import com.venky.repository.productRepo;
import com.venky.service.Product_Service;

@Service
public class Product_service_imp implements Product_Service {

	@Autowired
	private productRepo productRepo;

	private Category_Repository category_Repository;

	@Override
	public Product_Dto createProduct(Product_Dto dto, Integer categoryId) {

		Category category = category_Repository.findById(categoryId)
				.orElseThrow(() -> new Resourses_Not_Found(String.format("Category Id:%d is not found", categoryId)));

		ProductModel entity = toEntity(dto);

		entity.setCategory(category);

		ProductModel save = productRepo.save(entity);

		Product_Dto dto1 = toDto(save);

		return dto1;
	}

	@Override
	public ProductResponse get_All_Products(int pageNumber, int pageSize, String sortBy, String sortDir) {

		Sort sort = null;

		if (sortDir.trim().toLowerCase().equals("asc")) {

			sort = Sort.by(sortDir).ascending();
		} else {
			Sort.by(sortBy).descending();
		}

		Pageable page = PageRequest.of(pageNumber, pageSize, sort);

		Page<ProductModel> page1 = productRepo.findAll(page);

		List<ProductModel> product = page1.getContent();

		List<Product_Dto> llp = product.stream().map(p1 -> this.toDto(p1)).collect(Collectors.toList());

		ProductResponse response = new ProductResponse();

		response.setContent(llp);

		response.setPageNumber(page1.getNumber());

		response.setPageSize(page1.getSize());

		response.setTotalPages(page1.getTotalPages());

		response.setLastPage(page1.isLast());

		// List<Product_Dto> model = productRepo.findAll();

		// List<Product_Dto> dto = model.stream().map(product ->
		// this.toDto(product)).collect(Collectors.toList());
		return response;
	}

	public List<Product_Dto> findProductByCategory(Integer categoryId) {

		Category category = category_Repository.findById(categoryId)
				.orElseThrow(() -> new Resourses_Not_Found(String.format("this id:%d is Not Found", categoryId)));

		List<Product_Dto> dtos = productRepo.findByCategory(category);

		return dtos;
	}

	@Override
	public Product_Dto get_product_By_Id(Integer product_id) {

		ProductModel model = productRepo.findById(product_id)
				.orElseThrow(() -> new Resourses_Not_Found(String.format("Product id-%d Does not Exist", product_id)));

		Product_Dto dto = this.toDto(model);

		return dto;
	}

	@Override
	public Product_Dto update_Product(Product_Dto model, Integer product_id) {

		ProductModel pm = productRepo.findById(product_id)
				.orElseThrow(() -> new Resourses_Not_Found(String.format("Product id-%d Does not Exist", product_id)));

		pm.setProduct_name(model.getProduct_name());
		pm.setProduct_prize(model.getProduct_prize());
		pm.setLive(model.isLive());
		pm.setProduct_desc(model.getProduct_desc());
		pm.setProduct_image_name(model.getProduct_image_name());
		pm.setStock(model.isStock());
		pm.setProduct_quantity(model.getProduct_quantity());
		ProductModel model1 = productRepo.save(pm);
		Product_Dto dto = this.toDto(model1);
		return dto;
	}

	@Override
	public void delete_Product(Integer product_id) {

		productRepo.findById(product_id)
				.orElseThrow(() -> new Resourses_Not_Found(String.format("Product id-%d Does not Exist", product_id)));

		productRepo.deleteById(product_id);
	}

	public ProductModel toEntity(Product_Dto dto) {

		ProductModel entity = new ProductModel();

		entity.setLive(dto.isLive());
		entity.setProduct_desc(dto.getProduct_desc());
		entity.setProduct_id(dto.getProduct_id());
		entity.setProduct_image_name(dto.getProduct_image_name());
		entity.setProduct_name(dto.getProduct_name());
		entity.setProduct_prize(dto.getProduct_prize());
		entity.setProduct_quantity(dto.getProduct_quantity());
		entity.setStock(dto.isStock());
		return entity;
	}

	public Product_Dto toDto(ProductModel model) {

		Product_Dto dto = new Product_Dto();

		dto.setLive(model.isLive());
		dto.setStock(model.isStock());
		dto.setProduct_desc(model.getProduct_desc());
		dto.setProduct_id(model.getProduct_id());
		dto.setProduct_image_name(model.getProduct_image_name());
		dto.setProduct_name(model.getProduct_name());
		dto.setProduct_prize(model.getProduct_prize());
		dto.setProduct_quantity(model.getProduct_quantity());

		Category_Dto category_Dto = new Category_Dto();

		category_Dto.setCategoryId(model.getCategory().getCategoryId());
		category_Dto.setTitle(model.getCategory().getTitle());

		dto.setCategory(category_Dto);

		return dto;
	}

}
