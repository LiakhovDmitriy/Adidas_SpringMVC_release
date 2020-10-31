package com.gmail.dimaliahov.model;

public class User {
	private int id;
	private String login;
	private String password;
	private String name;
	private String gender;
	private String country;
	private String city;
	private String address;
	private String phone;
	private String role;

	public User () {
	}

	public User (int id, String login, String password, String name, String gender, String country, String city, String address, String phone, String role) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.country = country;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.role = role;
	}

	public int getId () {
		return id;
	}

	public void setId (int id) {
		this.id = id;
	}

	public String getRole () {
		return role;
	}

	public void setRole (String role) {
		this.role = role;
	}

	public String getLogin () {
		return login;
	}

	public void setLogin (String login) {
		this.login = login;
	}

	public String getPassword () {
		return password;
	}

	public void setPassword (String password) {
		this.password = password;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getGender () {
		return gender;
	}

	public void setGender (String gender) {
		this.gender = gender;
	}

	public String getCountry () {
		return country;
	}

	public void setCountry (String country) {
		this.country = country;
	}

	public String getCity () {
		return city;
	}

	public void setCity (String city) {
		this.city = city;
	}

	public String getAddress () {
		return address;
	}

	public void setAddress (String address) {
		this.address = address;
	}

	public String getPhone () {
		return phone;
	}

	public void setPhone (String phone) {
		this.phone = phone;
	}

	@Override
	public String toString () {
		return "User{" +
				"id=" + id +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", country='" + country + '\'' +
				", city='" + city + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", role='" + role + '\'' +
				'}';
	}
}
