package com.example.digital_pharmacy.model;

//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
////import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="product")
public class Product
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;

    private Double price;

    private String pictureUrl;

    public Product(Long id, @NotNull(message = "Product name is required.") String name, Double price, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
////    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "USER_SEQ")
//	@Column(name = "product_id")
//	private int productId;
//	
//	@NotNull(message = "Product name is required.")
//    @Basic(optional = false)
//	@Column(name = "product_name")
//	private String productName;
//	
//	@Column(name = "product_desc")
//	private String productDesc;
//	
//	public String getPictureUrl() {
//		return pictureUrl;
//	}
//
//	public void setPictureUrl(String pictureUrl) {
//		this.pictureUrl = pictureUrl;
//	}
//
//	@Column(name = "product_cost")
//	private Double productCost;
//	
//	@Column(name = "product_image_url")
//	private String pictureUrl;
//	
//	public int getProductId() {
//		return productId;
//	}
//
//	public void setProductId(int productId) {
//		this.productId = productId;
//	}
//
//	public String getProductName() {
//		return productName;
//	}
//
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//
//	public String getProductDesc() {
//		return productDesc;
//	}
//
//	public void setProductDesc(String productDesc) {
//		this.productDesc = productDesc;
//	}
//
//	public Double getProductCost() {
//		return productCost;
//	}
//
//	public void setProductCost(Double productCost) {
//		this.productCost = productCost;
//	}


}
