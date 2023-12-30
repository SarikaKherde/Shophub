package com.example.entity;

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
public class ShoppingCart {
	// Attributes of ShoppingCart class
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CartID")
	private int cartID;
	
	@NotNull(message = "UserID can't be have null value.")
    @Column(name="UserID")
	private int userID;
	
	@NotNull(message = "ProductID can't be have null value.")
	@Column(name="ProductID")
	private int productID;
	

	@NotNull(message = "Quantity can't be have null value.")
	@Column(name="Quantity")
	private int quantity;

	//Association of ShoppingCart class with other classes
	@OneToOne
	@JoinColumn(name = "user_userID")
	private User user;
	
    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
	
	
	
}
