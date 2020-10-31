package com.gmail.dimaliahov.controller;

import com.gmail.dimaliahov.serviceForController.serviceInterface.HomeControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	HomeControllerService homeControllerService;

	@RequestMapping (value = {"/", "/index", "/home"}, method = RequestMethod.GET)
	public String printHello (ModelMap model) {
		return homeControllerService.printHello(model);
	}
}
