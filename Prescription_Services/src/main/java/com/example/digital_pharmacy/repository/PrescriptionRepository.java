package com.example.digital_pharmacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.digital_pharmacy.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long>
{
	public Prescription findByUserId(Long userId);
	
	public Prescription findByPrescriptionId(Long prescriptionId);
	
	public List<Prescription> findAllByUserId(Long userId);
}