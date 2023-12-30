package com.example.entity;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
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
public class Shipment {
	// Attributes of Shipment class
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="ShipmentID")
	private int shipmentID;
	
	@NotNull(message = "ShipmentDate can't be have null value.")
	@Column(name="ShipmentDate",length=20)
	private LocalDate shipmentDate;
	
	@NotEmpty(message = "State can't be Empty.")
    @Size(max = 50, message = "State must not exceed 50 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Values are Allowed")
	@Column(name="State",length=50)
	private String state;
	
	@NotEmpty(message = "City can't be Empty.")
    @Size(max = 30, message = "City must not exceed 30 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Values are Allowed")
	@Column(name="City",length=30)
	private String city;
	
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
    @NotNull(message = "pincode can't be have null value.")
	@Column(name="pincode")
	private String pincode;
	
	@NotEmpty(message = "HouseName can't be Empty.")
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="HouseName",length=30)
	private String houseName;
	
	@NotEmpty(message = "Area can't be Empty.")
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="Area",length=30)
	private String area ;

	//Association of Shipment class with other classes
	@OneToOne(mappedBy="shipment",cascade=CascadeType.ALL)
	Orders orders; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	User user;
	

	
   
}