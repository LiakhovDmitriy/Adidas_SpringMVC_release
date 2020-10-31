package com.gmail.dimaliahov.service;

import com.gmail.dimaliahov.dao.UserDAO;
import com.gmail.dimaliahov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDAOImpl implements UserServiceDAO {

	@Autowired
	UserDAO userDAO;

	@Override
	public String getName (String login, String password) {
		return userDAO.getName(login, password);
	}

	@Override
	public User getUser (String login, String password) {
		return userDAO.getUser(login, password);
	}

	@Override
	public boolean setUser (User user) {
		return userDAO.setUser(user);
	}
}
