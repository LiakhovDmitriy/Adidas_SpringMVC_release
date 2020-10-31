package com.gmail.dimaliahov.dao.impl;

import com.gmail.dimaliahov.dao.ProductDAO;
import com.gmail.dimaliahov.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private final static String SELECT_PRODUCT_BY_NAME = "SELECT * FROM `product` WHERE name = ?;";
	private final static String SELECT_PRODUCT_BY_ID = "SELECT * FROM `product` WHERE id = ?;";
	private final static String SET_PRODUCT = "INSERT INTO product (name, price, categoryID, rating, description, bigDescription, shortDescription, discount, photoUrlIcon, photoUrlBig1, photoUrlBig2, photoUrlBig3, photoUrlBig4) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final static String GET_PRODUCTS = "SELECT * FROM PRODUCT";
	private final static String GET_COUNT = "select count(*) from product";
	private final static String GET_PRODUCTS_BY_CATEGORY = "SELECT * FROM PRODUCT WHERE categoryID = ?";


	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProductDAOImpl (DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@PostConstruct
	public void init () {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Product getProductById (int id) {

		Product product = jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_ID, new Object[] {id}, new RowMapper<Product>() {
			@Override
			public Product mapRow (ResultSet resultSet, int i) throws SQLException {
				Product prod = new Product();

				prod.setId(resultSet.getInt("id"))
						.setName(resultSet.getString("name"))
						.setPrice(resultSet.getInt("price"))
						.setCategoryID(resultSet.getInt("categoryID"))
						.setRating(resultSet.getInt("rating"))
						.setDescription(resultSet.getString("description"))
						.setShortDescription(resultSet.getString("shortDescription"))
						.setBigDescription(resultSet.getString("bigDescription"))
						.setDiscount(resultSet.getInt("discount"))
						.setPhotoUrlIcon(resultSet.getString("photoUrlIcon"))
						.setPhotoUrlBig1(resultSet.getString("photoUrlBig1"))
						.setPhotoUrlBig2(resultSet.getString("photoUrlBig2"))
						.setPhotoUrlBig3(resultSet.getString("photoUrlBig3"))
						.setPhotoUrlBig4(resultSet.getString("photoUrlBig4"))
				;
				return prod;
			}
		});
		return product;
	}

	@Override
	public ArrayList<Product> getProducts () {
		ArrayList<Product> listForReturn = new ArrayList<>();

		List<Map<String, Object>> products = jdbcTemplate.queryForList(GET_PRODUCTS);
		for (Map row : products) {
			Product product = new Product();
			product.setId((Integer) (row.get("id")));
			product.setName((String) (row.get("name")));
			product.setPrice((Integer) (row.get("price")));
			product.setCategoryID((Integer) (row.get("categoryID")));
			product.setRating((Integer) (row.get("rating")));
			product.setDescription((String) (row.get("description")));
			product.setBigDescription((String) (row.get("bigDescription")));
			product.setShortDescription((String) (row.get("shortDescription")));
			product.setDiscount((Integer) (row.get("discount")));
			product.setPhotoUrlIcon((String) (row.get("photoUrlIcon")));
			product.setPhotoUrlBig1((String) (row.get("photoUrlBig1")));
			product.setPhotoUrlBig2((String) (row.get("photoUrlBig2")));
			product.setPhotoUrlBig3((String) (row.get("photoUrlBig3")));
			product.setPhotoUrlBig4((String) (row.get("photoUrlBig4")));
			listForReturn.add(product);
		}
		return listForReturn;
	}

	@Override
	public List<Product> getProductsByCategoryId (String id) {
		List<Product> products = new ArrayList<Product>();
		Connection con = null;
		try {
			con = dataSource.getConnection();

		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		try (PreparedStatement ps = con.prepareStatement(GET_PRODUCTS_BY_CATEGORY)) {
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product()
						.setId(rs.getInt("id"))
						.setName(rs.getString("name"))
						.setPrice(rs.getInt("price"))
						.setCategoryID(rs.getInt("categoryID"))
						.setRating(rs.getInt("rating"))
						.setDescription(rs.getString("description"))
						.setBigDescription(rs.getString("bigDescription"))
						.setShortDescription(rs.getString("shortDescription"))
						.setDiscount(rs.getInt("discount"))
						.setPhotoUrlIcon(rs.getString("photoUrlIcon"))
						.setPhotoUrlBig1(rs.getString("photoUrlBig1"))
						.setPhotoUrlBig2(rs.getString("photoUrlBig2"))
						.setPhotoUrlBig3(rs.getString("photoUrlBig3"))
						.setPhotoUrlBig4(rs.getString("photoUrlBig4"));
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
	public Product getProductByName (String name) {
		Product product = new Product();
		product.setName(name);
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		try (PreparedStatement ps = con.prepareStatement(SELECT_PRODUCT_BY_NAME);) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				product.setPrice(rs.getInt("price"));
				product.setCategoryID(rs.getInt("categoryID"));
				product.setRating(rs.getInt("rating"));
				product.setDescription(rs.getString("description"));
				product.setBigDescription(rs.getString("bigDescription"));
				product.setShortDescription(rs.getString("shortDescription"));
				product.setDiscount(rs.getInt("discount"));
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
		return product;
	}

	@Override
	public boolean setProduct (Product product) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		try (PreparedStatement ps = con.prepareStatement(SET_PRODUCT)) {
			System.out.println(product);
			ps.setString(1, product.getName());
			ps.setString(2, String.valueOf(product.getPrice()));
			ps.setString(3, String.valueOf(product.getCategoryID()));
			ps.setString(4, String.valueOf(product.getRating()));
			ps.setString(5, product.getDescription());
			ps.setString(6, product.getBigDescription());
			ps.setString(7, product.getShortDescription());
			ps.setString(8, String.valueOf(product.getDiscount()));
			ps.setString(9, product.getPhotoUrlIcon());
			ps.setString(10, product.getPhotoUrlBig1());
			ps.setString(11, product.getPhotoUrlBig2());
			ps.setString(12, product.getPhotoUrlBig3());
			ps.setString(13, product.getPhotoUrlBig4());
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
	public int getCountAll () {
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		int count = 0;
		try (Statement s = con.createStatement();) {

			ResultSet rs = s.executeQuery(GET_COUNT);
			rs.next();
			count = rs.getInt(1);
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
		return count;
	}


}
