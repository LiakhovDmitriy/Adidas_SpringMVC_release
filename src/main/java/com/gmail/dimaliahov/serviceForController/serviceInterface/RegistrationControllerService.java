package com.gmail.dimaliahov.serviceForController.serviceInterface;

import com.gmail.dimaliahov.model.User;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface RegistrationControllerService {

	String getRegistration (ModelMap modelMap);

	String postRegistration (User user, HttpServletRequest request, HttpSession httpSession, ModelMap modelMap);
}
