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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Annotation
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Wishlist {
	// Attributes of Wishlist class
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="WishlistID")
	private int wishlistID;
	
	@NotNull(message = "UserID can't be have null value.")
	@Column(name="UserID")
	private int userID;
	

	@NotNull(message = "productID can't be have null value.")
	@Column(name="ProductID")
	private int productID;
	
	@NotNull(message = "DateAdded can't be have null value.")
	@Column(name="DateAdded",length=20)
	private LocalDate dateAdded;

	//Association of wishList class with other classes
	@OneToOne(mappedBy="wishlist")
	private User user;
	
	@OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL)
	 private List<WishlistItem> wishlistItems;


	

}