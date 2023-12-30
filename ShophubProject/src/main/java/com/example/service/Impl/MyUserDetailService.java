package com.example.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.Products;
import com.example.entity.ShoppingCart;
import com.example.entity.User;
import com.example.entity.Wishlist;
import com.example.entity.WishlistItem;
import com.example.repository.ProductsRepository;
import com.example.repository.ShoppingCartRepository;
import com.example.repository.UserRepository;
import com.example.repository.WishlistRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
    
	@Autowired
	WishlistRepository wishlisttRepository;
	
	@Autowired
	ProductsRepository productRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		// return user.map(UserPrincipal::new).orElseThrow(() -> new
		// UsernameNotFoundException("user not found"));
		if (user == null)
			throw new UsernameNotFoundException("User 403");
		return new UserPrincipal(user);

	}

	public User addUser(User user) {
		// TODO Auto-generated method stub

		return userRepository.save(user);
	}

	public User getByUsername() {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(null);
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public User updateUser(User user) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		Optional<User> optional = userRepository.findById((int) user.getUserID());

		if (optional.isPresent()) {
			User _user = userRepository.findById(user.getUserID()).get();
			_user.setUsername(user.getUsername());
			_user.setPassword(user.getPassword());
			_user.setEmail(user.getEmail());
			_user.setRoles(user.getRoles());
			_user.setFname(user.getFname());
			_user.setLname(user.getLname());
			_user.setPhoneNumber(user.getPhoneNumber());
			_user.setAddress(user.getAddress());

			return userRepository.save(_user);
		} else {
			throw new UsernameNotFoundException("User not found with the matching ID!");
		}

		// return optional.get();
	}
	 @Transactional
	    public void connectUserWithShoppingCart(int userID, int CartID) {
	        // Retrieve the Customer and ShoppingCart entities from the database
	        User user = userRepository.findById(userID).orElseThrow(() -> new EntityNotFoundException("Customer not found"));

	        ShoppingCart shoppingCart = shoppingCartRepository.findById(CartID).orElseThrow(() -> new EntityNotFoundException("ShoppingCart not found"));

	        // Establish the one-to-one relationship
	        user.setShoppingCart(shoppingCart);
	        shoppingCart.setUser(user);

	        // Save the changes
	        userRepository.save(user);
	        shoppingCartRepository.save(shoppingCart);
	    }
   
	 @Transactional
	    public void connectUserWithWishlist(int userID, int wishlistID) {
	        // Retrieve the Customer and ShoppingCart entities from the database
	       User user = userRepository.findById(userID).orElseThrow(() -> new EntityNotFoundException("Customer not found"));

	        Wishlist wishlist = wishlisttRepository.findById(wishlistID).orElseThrow(() -> new EntityNotFoundException("Wishlist not found"));

	        // Establish the one-to-one relationship
	       user.setWishlist(wishlist);
	        wishlist.setUser(user);

	        // Save the changes
	        userRepository.save(user);
	        wishlisttRepository.save(wishlist);
	    }

	 @Transactional
	    public void addToWishlist(int userID, int productID, int quantity) {
	        User user = userRepository.findById(userID)
	                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

	        Products products = productRepository.findById(productID)
	                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

	        Wishlist wishlist = user.getWishlist();
	        if (wishlist == null) {
	            wishlist = new Wishlist();
	            wishlist.setUser(user);;
	            user.setWishlist(wishlist);
	        }

	        WishlistItem wishlistItem = new WishlistItem();
	        wishlistItem.setWishlist(wishlist);
	        wishlistItem.setProducts(products);;
	        wishlistItem.setQuantity(quantity);

	        wishlist.getWishlistItems().add(wishlistItem);

	        userRepository.save(user);
	  }

}
