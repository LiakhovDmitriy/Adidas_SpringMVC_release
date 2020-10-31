package com.gmail.dimaliahov.service;

import com.gmail.dimaliahov.dao.CartDAO;
import com.gmail.dimaliahov.model.Product;
import com.gmail.dimaliahov.model.ProductIdAndCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceDAOImpl implements CartServiceDAO {

	@Autowired
	CartDAO cartDAO;

	@Override
	public void addProductToCart (int userId, int productId, int amount) {
		cartDAO.addProductToCart(userId, productId, amount);
	}

	@Override
	public void removeProductFromCartById (int userId, int productId) {
		cartDAO.removeProductFromCartById(userId, productId);
	}

	@Override
	public int getCountProductByUserId (int userId) {
		return cartDAO.getCountProductByUserId(userId);
	}

	@Override
	public List<ProductIdAndCount> getProductsAndCount (int userId) {
		return cartDAO.getProductsAndCount(userId);
	}

	@Override
	public void changeCountOnProduct (int userId, int productId, int count) {
		cartDAO.changeCountOnProduct(userId, productId, count);
	}

	@Override
	public Product getProductByProductIdAndUserId (int userId, int productId) {
		return cartDAO.getProductByProductIdAndUserId(userId, productId);
	}
}
