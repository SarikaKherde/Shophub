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
public class Returns {
    
	// Attributes of Returns class
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="ReturnID")
	private int returnID;
	
	@NotNull(message = "OrderID can't be have null value.")
	@Column(name="OrderID")
	private int orderID;
	
	@NotNull(message = "ReturnDate can't be have null value.")
	@Column(name="ReturnDate",length=20)
	private LocalDate returnDate;
	
    @Size(min = 2, max = 255, message = "Minimum 2 and maximum 255 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Only Alphabets,numeric value are Allowed.")
	@Column(name="Reason",length=255)
	private String reason;
	
	@NotNull(message = "Status can't be Null vlaue.")
    @Size(min = 3, max =30 , message = "Minimum 3 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="Status",length=30)
	private String status;

	//Association of Returns class with other classes
	@OneToOne(mappedBy="returns",cascade=CascadeType.ALL)
	Orders orders;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	User user;
	


	
}