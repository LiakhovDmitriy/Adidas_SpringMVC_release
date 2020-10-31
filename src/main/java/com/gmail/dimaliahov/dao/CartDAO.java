package com.gmail.dimaliahov.dao;

import com.gmail.dimaliahov.model.Product;
import com.gmail.dimaliahov.model.ProductIdAndCount;

import java.util.List;

public interface CartDAO {

	void addProductToCart (int userId, int productId, int amount);

	List<Product> getProductsByUserId (int userId);

	boolean removeProductFromCartById (int userId, int productId);

	boolean removeAllProductFromUser (int userId);

	int getCountProductByUserId (int userId);

	List<ProductIdAndCount> getProductsAndCount (int userId);

	boolean changeCountOnProduct (int userId, int productId, int count);

	public Product getProductByProductIdAndUserId (int userId, int productId);


}
