package com.example.exceptionhandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private String desc = "Description";

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleProductException(ProductNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to find product");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());

	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<Object> handleCategoryException(CategoryNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to find Category");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());

	}
	
	@ExceptionHandler(ReviewNotFoundException.class)
	public ResponseEntity<Object> handleReviewException(ReviewNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to find Review");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());

	}
	
	@ExceptionHandler(ShoppingCartNotFoundException.class)
	public ResponseEntity<Object> handleShoppingCartException(ShoppingCartNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to find ShoppingCart");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());

	}
	
	@ExceptionHandler(DiscountNotFoundException.class)
	public ResponseEntity<Object> handleDiscountException(DiscountNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to find Discount");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());

	}
	
	@ExceptionHandler(WishlistNotFoundException.class)
	public ResponseEntity<Object> handleWishlistException(WishlistNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to find Wishlist");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());

	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<Object> handleOrderException(OrderNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to find Order");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());

	}
	
	@ExceptionHandler(UsersNotFoundException.class)
	public ResponseEntity<Object> handleUsersException(UsersNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to find Users");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());

	}
	@ExceptionHandler(GiftCardsNotFoundException.class)
	public ResponseEntity<Object> handleGiftCardsException(GiftCardsNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to find GiftCard");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());

	}
	
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<Object> handlePaymentException(PaymentNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to find Payment");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());

	}
	@ExceptionHandler(ShipmentNotFoundException.class)
	public ResponseEntity<Object> handleShipmentException(ShipmentNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to find Shipment");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());

	}
	@ExceptionHandler(ReturnNotFoundException.class)
	public ResponseEntity<Object> handleReturnException(ReturnNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to find Return");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());

	}
	


}