package com.gmail.dimaliahov.controller;

import com.gmail.dimaliahov.model.Product;
import com.gmail.dimaliahov.model.User;
import com.gmail.dimaliahov.service.ProductServiceDAOImpl;
import com.gmail.dimaliahov.serviceForController.serviceInterface.AdminControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class AdminController {

	@Autowired
	private  AdminControllerService adminControllerService;

	@RequestMapping (value = "/admin", method = RequestMethod.GET)
	public String getAdmin (HttpSession session, ModelMap modelMap) {
		return adminControllerService.getAdmin(session,modelMap);
	}

	@RequestMapping (value = "/admin", method = RequestMethod.POST)
	public String postAdmin (@ModelAttribute ("Product") Product product, ModelMap modelMap, HttpSession session) {
		return adminControllerService.postAdmin(product, modelMap, session);
	}
}

