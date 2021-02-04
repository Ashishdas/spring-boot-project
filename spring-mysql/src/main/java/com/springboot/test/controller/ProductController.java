package com.springboot.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.test.dto.InputRequest;
import com.springboot.test.model.Product;
import com.springboot.test.service.ProductService;

@RestController
public class ProductController {

	Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService service;

	@PostMapping("/addProduct")
	public Product addSingleProduct(@RequestBody InputRequest<Product> inputRequest) {
		log.debug("request{}", inputRequest);
		Product product = inputRequest.getProduct();
		product.setCreatedBy(inputRequest.getLoggedInUser());
		Product productResponse = service.saveProduct(product);
		log.debug("response{}", productResponse);
		return service.saveProduct(productResponse);
	}

	@PostMapping("/addProducts")
	public List<Product> addListOfProduct(@RequestBody List<InputRequest<Product>> inputRequest) {
		log.debug("request{}", inputRequest);
		ArrayList<Product> products = new ArrayList<>();
		for (InputRequest<Product> inputRequestdata : inputRequest) {
			Product product = inputRequestdata.getProduct();
			product.setCreatedBy(inputRequestdata.getLoggedInUser());
			products.add(product);
		}
		List<Product> listOfProduct = service.saveProducts(products);
		log.debug("response{}", listOfProduct);
		return listOfProduct;
	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		List<Product> listOfProduct = service.getProducts();
		log.debug("response{} of /products", listOfProduct);
		return listOfProduct;
	}

	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id) {
		log.debug("request{}", id);
		Product product = service.getProductById(id);
		log.debug("response{}", product);
		return product;
	}

	@GetMapping("/product/{name}")
	public Product findProductByName(@PathVariable String name) {
		log.debug("request{}", name);
		Product product = service.getProductByName(name);
		log.debug("response{}", product);
		return product;
	}

	@PutMapping("/update")
	public String updateProduct(@RequestBody InputRequest<Product> inputRequest) {
		log.debug("request{}", inputRequest);
		Product product = inputRequest.getProduct();
		product.setModifiedBy(inputRequest.getLoggedInUser());
		String response = service.updateProduct(product);
		log.debug("response{}", response);
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		log.debug("request{}", id);
		String response = service.deleteProduct(id);
		log.debug("response{}", response);
		return response;
	}
}