package com.gmail.dimaliahov.serviceForController.serviceInterfaceImpl;

import com.gmail.dimaliahov.model.Product;
import com.gmail.dimaliahov.service.ProductServiceDAOImpl;
import com.gmail.dimaliahov.serviceForController.serviceInterface.HomeControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeControllerServiceImpl implements HomeControllerService {

	@Autowired
	ProductServiceDAOImpl productService;

	@Override
	public String printHello (ModelMap model) {
		List<Product> productList = productService.getProducts();
		List<Product> productListHomeP = new ArrayList<Product>();
		for (int i = 0; i < productList.size(); i++) {
			Product p = productList.get(i);
			productListHomeP.add(p);
			if (i == 5) {
				break;
			}
		}
		model.addAttribute("productListHomeP", productListHomeP);

		return "index";
	}
}
