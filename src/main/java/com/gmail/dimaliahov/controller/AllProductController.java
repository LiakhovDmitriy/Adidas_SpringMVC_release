package com.gmail.dimaliahov.controller;

import com.gmail.dimaliahov.serviceForController.serviceInterface.AllProductControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AllProductController {

	@Autowired
	private AllProductControllerService allProductControllerService;

	@RequestMapping (value = "/shop", method = RequestMethod.GET)
	public String getCatalog (@RequestParam (value = "categoryId", defaultValue = "test") String categoryId, HttpServletRequest httpServletRequest
	) {
		return allProductControllerService.getCatalog(categoryId, httpServletRequest);
	}


}
