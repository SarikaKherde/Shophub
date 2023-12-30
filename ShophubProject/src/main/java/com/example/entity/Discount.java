package com.example.entity;


import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Annotation
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Discount {
	// Attributes of Discount class
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="DiscountID")
	private int discountID;
	
	@NotEmpty(message = "DiscountName can't be Empty.")
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="DiscountName",length=30)
	private String discountName;
	
   
    @NotNull(message = "DiscountPercent can't be have null value.")
	@Column(name="DiscountPercent")
	private int discountPercent;
    
  //Association of Discount class with other classes
	@OneToMany(cascade=CascadeType.ALL,mappedBy="discount",fetch=FetchType.EAGER)
	List<Products> products;
	

	

}