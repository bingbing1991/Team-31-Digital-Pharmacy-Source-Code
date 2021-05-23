package com.example.digital_pharmacy.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.digital_pharmacy.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{
//	public Product findById(Long id);
	
//	public Product update(Product product);
}
