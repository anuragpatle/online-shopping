package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
		
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	

/*	@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		
		if(user.getRole().equals("CUSTOMER")) {
			cart = new Cart();
			// linked the cart with the user
			cart.setUser(user);
			// link the user with the cart
			user.setCart(cart);
			
			
		}
		
		// add the user
		assertEquals("Failed to add the user!", true, userDAO.add(user));	
				
	}
	
	

	// working for uni-directional
 
	@Test
	public void testAddAddress() {
		user = userDAO.getByEmail("hr@gmail.com");
		
		address = new Address();
		address.setAddressLineOne("301/B Jadoo Society, King Uncle Nagar");
		address.setAddressLineTwo("Near Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
				
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));	
		
		
		//Add second address
		address = new Address();
		address.setAddressLineOne("Godam road katangi");
		address.setAddressLineTwo("Near Post Office");
		address.setCity("Katangi");
		address.setState("MP");
		address.setCountry("India");
		address.setPostalCode("481445");
		address.setShipping(true);
				
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));	
	}
	
	
	@Test
	public void testUpdateCart() {
		user = userDAO.getByEmail("hr@gmail.com");
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(1);
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));			
	} */

	
	//You can see here here the benifits of having ManyToOne Relationship.
	@Test
	public void testGetAddress() {
		
		user = userDAO.getByEmail("hr@gmail.com");

		assertEquals("Failed to fetch list of addresses and size does not match!", 1,
				userDAO.listShippingAddresses(user.getId()).size());
		
		assertEquals("Failed to fetch the billing address and size does not match!", "Mumbai",
				userDAO.getBillingAddress(user.getId()).getCity());
		
		
	}

	
}