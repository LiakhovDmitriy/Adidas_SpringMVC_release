package com.gmail.dimaliahov.service;

import com.gmail.dimaliahov.model.Product;
import com.gmail.dimaliahov.model.ProductIdAndCount;

import java.util.List;

public interface CartServiceDAO {

	void addProductToCart (int userId, int productId, int amount);

	void removeProductFromCartById (int userId, int productId);

	int getCountProductByUserId (int userId);

	List<ProductIdAndCount> getProductsAndCount (int userId);

	void changeCountOnProduct (int userId, int productId, int count);

	Product getProductByProductIdAndUserId (int userId, int productId);


}
