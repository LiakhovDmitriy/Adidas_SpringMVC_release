package com.gmail.dimaliahov.controller;

import com.gmail.dimaliahov.serviceForController.serviceInterface.CartControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	private CartControllerService cartControllerService;

	@RequestMapping (value = "/cart", method = RequestMethod.GET)
	public String getCart (HttpSession session) {
		return cartControllerService.getCart(session);
	}


	@RequestMapping (value = "/cart", method = RequestMethod.POST)
	public String postCart (HttpSession session,
							@RequestParam (value = "removeId", defaultValue = "test") String removeStr,
							@RequestParam (value = "idProduct", defaultValue = "test") String productId,
							@RequestParam (value = "amount", defaultValue = "test") String amount
	) {
		return cartControllerService.postCart(session, removeStr, productId, amount);
	}


}
