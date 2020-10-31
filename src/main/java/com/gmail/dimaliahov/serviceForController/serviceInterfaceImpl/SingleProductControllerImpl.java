package com.gmail.dimaliahov.serviceForController.serviceInterfaceImpl;

import com.gmail.dimaliahov.model.Product;
import com.gmail.dimaliahov.service.ProductServiceDAOImpl;
import com.gmail.dimaliahov.serviceForController.serviceInterface.SingleProductControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class SingleProductControllerImpl implements SingleProductControllerService {

	@Autowired
	ProductServiceDAOImpl productService;

	@Override
	public String printHello (String idProduct, ModelMap modelMap) {
		Product product = productService.getProductById(Integer.parseInt(idProduct));
		List<Product> productList = productService.getProducts();
		modelMap.addAttribute(product);
		modelMap.addAttribute(productList);
		return "single";
	}
}
