package com.example.digital_pharmacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import com.example.digital_pharmacy.model.Product;
import com.example.digital_pharmacy.service.ProductService;

@SpringBootApplication
//@EnableDiscoveryClient
public class PrescriptionServicesApplication
{

	public static void main(String[] args) {
		SpringApplication.run(PrescriptionServicesApplication.class, args);
	}

	@Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "Paracetamol(1000mg)", 3.50, "http://placehold.it/200x100"));
            productService.save(new Product(2L, "Folic Acid(150mg)", 1.50, "http://placehold.it/200x100"));
            productService.save(new Product(3L, "Dimenhydrinte(1000mg)", 5.00, "http://placehold.it/200x100"));
//            productService.save(new Product(4L, "Icecream", 5.00, "http://placehold.it/200x100"));
//            productService.save(new Product(5L, "Beer", 3.00, "http://placehold.it/200x100"));
//            productService.save(new Product(6L, "Phone", 500.00, "http://placehold.it/200x100"));
//            productService.save(new Product(7L, "Watch", 30.00, "http://placehold.it/200x100"));
        };
    }
}
