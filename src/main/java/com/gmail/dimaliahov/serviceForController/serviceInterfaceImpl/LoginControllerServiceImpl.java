package com.gmail.dimaliahov.serviceForController.serviceInterfaceImpl;

import com.gmail.dimaliahov.model.User;
import com.gmail.dimaliahov.service.CartServiceDAOImpl;
import com.gmail.dimaliahov.service.ProductServiceDAOImpl;
import com.gmail.dimaliahov.service.UserServiceDAOImpl;
import com.gmail.dimaliahov.serviceForController.serviceInterface.LoginControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Service
public class LoginControllerServiceImpl implements LoginControllerService {

	@Autowired
	UserServiceDAOImpl userService;

	@Autowired
	CartServiceDAOImpl cartService;

	@Autowired
	ProductServiceDAOImpl productService;

	@Override
	public String getLoginPage (ModelMap modelMap, WebRequest request, String logout, SessionStatus status) {
		if (logout.equals("logout")) {
			status.setComplete();
			request.removeAttribute("userPojo", WebRequest.SCOPE_SESSION);
			request.removeAttribute("countCart", WebRequest.SCOPE_SESSION);
			request.removeAttribute("login", WebRequest.SCOPE_SESSION);
			request.removeAttribute("password", WebRequest.SCOPE_SESSION);
			request.removeAttribute("countCart", WebRequest.SCOPE_SESSION);
			request.removeAttribute("cartProduct", WebRequest.SCOPE_SESSION);
			return "redirect:/login";
		}
		modelMap.addAttribute("User", new User());
		return "login";
	}

	@Override
	public String postLogin (User user, ModelMap modelMap) {
		StringBuilder stringBuilder = new StringBuilder();
		if (user.getLogin().isEmpty() && user.getPassword().isEmpty()) {
			stringBuilder.append("Please input value of login and password first");
			modelMap.addAttribute("error", stringBuilder);
			return "login";
		} else {
			User userChack;
			userChack = userService.getUser(user.getLogin(), user.getPassword());
			if (userChack != null) {
				modelMap.addAttribute("userPojo", userChack);
				modelMap.addAttribute("countCart", cartService.getCountProductByUserId(userChack.getId()));
			} else {
				stringBuilder.append("Wrong ");
				modelMap.addAttribute("error", stringBuilder);
				return "login";
			}
			if (userChack != null) {
				modelMap.addAttribute("login", userChack.getLogin());
				modelMap.addAttribute("password", userChack.getPassword());
				String roleAccess = user.getRole();
				modelMap.addAttribute("role", roleAccess);

				return "login";
			} else {
				modelMap.addAttribute("login", null);
				modelMap.addAttribute("password", null);
				stringBuilder.append("Access denied!");
				modelMap.addAttribute("error", stringBuilder);
				return "login";

			}
		}
	}
}
