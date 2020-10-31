package com.gmail.dimaliahov.dao.impl;

import com.gmail.dimaliahov.dao.UserDAO;
import com.gmail.dimaliahov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO {

	private final String SELECT_NAME_USER = "SELECT NAME FROM `user` WHERE login = ? AND password = ?;";
	private final String GET_USER = "SELECT id, name, gender, country, city, address, phone, role FROM `user` WHERE login = ? AND password = ?;";
	private final String SET_USER = "INSERT INTO user (login, password, name, gender, country, city, address, phone, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String SALT = "mWeRtY!4$5^78Jbr";
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public UserDAOImpl (DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@PostConstruct
	public void init () {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public String getName (String login, String password) {
		String name = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		try (PreparedStatement ps = con.prepareStatement(SELECT_NAME_USER);) {
			ps.setString(1, login);
			ps.setString(2, hashPass(SALT + password + SALT));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				name = rs.getString("name");
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
		return name;

	}

	@Override
	public User getUser (String login, String password) {
		User user = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		try (PreparedStatement ps = con.prepareStatement(GET_USER);) {
			ps.setString(1, login);
			ps.setString(2, hashPass(SALT + password + SALT));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setPassword(password);
				user.setLogin(login);
				user.setId(Integer.parseInt(rs.getString("id")));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setCountry(rs.getString("country"));
				user.setCity(rs.getString("city"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getString("role"));
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

		return user;
	}

	@Override
	public boolean setUser (User user) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException throwables){
			throwables.printStackTrace();
		}
		try (PreparedStatement ps = con.prepareStatement(SET_USER);) {
			System.out.println(user);
			ps.setString(1, user.getLogin());
			ps.setString(2, hashPass(SALT + user.getPassword() + SALT));
			ps.setString(3, user.getName());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getCountry());
			ps.setString(6, user.getCity());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getPhone());
			ps.setString(9, user.getRole());
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

	private String hashPass (String password) throws SQLException {
		String hash = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(StandardCharsets.UTF_8.encode(password));
			hash = String.format("%032x", new BigInteger(messageDigest.digest()));
		} catch (NoSuchAlgorithmException e){
			throw new SQLException();
		}
		return hash;
	}
}
