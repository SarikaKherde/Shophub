package com.example.entity;


import java.util.List;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
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
@Component
public class Categories {
	// Attributes of categories class
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="CategoryID")
	private int categoryID;
	
	@NotEmpty(message = "Category Name can't be Empty.")
    @Size(min = 3, max = 30, message = "Minimum 3 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="CategoryName",length=30)
	private String categoryName;
	
	@Column(name = "Description", length = 255)
	@NotEmpty(message = "Description is required")
	@Size(max = 250, message = "Please Enter Only Upto 250 characters.")
    private String description;
    
	@Column(name="ImageUrl")
    private String imageUrl;
	
	//Association of Categories class with other classes
	@OneToMany(cascade=CascadeType.ALL,mappedBy="categories",fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Products> products;
	
	

}