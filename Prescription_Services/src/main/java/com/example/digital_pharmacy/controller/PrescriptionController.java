package com.example.digital_pharmacy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.digital_pharmacy.model.Prescription;
import com.example.digital_pharmacy.service.PrescriptionService;

@RestController
@RequestMapping("/prescriptions")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PrescriptionController
{
	@Autowired
	private PrescriptionService prescriptionService;
	
	@PostMapping("/createPrescription")
//	@CrossOrigin(origins = "http://localhost:4200")
	public Prescription createPrescription(@RequestBody Prescription prescription) throws Exception
	{
		Prescription newPrescription = new Prescription();
		newPrescription = prescriptionService.savePrescription(prescription);
		return newPrescription;
	}
	
	@GetMapping("/getPrescription")
//	@CrossOrigin(origins = "http://localhost:4200")
	public Prescription getPrescription(@RequestBody Long Id) throws Exception
	{
		Prescription prescription = new Prescription();
		prescription = prescriptionService.findByPrescriptionId(Id);
		return prescription;
	}
	
	@GetMapping("/getAllPrescriptions")
//	@CrossOrigin(origins = "http://localhost:4200")
	public List<Prescription> getAllPrescriptions(@RequestBody Long Id) throws Exception
	{
		List<Prescription> prescriptionList = new ArrayList<Prescription>();
		prescriptionList = prescriptionService.findAllByUserId(Id);
		return prescriptionList;
	}
}
