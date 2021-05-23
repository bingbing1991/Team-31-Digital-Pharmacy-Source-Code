package com.example.digital_pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digital_pharmacy.model.Prescription;
import com.example.digital_pharmacy.repository.PrescriptionRepository;

@Service
public class PrescriptionService
{
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	public Prescription savePrescription(Prescription prescription)
	{
		return prescriptionRepository.save(prescription);
	}
	
	public Prescription findByUserId(Long userId)
	{
		Prescription foundPrescr = prescriptionRepository.findByUserId(userId);
		return foundPrescr;
	}
	
	public Prescription findByPrescriptionId(Long prescriptionId)
	{
		Prescription foundPrescr = prescriptionRepository.findByPrescriptionId(prescriptionId);
		return foundPrescr;
	}
	
	public List<Prescription> findAllByUserId(Long userId)
	{
		List<Prescription> foundPrescr = prescriptionRepository.findAllByUserId(userId);
		return foundPrescr;
	}
	
}
