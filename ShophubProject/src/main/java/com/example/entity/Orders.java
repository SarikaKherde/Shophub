package com.example.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Annotation
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Orders {
	// Attributes of Orders  class
	@Id
	@Column(name="OrderID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderID;
	
	@NotNull(message = "UserID can't be have null value.")
    @Column(name="UserID")
	private int userID;
	
	@NotNull(message = "OrderDate can't be have null value.")
	@Column(name="OrderDate",length=20)
	private LocalDate orderDate;
	
	@NotNull(message = "Status can't be Null vlaue.")
    @Size(min = 3, max =30 , message = "Minimum 3 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="Status",length=30)
	private String status;
	
	//Association of Orders  class with other classes
	@ManyToOne(cascade=CascadeType.ALL)
	User user;
	
	@OneToOne
	Payments payments;
	
	@OneToOne
	Returns returns;
	
	@OneToOne
	Shipment shipment;

	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "orders_products",joinColumns = @JoinColumn(name = "orders_OrderID"),inverseJoinColumns = @JoinColumn(name = "products_productID"))
	private List<Products> products = new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	List<GiftCards> giftCards = new ArrayList<GiftCards>();

	


	
}

