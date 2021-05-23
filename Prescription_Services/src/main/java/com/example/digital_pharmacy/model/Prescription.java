package com.example.digital_pharmacy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="prescription")
public class Prescription
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "USER_SEQ")
	@Column(name = "prescription_id")
	private int prescriptionId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "prescription_desc")
	private String prescriptionDesc;
	
	@Column(name = "prescription_date")
	private Date prescriptionDate;
	
	@Column(name = "total_cost")
	private Double totalCost;
	
	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Date getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public int getPrescriptionId()
	{
		return prescriptionId;
	}
	
	public void setPrescriptionId(int prescriptionId)
	{
		this.prescriptionId = prescriptionId;
	}
	
	public int getUserId()
	{
		return userId;
	}
	
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	public String getPrescriptionDesc()
	{
		return prescriptionDesc;
	}
	
	public void setPrescriptionDesc(String prescriptionDesc)
	{
		this.prescriptionDesc = prescriptionDesc;
	}
	
	
	public Prescription(int prescriptionId, int userId, String prescriptionDesc, Date prescriptionDate)
	{
		super();
		this.prescriptionId = prescriptionId;
		this.userId = userId;
		this.prescriptionDesc = prescriptionDesc;
		this.prescriptionDate = prescriptionDate;
	}
	
	public Prescription()
	{
		
	}
	
}
