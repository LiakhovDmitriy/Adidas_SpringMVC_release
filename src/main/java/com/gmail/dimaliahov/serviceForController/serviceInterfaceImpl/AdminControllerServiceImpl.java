package com.gmail.dimaliahov.serviceForController.serviceInterfaceImpl;

import com.gmail.dimaliahov.model.Product;
import com.gmail.dimaliahov.model.User;
import com.gmail.dimaliahov.service.ProductServiceDAOImpl;
import com.gmail.dimaliahov.serviceForController.serviceInterface.AdminControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Service

public class AdminControllerServiceImpl implements AdminControllerService {

	@Autowired
	ProductServiceDAOImpl productService;

	@Override
	public String getAdmin (HttpSession session, ModelMap modelMap) {
		User user = (User) session.getAttribute("userPojo");
		if (user == null) {
			return "redirect:/home";
		}
		String userRole = user.getRole();
		if (!userRole.equals("admin")) {
			return "redirect:/home";
		}
		modelMap.addAttribute("Product", new Product());
		return "admin";
	}

	@Override
	public String postAdmin (Product product, ModelMap modelMap, HttpSession session) {
		User user = (User) session.getAttribute("userPojo");
		if (user == null) {
			return "redirect:/home";
		}
		String userRole = user.getRole();
		if (!userRole.equals("admin")) {
			return "redirect:/home";
		}
		boolean showForm = true;
		boolean isError = false;

		ArrayList<String> error = new ArrayList<>();

		if (product.getName() != null) {
			if (product.getName().isEmpty()) {
				error.add("The 'name' is empty.");
				isError = true;
			}
			if (product.getPrice() == 0) {
				error.add("The 'price' is empty.");
				isError = true;
			}
			if (product.getCategoryID() == 0) {
				error.add("The 'categoryID' is empty.");
				isError = true;
			}
			if (product.getRating() == 0) {
				error.add("The 'rating' is empty.");
				isError = true;
			}
			if (product.getDescription().isEmpty()) {
				error.add("The 'description' is empty.");
				isError = true;
			}
			if (product.getShortDescription().isEmpty()) {
				error.add("The 'shortDescription' is empty.");
				isError = true;
			}
			if (!isError) {
				Product productAdd = new Product();
				productAdd.setName(product.getName());
				productAdd.setPrice(product.getPrice());
				productAdd.setCategoryID(product.getCategoryID());
				productAdd.setRating(product.getRating());
				productAdd.setDescription(product.getDescription());
				productAdd.setShortDescription(product.getShortDescription());
				productAdd.setDiscount(product.getDiscount());
				productService.setProduct(product);
				showForm = false;
				return "redirect:/shop";
			}
		}
		modelMap.addAttribute("name", product.getName());
		modelMap.addAttribute("price", product.getPrice());
		modelMap.addAttribute("categoryID", product.getCategoryID());
		modelMap.addAttribute("rating", product.getRating());
		modelMap.addAttribute("description", product.getDescription());
		modelMap.addAttribute("shortDescription", product.getShortDescription());
		modelMap.addAttribute("discount", product.getDiscount());
		modelMap.addAttribute("ERROR", error);
		return "admin";
	}
}
