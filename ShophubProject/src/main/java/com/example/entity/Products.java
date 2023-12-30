package com.example.entity;


import java.util.ArrayList;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Annotation
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Products {
	// Attributes of Products class
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ProductID")
	private int productID;
	
	@NotEmpty(message = "ProductName can't be Empty.")
    @Size(min = 2, max = 40, message = "Minimum 2 and maximum 40 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="ProductName",length=30)
	private String productName;
	
	
    @NotNull(message = "Price can't be null value.")
	@Min(value = 1, message = "stockQuantity must be at least 1.")
	@Column(name="Price")
	private int price;
	

	@Min(value = 1, message = "stockQuantity must be at least 1.")
	@Column(name="StockQuantity")
	private int stockQuantity;
	
	
	@Column(name = "Description", length = 255)
	@NotEmpty(message = "Description is required")
	@Size(max = 250, message = "Please Enter Only Upto 250 characters.")
	private String description;
	
	//Association of Products class with other classes
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Categories categories;
	
	@NotNull(message="Enter the categoryID for the product.")
	private Integer productCategoryID;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="products",fetch=FetchType.EAGER)
	@JsonIgnore
	List<Reviews> reviews;

	@ManyToOne
	private ShoppingCart shoppingCart;

	
	@ManyToMany(mappedBy="products")
	@JsonIgnore
	private List<Orders> orders = new ArrayList<>() ;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Discount discount;
	
	
	   @OneToMany(mappedBy = "products")
		private List<WishlistItem> wishlistItems;
	

	
	

}


