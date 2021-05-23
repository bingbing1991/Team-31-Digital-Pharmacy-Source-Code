package com.example.digital_pharmacy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.digital_pharmacy.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>
{
	
//	public List<Order> findAllByPrescriptionId(int prescriptionId);
}
