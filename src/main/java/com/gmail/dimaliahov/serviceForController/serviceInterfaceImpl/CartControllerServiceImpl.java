package com.gmail.dimaliahov.serviceForController.serviceInterfaceImpl;

import com.gmail.dimaliahov.model.Product;
import com.gmail.dimaliahov.model.ProductIdAndCount;
import com.gmail.dimaliahov.model.User;
import com.gmail.dimaliahov.service.CartServiceDAOImpl;
import com.gmail.dimaliahov.service.ProductServiceDAOImpl;
import com.gmail.dimaliahov.serviceForController.serviceInterface.CartControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartControllerServiceImpl implements CartControllerService {

	@Autowired
	CartServiceDAOImpl cartService;

	@Autowired
	ProductServiceDAOImpl productService;

	@Override
	public String getCart (HttpSession session) {
		User user = (User) session.getAttribute("userPojo");
		int userId = -1;
		userId = user.getId();

		List<ProductIdAndCount> productCount = cartService.getProductsAndCount(userId);
		List<Product> products = new ArrayList<>();
		for (ProductIdAndCount productIdAndCount : productCount) {
			Product p;
			p = productService.getProductById(productIdAndCount.getProductId());
			p.setCount(productIdAndCount.getCount());
			products.add(p);
		}

		session.setAttribute("countCart", cartService.getCountProductByUserId(userId));
		session.setAttribute("cartProduct", products);
		return "shoppingCart";
	}

	@Override
	public String postCart (HttpSession session, String removeStr, String productId, String amount) {
		User user = (User) session.getAttribute("userPojo");
		int userId = user.getId();

		if (!removeStr.equals("test")) {
			int removeId = Integer.parseInt(removeStr);
			cartService.removeProductFromCartById(userId, removeId);
			session.setAttribute("countCart", cartService.getCountProductByUserId(userId));
			return "redirect:/cart";
		}
		if (!productId.equals("test")) {
			List<Product> products = (List<Product>) session.getAttribute("cartProduct");
			Product p = cartService.getProductByProductIdAndUserId(userId, Integer.parseInt(productId));
			if (p.getId() == 0) {
				cartService.addProductToCart(userId, Integer.parseInt(productId), Integer.parseInt(amount));
			}
			for (Product product : products) {
				p = product;
				int id = p.getId();
				if (Integer.parseInt(productId) == id) {
					cartService.changeCountOnProduct(userId, Integer.parseInt(productId), Integer.parseInt(amount));
					if (Integer.parseInt(amount) <= 0) {
						cartService.removeProductFromCartById(userId, Integer.parseInt(productId));
					}
					break;
				}
			}
			session.setAttribute("countCart", cartService.getCountProductByUserId(userId));
			return "redirect:/cart";
		}
		return "redirect:/cart";
	}
}
