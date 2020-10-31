package com.gmail.dimaliahov.service;

import com.gmail.dimaliahov.model.Product;

import java.util.List;

public interface ProductServiceDAO {

	List<Product> getProductsByCategoryId (String id);

	List<Product> getProducts ();

	Product getProductById (int id);

	void setProduct (Product product);

	int getCountAll ();

}
