package com.example.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.service.Impl.MyUserDetailService;

//Annotations
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppSecurityConfig {
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailService();
	}

//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
//			throws Exception {
//		return authenticationConfiguration.getAuthenticationManager();
//	}

	//To Convert Password Encrypted Form
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	//To Take Password and give it UserDetailService
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;

	}

	//To Authenticate password
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	//Method for Giving Access who can access What
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeHttpRequests().requestMatchers("/users/**").permitAll().and()
//				.authorizeHttpRequests().requestMatchers("/students/**").hasAnyAuthority("Admin")
//				.authenticated().and().authorizeHttpRequests()
//				.requestMatchers("/teachers/**").authenticated().and().formLogin().and().httpBasic();

		http.csrf().disable().authorizeHttpRequests().requestMatchers("/users/**").permitAll().and()
				.authorizeHttpRequests()
				.requestMatchers(HttpMethod.POST, "/connectcart/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/categories/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.GET, "/categories/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.PUT, "/categories/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/categories/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.GET, "/category/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.POST, "/products/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.GET, "/products/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.PUT, "/products/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.GET, "/product/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.DELETE, "/products/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/orders/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/order/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.GET, "/orders/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.GET, "/order/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.DELETE, "/orders/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/discount/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.GET, "/discount/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.PUT, "/discount/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.GET, "/discounts/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.DELETE, "/discount/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/giftCards/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.GET, "/giftCards/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.DELETE, "/giftCards/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/payments/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.GET, "/payments/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/payments/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/returns/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.GET, "/returns/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.DELETE, "returns/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/reviews/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.GET, "/reviews/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.GET, "/review/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.DELETE, "/reviews/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/shipment/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.GET, "/shipment/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/shipment/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/shoppingCart/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/addToCart/**").hasAnyAuthority("ROLE_USER")
				.requestMatchers(HttpMethod.GET, "/shoppingCart/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/shoppingCart/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/wishlist/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.GET, "/wishlist/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.GET, "/wishlists/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/wishlist/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/connectwishlist/**").hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.POST, "/addToWishlist/**").hasAnyAuthority("ROLE_USER")
				.anyRequest()
				.authenticated().and().formLogin().permitAll().and().httpBasic();

		return http.build();
	}
}
