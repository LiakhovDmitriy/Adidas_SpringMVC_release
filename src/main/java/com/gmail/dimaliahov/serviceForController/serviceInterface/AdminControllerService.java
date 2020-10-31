package com.gmail.dimaliahov.serviceForController.serviceInterface;

import com.gmail.dimaliahov.model.Product;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

public interface AdminControllerService {

	String getAdmin (HttpSession session, ModelMap modelMap);
	
	String postAdmin (Product product, ModelMap modelMap, HttpSession session);
}
