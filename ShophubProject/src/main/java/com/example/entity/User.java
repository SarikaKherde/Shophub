package com.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//To insert getter setter
@Data
//constructor with field
@AllArgsConstructor
//constructor without field
@NoArgsConstructor
//to create class
@Entity
public class User {
	// Attribute of user
	
    //The unique identifier for the user generated using the IDENTITY strategy.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userID;
	
	
	@Column(name = "user_name")
	@Length(min = 4, message = "*Your user name must have at least 4 characters")
	@NotEmpty(message = "*Please provide a user name")
	private String username;
	
	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	
	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String password;
	
	@NotEmpty(message = "First name is empty")
	@Size(min = 2, max = 20, message = "Please Enter proper name")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Allowed")
	@Column(name="fname",length = 30)
	private String fname;

	@NotEmpty(message = "Second name is empty")
	@Size(min = 2, max = 20, message = "Please Enter proper name")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Allowed")
	@Column(name="lname",length = 30)
	private String lname; 
	
	@NotEmpty(message = "PhoneNumber can't be Empty.")
    @Size(min=10,max =10, message = "PhoneNumber must be exactly 10 characters")
	@Pattern(regexp = "^[0-9-()]*$", message = "Only digit are Allowed")
	@Column(name="phonenumber",length=10)
	private String phoneNumber;
	
   @Size(max = 100, message = "Address must not exceed 100 characters")
	@Pattern(regexp = "^[a-zA-z0-9\\s]+$", message = "Only Alphabets and Numeric values are allowed.")
	@Column(name="address",length=100)
	private String address;
    
    //Association of user class with other classes
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Orders> orders = new ArrayList<Orders>();
	
	@OneToMany(cascade=CascadeType.ALL)
	List<GiftCards> giftCards = new ArrayList<GiftCards>();
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	ShoppingCart shoppingCart;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wishlist_wishlistID", referencedColumnName = "wishlistID")
    private Wishlist wishlist;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Shipment> shipment = new ArrayList<Shipment>();
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Payments> payments = new ArrayList<Payments>();
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Returns> returns = new ArrayList<Returns>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user",fetch=FetchType.EAGER)
	@JsonIgnore
	List<Reviews> reviews;
}
