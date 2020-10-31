package com.gmail.dimaliahov.serviceForController.serviceInterfaceImpl;

import com.gmail.dimaliahov.model.Product;
import com.gmail.dimaliahov.service.ProductServiceDAOImpl;
import com.gmail.dimaliahov.serviceForController.serviceInterface.AllProductControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AllProductControllerServiceImpl implements AllProductControllerService {

	@Autowired
	ProductServiceDAOImpl productService;

	@Override
	public String getCatalog (String categoryId, HttpServletRequest httpServletRequest) {
		List<Product> products;
		if (categoryId.equals("test")) {
			products = productService.getProducts();
		} else {
			products = productService.getProductsByCategoryId(categoryId);
		}
		int c = productService.getCountAll();
		httpServletRequest.getSession().setAttribute("prodList", products);
		httpServletRequest.getSession().setAttribute("count", c);

		return "shop";
	}
}
