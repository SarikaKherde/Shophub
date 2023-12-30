package com.example.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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
public class Reviews {
	// Attributes of Reviews class
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ReviewID")
	private int reviewID;
	
	
    @DecimalMin(value = "0.0", inclusive = true, message = "Rating must be at least 0.0")
    @DecimalMax(value = "5.0", inclusive = true, message = "Rating must be at most 5.0")
    @NotNull(message = "Rating can't be have null value.")
	@Column(name="Rating")
	private float rating;
	
    @Size(max = 100, message = "Comment must not exceed 100 characters")
  	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Values are Allowed")
	@Column(name="Comment",length=100)
	private String comment;
		

   // Attributes of Reviews class
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "userID")
    private User user;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name = "productID")
	private Products products;
	
	@NotNull(message="Enter the  productID for the Review.")
	private Integer reviewsProductID;
	
	

	


	
}

