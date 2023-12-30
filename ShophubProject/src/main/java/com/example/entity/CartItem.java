package com.example.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CartItem {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 private int quantity;

	 @ManyToOne
	 @JoinColumn(name = "shopping_cart_cartID")
	 private ShoppingCart shoppingCart;

	 @ManyToOne
	 @JoinColumn(name = "products_productID")
	 private Products products;

	 
}
