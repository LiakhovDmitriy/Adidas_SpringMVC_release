package com.gmail.dimaliahov.dao;

import com.gmail.dimaliahov.model.User;

public interface UserDAO {

	String getName (String login, String password);

	User getUser (String login, String password);

	boolean setUser (User user);

}
