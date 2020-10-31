package com.gmail.dimaliahov.service;

import com.gmail.dimaliahov.dao.ProductDAO;
import com.gmail.dimaliahov.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceDAOImpl implements ProductServiceDAO {

	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Product> getProductsByCategoryId (String id) {
		return productDAO.getProductsByCategoryId(id);
	}

	@Override
	public List<Product> getProducts () {
		return productDAO.getProducts();
	}

	@Override
	public Product getProductById (int id) {
		return productDAO.getProductById(id);
	}

	@Override
	public void setProduct (Product product) {
		productDAO.setProduct(product);
	}

	@Override
	public int getCountAll () {
		return productDAO.getCountAll();
	}
}
