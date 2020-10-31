package com.gmail.dimaliahov.dao;

import com.gmail.dimaliahov.model.Product;

import java.util.List;

public interface ProductDAO {

	List<Product> getProductsByCategoryId (String id);

	List<Product> getProducts ();

	Product getProductByName (String name);

	Product getProductById (int id);

	boolean setProduct (Product product);

	int getCountAll ();


}
