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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class GiftCards {
	// Attributes of GiftCards class
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GiftCardID")
	private int giftCardID;
	
	@NotNull(message = "Code can't be Null value.")
    @Size(min=2,max = 50, message = "Minimum 2 and maximum 50 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Only Alphabets and Numeric Values are Allowed")
	@Column(name="Code",length=50)
	private String code;
	

	@NotNull(message = "Amount can't be have null value.")
	@Column(name="Amount")
	private int amount;
	
	@NotNull(message = "ExpiryDate can't be have null value.")
	@Column(name="ExpiryDate",length=20)
	private LocalDate expiryDate;
	
	@NotNull(message = "UserID can't be have null value.")
    @Column(name="UserID")
	private int userID;

	//Association of GiftCards class with other classes
	@ManyToOne(cascade=CascadeType.ALL)
	User user;

	@ManyToOne(cascade=CascadeType.ALL)
	Payments payments;
	
	@ManyToMany(mappedBy="giftCards",cascade=CascadeType.ALL)
	List<Orders> orders = new ArrayList<Orders>();

	



    
    

}