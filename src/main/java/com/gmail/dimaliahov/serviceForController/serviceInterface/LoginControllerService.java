package com.gmail.dimaliahov.serviceForController.serviceInterface;

import com.gmail.dimaliahov.model.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

public interface LoginControllerService {

	String getLoginPage (ModelMap modelMap, WebRequest request, String logout, SessionStatus status);

	String postLogin (User user, ModelMap modelMap);
}
