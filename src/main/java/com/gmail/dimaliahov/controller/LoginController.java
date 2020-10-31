package com.gmail.dimaliahov.controller;

import com.gmail.dimaliahov.model.User;
import com.gmail.dimaliahov.serviceForController.serviceInterface.LoginControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;


@Controller
@RequestMapping ("/login")
@SessionAttributes (value = {"userPojo", "countCart", "login", "password"})
public class LoginController {

	@Autowired
	LoginControllerService loginControllerService;

	@RequestMapping (method = RequestMethod.GET)
	public String getLoginPage (ModelMap modelMap,
								WebRequest request,
								@RequestParam (value = "logout", defaultValue = "test") String logout,
								SessionStatus status) {
		return loginControllerService.getLoginPage(modelMap, request, logout, status);
	}

	@RequestMapping (method = RequestMethod.POST)
	public String postLogin (@ModelAttribute ("User") User user,
							 ModelMap modelMap) {
		return loginControllerService.postLogin(user, modelMap);
	}
}

