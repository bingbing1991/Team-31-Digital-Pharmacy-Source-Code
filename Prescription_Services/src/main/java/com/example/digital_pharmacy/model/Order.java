package com.example.digital_pharmacy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
////import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;

@Entity
@Table(name="orders")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="orderProducts")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy") private LocalDate dateCreated;

    private String status;

    @OneToMany(mappedBy = "pk.order")
    @Valid
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<OrderProduct> orderProducts = getOrderProducts();
        for (OrderProduct op : orderProducts) {
            sum += op.getTotalPrice();
        }

        return sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }
}
	
	
	
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
////    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "USER_SEQ")
//	@Column(name = "order_id")
//	private int orderId;
	
//	@Column(name = "prescription_id")
//	private int prescriptionId;
//	
//	@Column(name = "product_id")
//	private int productId;
//
//	@Column(name = "product_quantity")
//	private int productQuantity;
//	
//	@Column(name = "total_product_cost")
//	private Double totalProductCost;
	
//	public Double getTotalProductCost() {
//		return totalProductCost;
//	}
//
//	public void setTotalProductCost(Double totalProductCost) {
//		this.totalProductCost = totalProductCost;
//	}
//
//	public int getProductQuantity() {
//		return productQuantity;
//	}
//
//	public void setProductQuantity(int productQuantity) {
//		this.productQuantity = productQuantity;
//	}
//
//	public int getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//
//	public int getPrescriptionId() {
//		return prescriptionId;
//	}
//
//	public void setPrescriptionId(int prescriptionId) {
//		this.prescriptionId = prescriptionId;
//	}
//
//	public int getProductId() {
//		return productId;
//	}
//
//	public void setProductId(int productId) {
//		this.productId = productId;
//	}
//}

