package com.gmail.dimaliahov.controller;

import com.gmail.dimaliahov.model.User;
import com.gmail.dimaliahov.serviceForController.serviceInterface.RegistrationControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes (value = {"userPojo", "countCart", "login", "password"})
public class RegistrationController {

	@Autowired
	RegistrationControllerService registrationControllerService;

	@RequestMapping (value = "/registration", method = RequestMethod.GET)
	public String getRegistration (ModelMap modelMap) {
		return registrationControllerService.getRegistration(modelMap);
	}

	@RequestMapping (value = "/registration", method = RequestMethod.POST)
	public String postRegistration (@ModelAttribute ("User") User user,
									HttpServletRequest request,
									HttpSession httpSession,
									ModelMap modelMap
	) {
		return registrationControllerService.postRegistration(user, request, httpSession, modelMap);
	}
}
