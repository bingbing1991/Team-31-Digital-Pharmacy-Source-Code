package com.example.digital_pharmacy.repository;


import com.example.digital_pharmacy.model.OrderProduct;
import com.example.digital_pharmacy.model.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}