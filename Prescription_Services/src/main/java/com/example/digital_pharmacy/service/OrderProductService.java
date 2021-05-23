package com.example.digital_pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital_pharmacy.model.OrderProduct;
import com.example.digital_pharmacy.repository.OrderProductRepository;

@Service
@Transactional
public class OrderProductService
{
	@Autowired
    private OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
