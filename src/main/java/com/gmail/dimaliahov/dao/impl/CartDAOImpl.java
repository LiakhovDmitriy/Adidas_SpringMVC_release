package com.gmail.dimaliahov.dao.impl;

import com.gmail.dimaliahov.dao.CartDAO;
import com.gmail.dimaliahov.model.Product;
import com.gmail.dimaliahov.model.ProductIdAndCount;
import com.gmail.dimaliahov.service.ProductServiceDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements CartDAO {

	private final static String GET_PRODUCTS_BY_USER_ID = "SELECT * FROM shoppingcart WHERE userId = ?;";
	private final static String GET_PRODUCTS_BY_PRODUCT_ID = "SELECT * FROM shoppingcart WHERE userId = ? AND productId = ?;";
	private final static String SET_PRODUCT_TO_CART = "INSERT INTO shoppingcart (userId, productId, count) VALUES (?, ?, ?);";
	private final static String SET_COUNT_ON_PRODUCT = "UPDATE shoppingcart SET count = ? WHERE userId = ? AND productId = ?;";
	private final static String REMOVE_PRODUCT_TO_CART = "DELETE FROM shoppingcart WHERE userId = ? AND productId = ? LIMIT 1;";
	@Autowired
	ProductServiceDAOImpl productService;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public CartDAOImpl (DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@PostConstruct
	public void init () {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addProductToCart (int userId, int productId, int amount) {

		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		try (PreparedStatement ps = con.prepareStatement(SET_PRODUCT_TO_CART)) {
			ps.setString(1, String.valueOf(userId));
			ps.setString(2, String.valueOf(productId));
			ps.setString(3, String.valueOf(amount));
			int rows = ps.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Product> getProductsByUserId (int userId) {

		List<Product> products = new ArrayList<Product>();

		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		try (PreparedStatement ps = con.prepareStatement(GET_PRODUCTS_BY_USER_ID)) {
			ps.setString(1, String.valueOf(userId));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("productId");


				Product product = productService.getProductById(id);
				products.add(product);
			}

			rs.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return products;

	}

	@Override
	public boolean removeProductFromCartById (int userId, int productId) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		try (PreparedStatement ps = con.prepareStatement(REMOVE_PRODUCT_TO_CART)) {
			ps.setString(1, String.valueOf(userId));
			ps.setString(2, String.valueOf(productId));
			int rows = ps.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean removeAllProductFromUser (int userId) {
		return false;
	}

	@Override
	public int getCountProductByUserId (int userId) {
		List<Product> products = new ArrayList<Product>();

		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		try (PreparedStatement ps = con.prepareStatement(GET_PRODUCTS_BY_USER_ID)) {
			ps.setString(1, String.valueOf(userId));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("productId");

				Product product = productService.getProductById(id);
				products.add(product);
			}

			rs.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return products.size();
	}

	@Override
	public List<ProductIdAndCount> getProductsAndCount (int userId) {
		List<ProductIdAndCount> list = new ArrayList<>();

		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		try (PreparedStatement ps = con.prepareStatement(GET_PRODUCTS_BY_USER_ID)) {
			ps.setString(1, String.valueOf(userId));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("productId");
				int count = rs.getInt("count");

				ProductIdAndCount prod = new ProductIdAndCount(id, count);
				list.add(prod);
			}

			rs.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean changeCountOnProduct (int userId, int productId, int count) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		try (PreparedStatement ps = con.prepareStatement(SET_COUNT_ON_PRODUCT)) {
			ps.setString(1, String.valueOf(count));
			ps.setString(2, String.valueOf(userId));
			ps.setString(3, String.valueOf(productId));
			int rows = ps.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public Product getProductByProductIdAndUserId (int userId, int productId) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		Product p = new Product();
		try (PreparedStatement ps = con.prepareStatement(GET_PRODUCTS_BY_PRODUCT_ID)) {
			ps.setString(1, String.valueOf(userId));
			ps.setString(2, String.valueOf(productId));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {


				p = productService.getProductById(rs.getInt("productId"));

			}

			rs.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return p;
	}
}
