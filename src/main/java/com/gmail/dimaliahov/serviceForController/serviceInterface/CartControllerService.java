package com.gmail.dimaliahov.serviceForController.serviceInterface;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

public interface CartControllerService {

	String getCart (HttpSession session);

	String postCart (HttpSession session, String removeStr, String productId, String amount);


}
