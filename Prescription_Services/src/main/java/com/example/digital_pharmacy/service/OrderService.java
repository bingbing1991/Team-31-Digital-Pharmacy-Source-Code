package com.example.digital_pharmacy.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital_pharmacy.model.Order;
import com.example.digital_pharmacy.repository.OrderRepository;

@Service
@Transactional
public class OrderService
{
	@Autowired
	private OrderRepository orderRepository;
	
//	public Order saveOrder(Order order)
//	{
//		return orderRepository.save(order);
//	}
//	
//	public List<Order> findAllByPrescriptionId(int prescriptionId)
//	{
//		List<Order> foundOrderList = orderRepository.findAllByPrescriptionId(prescriptionId);
//		return foundOrderList;
//	}

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());

        return this.orderRepository.save(order);
    }

    public void update(Order order) {
        this.orderRepository.save(order);
    }
	
}
