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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Payments {
	// Attributes of categories class
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="PaymentID")
	private int paymentID;
	
    @NotNull(message = "OrderID can't be have null value.")
	@Column(name="OrderID")
	private int orderID;
	

    @NotNull(message = "Amount can't be have null value.")
	@Column(name="Amount")
	private int amount;
	
	@NotNull(message = "PaymentDate can't be have null value.")
	@Column(name="RegistrationDate",length=20)
	private LocalDate paymentDate;
	
	@NotEmpty(message = "PaymentMethod can't be Empty.")
    @Size(min = 3, max =30 , message = "Minimum 3 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="UserName",length=30)
	private String paymentMethod;
	
	//Association of Categories class with other classes
	@OneToOne(mappedBy="payments",cascade=CascadeType.ALL)
	Orders orders;
	
	@ManyToOne(cascade=CascadeType.ALL)
	User user;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<GiftCards> giftCards = new ArrayList<GiftCards>();
	


    
}