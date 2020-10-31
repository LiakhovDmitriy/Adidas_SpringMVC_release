package com.gmail.dimaliahov.controller;

import com.gmail.dimaliahov.serviceForController.serviceInterface.SingleProductControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;

@Controller
public class SingleProductController extends HttpServlet {

	@Autowired
	SingleProductControllerService singleProductControllerService;

	@RequestMapping (value = "/singleproduct", method = RequestMethod.GET)
	public String printHello (
			@ModelAttribute ("idProduct") String idProduct,
			ModelMap modelMap
	) {
		return singleProductControllerService.printHello(idProduct, modelMap);
	}


}
