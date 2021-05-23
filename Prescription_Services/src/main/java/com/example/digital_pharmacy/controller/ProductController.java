package com.example.digital_pharmacy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import com.example.digital_pharmacy.model.Product;
import com.example.digital_pharmacy.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController
{
//	@Autowired
//	private ProductService productService;
//	
//	@PostMapping("/createProduct")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public Product createProduct(@RequestBody Product product) throws Exception
//	{
//		Product returnProduct = new Product();
//		returnProduct = productService.saveProduct(product);
//		return returnProduct;
//	}
//	
//	@GetMapping("/getProduct")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public Product getProduct(@RequestBody Long productId) throws Exception
//	{
//		Product product = new Product();
//		product = productService.findByProductId(productId);
//		return product;
//	}
//	
//	@GetMapping("/getAllProducts")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public List<Product> getAllProducts() throws Exception
//	{
//		List<Product> productList = new ArrayList<Product>();
//		productList = productService.findAllProduct();
//		return productList;
//	}
//	
//	@PostMapping("/updateProduct")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public Product updateProduct(@RequestBody Product product) throws Exception
//	{
//		Product returnProduct = new Product();
//		returnProduct = productService.updateProduct(product);
//		return returnProduct;
//	}
	@Autowired
	private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = { "", "/" })
//    @CrossOrigin(origins = "http://localhost:4200")
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
    
    @PostMapping(value = "/createProduct")
//    @CrossOrigin(origins = "http://localhost:4200")
    public Product createProducts(@RequestBody Product product) {
        return productService.save(product);
    }
}
