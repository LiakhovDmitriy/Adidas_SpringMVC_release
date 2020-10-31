package com.gmail.dimaliahov.service;

import com.gmail.dimaliahov.model.User;

public interface UserServiceDAO {

	String getName (String login, String password);

	User getUser (String login, String password);

	boolean setUser (User user);

}
