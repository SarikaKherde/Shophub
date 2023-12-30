package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.User;
import com.example.exceptionhandling.UsernameNotFoundException;
import com.example.service.Impl.MyUserDetailService;

import jakarta.persistence.EntityNotFoundException;

//Controller class for managing user logins.

@RestController
public class UserController {
	//To Inject Bean of Class
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private MyUserDetailService userDetailsService;

	//To add user
	@PostMapping(path = "/users") //
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		Map<String, String> errors = new HashMap<>();
		String field = null;
		String message = null;
		try {
			String pwd = user.getPassword();
			String bcryptpwd = passwordEncoder.encode(pwd);
			user.setPassword(bcryptpwd);

			User savedUser = userDetailsService.addUser(user);
			return new ResponseEntity<Object>(savedUser, HttpStatus.CREATED);
		} catch (Exception ex) {

			field += 23000;

			message += "Duplication of unique field";
//
			// }
//				}
//			}
			// }
			errors.put(field, message);
			return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

		}

	}

	//To update user
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) throws UsernameNotFoundException {
		return userDetailsService.updateUser(user);
	}

	//To get all user
	@GetMapping("/users")
	public List<User> findAllUsers() {
		return userDetailsService.getAllUser();
	}
    
	//To get user by username
	@GetMapping("/users/{username}")
	public User findByUsername() {
		return userDetailsService.getByUsername();
	}
	
	 @PostMapping("/connectcart/{userID}/{cartID}")
	    public ResponseEntity<String> connectCustomerWithShoppingCart(@PathVariable int userID,@PathVariable int cartID) {
	        try {
	        	userDetailsService.connectUserWithShoppingCart(userID, cartID);
	            return ResponseEntity.ok("User connected with ShoppingCart successfully");
	        } catch (EntityNotFoundException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
	        }
	    }
	 @PostMapping("/connectwishlist/{userID}/{wishlistID}")
	    public ResponseEntity<String> connectCustomerWithWishlist(@PathVariable int userID,@PathVariable int wishlistID) {
	        try {
	        	userDetailsService.connectUserWithWishlist(userID, wishlistID);
	            return ResponseEntity.ok("Customer connected with Wishlist successfully");
	        } catch (EntityNotFoundException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
	        }
	    }
	    @PostMapping("/addToWishlist/{userID}/{productID}/{quantity}")
	    public ResponseEntity<String> addToWishlist(@PathVariable int userID,@PathVariable int productID,@PathVariable int quantity) {

	        try {
	        	userDetailsService.addToWishlist(userID, productID, quantity);
	            return ResponseEntity.ok("Product added to the wishlist successfully");
	        } catch (EntityNotFoundException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
	        }
	    }

}
