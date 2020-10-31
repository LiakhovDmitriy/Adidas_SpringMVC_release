package com.gmail.dimaliahov.serviceForController.serviceInterfaceImpl;

import com.gmail.dimaliahov.model.User;
import com.gmail.dimaliahov.service.CartServiceDAOImpl;
import com.gmail.dimaliahov.service.UserServiceDAOImpl;
import com.gmail.dimaliahov.serviceForController.serviceInterface.RegistrationControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegistrationControllerServiceImpl implements RegistrationControllerService {

	@Autowired
	UserServiceDAOImpl userService;

	@Autowired
	CartServiceDAOImpl cartService;

	@Override
	public String getRegistration (ModelMap modelMap) {
		modelMap.addAttribute("User", new User());
		return "register";
	}

	@Override
	public String postRegistration (User user, HttpServletRequest request, HttpSession httpSession, ModelMap modelMap) {
		boolean showForm = true;
		boolean isError = false;
		ArrayList<String> error = new ArrayList<>();

		String login = user.getLogin();
		String password = user.getPassword();
		String name = user.getName();
		String gender = user.getGender();
		String country = user.getCountry();
		String city = user.getCity();
		String address = user.getAddress();
		String phone = user.getPhone();

		if (login != null) {
			if (login.isEmpty()) {
				error.add("The 'login' is empty.");
				isError = true;
			}
			Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcher = pattern.matcher(login);
			boolean loginBol = matcher.matches();
			if (!loginBol) {
				error.add("The 'login' is wrong. It should look like 'name@gmail.com'.");
				isError = true;
			}
			if (password.isEmpty()) {
				error.add("The 'password' is empty.");
				isError = true;
			}
			if (!password.isEmpty()) {
				Pattern patternP = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
				Matcher matcherP = patternP.matcher(password);
				boolean passwordBol = matcherP.matches();
				if (!passwordBol) {
					error.add("The 'password'at least 8 characters, contains at least one digit, contains at least one lower alpha char and one upper alpha char, no whitespace allowed in the entire string.");
					isError = true;
				}
			}
			if (name.isEmpty()) {
				error.add("The 'name' is empty.");
				isError = true;
			}
			Pattern patternN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z]).{3,}$");
			Matcher matcherN = patternN.matcher(name);
			boolean passwordName = matcherN.matches();
			if (!passwordName) {
				error.add("The 'Name' must be the correct. At least 3 characters, contains at least one lower alpha char and one upper alpha char, no whitespace allowed in the entire string");
				isError = true;
			}
			if (gender.isEmpty()) {
				error.add("The 'gender' is empty.");
				isError = true;
			}
			if (country.isEmpty()) {
				error.add("The 'country' is empty.");
				isError = true;
			}
			if (city.isEmpty()) {
				error.add("The 'City' is empty.");
				isError = true;
			}
			if (address.isEmpty()) {
				error.add("The 'address' is empty.");
				isError = true;
			}
			if (phone.isEmpty()) {
				error.add("The 'phone' is empty.");
				isError = true;
			}
			if (!isError) {
				User userPojo = new User();
				if (login != null) {
					userPojo.setName(name);
					userPojo.setLogin(login);
					userPojo.setPassword(password);
					userPojo.setGender(gender);
					userPojo.setAddress(address);
					userPojo.setCity(city);
					userPojo.setCountry(country);
					userPojo.setPhone(phone);

					userService.setUser(userPojo);
					httpSession.setAttribute("userPojo", userPojo);
				}
				request.setAttribute("login", login);
				showForm = false;
				User userChack = userService.getUser(user.getLogin(), user.getPassword());
				modelMap.addAttribute("userPojo", userChack);
				modelMap.addAttribute("countCart", cartService.getCountProductByUserId(userChack.getId()));
				return "redirect:/home";
			}
		}
		if (showForm) {
			request.setAttribute("login", login);
			request.setAttribute("password", password);
			request.setAttribute("name", name);
			request.setAttribute("gender", gender);
			request.setAttribute("address", address);
			request.setAttribute("city", city);
			request.setAttribute("country", country);
			request.setAttribute("phone", phone);
			request.setAttribute("ERROR", error);
			return "register";
		}
		return "register";
	}
}
