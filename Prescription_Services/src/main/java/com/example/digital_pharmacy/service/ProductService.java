package com.example.digital_pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital_pharmacy.model.Product;
import com.example.digital_pharmacy.repository.ProductRepository;

@Service
@Transactional
public class ProductService
{
	@Autowired
	private ProductRepository productRepository;
	
//	public Product saveProduct(Product product)
//	{
//		return productRepository.save(product);
//	}
//	
//	public Product updateProduct(Product product)
//	{
//		return productRepository.update(product);
//	}
//	
//	public Product findByProductId(Long productId)
//	{
//		Product foundProduct = productRepository.findByProductId(productId);
//		return foundProduct;
//	}
//	
//	public List<Product> findAllProduct()
//	{
//		List<Product> foundProductList = productRepository.findAll();
//		return foundProductList;
//	}
	public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(long id) {
        return productRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
