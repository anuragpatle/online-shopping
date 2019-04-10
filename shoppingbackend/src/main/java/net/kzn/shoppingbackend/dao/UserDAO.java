package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

public interface UserDAO {

	// user related operation
	User getByEmail(String email);
	User get(int id);

	boolean updateCart(Cart cart);
	
	boolean add(User user);
	
	// adding and updating a new address
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	
	
	/* Commenting these methods because passing user object
	 * creates an additional select user query. So, it's better to
	 * pass user_id.
	 * 
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);*/
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	

	
}