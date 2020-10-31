package com.gmail.dimaliahov.model;

public class Product {

	private int id;
	private String name;
	private int price;
	private int categoryID;
	private int rating;
	private String description;
	private String shortDescription;
	private String bigDescription;
	private int discount;
	private String photoUrlIcon;
	private String photoUrlBig1;
	private String photoUrlBig2;
	private String photoUrlBig3;
	private String photoUrlBig4;
	private int count;


	public Product () {
	}

	public Product (int id, String name, int price, int categoryID, int rating, String description, String shortDescription, String bigDescription, int discount, String photoUrlIcon, String photoUrlBig1, String photoUrlBig2, String photoUrlBig3, String photoUrlBig4, int count) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryID = categoryID;
		this.rating = rating;
		this.description = description;
		this.shortDescription = shortDescription;
		this.bigDescription = bigDescription;
		this.discount = discount;
		this.photoUrlIcon = photoUrlIcon;
		this.photoUrlBig1 = photoUrlBig1;
		this.photoUrlBig2 = photoUrlBig2;
		this.photoUrlBig3 = photoUrlBig3;
		this.photoUrlBig4 = photoUrlBig4;
		this.count = count;
	}

	public int getCount () {
		return count;
	}

	public Product setCount (int count) {
		this.count = count;
		return this;
	}

	public String getBigDescription () {
		return bigDescription;
	}

	public Product setBigDescription (String bigDescription) {
		this.bigDescription = bigDescription;
		return this;
	}

	public int getId () {
		return id;
	}

	public Product setId (int id) {
		this.id = id;
		return this;
	}

	public String getName () {
		return name;
	}

	public Product setName (String name) {
		this.name = name;
		return this;
	}

	public int getPrice () {
		return price;
	}

	public Product setPrice (int price) {
		this.price = price;
		return this;
	}

	public int getCategoryID () {
		return categoryID;
	}

	public Product setCategoryID (int categoryID) {
		this.categoryID = categoryID;
		return this;
	}

	public int getRating () {
		return rating;
	}

	public Product setRating (int rating) {
		this.rating = rating;
		return this;
	}

	public String getDescription () {
		return description;
	}

	public Product setDescription (String description) {
		this.description = description;
		return this;
	}

	public String getShortDescription () {
		return shortDescription;
	}

	public Product setShortDescription (String shortDescription) {
		this.shortDescription = shortDescription;
		return this;
	}

	public int getDiscount () {
		return discount;
	}

	public Product setDiscount (int discount) {
		this.discount = discount;
		return this;
	}

	public String getPhotoUrlIcon () {
		return photoUrlIcon;
	}

	public Product setPhotoUrlIcon (String photoUrlIcon) {
		this.photoUrlIcon = photoUrlIcon;
		return this;
	}

	public String getPhotoUrlBig1 () {
		return photoUrlBig1;
	}

	public Product setPhotoUrlBig1 (String photoUrlBig1) {
		this.photoUrlBig1 = photoUrlBig1;
		return this;
	}

	public String getPhotoUrlBig2 () {
		return photoUrlBig2;
	}

	public Product setPhotoUrlBig2 (String photoUrlBig2) {
		this.photoUrlBig2 = photoUrlBig2;
		return this;
	}

	public String getPhotoUrlBig3 () {
		return photoUrlBig3;
	}

	public Product setPhotoUrlBig3 (String photoUrlBig3) {
		this.photoUrlBig3 = photoUrlBig3;
		return this;
	}

	public String getPhotoUrlBig4 () {
		return photoUrlBig4;
	}

	public Product setPhotoUrlBig4 (String photoUrlBig4) {
		this.photoUrlBig4 = photoUrlBig4;
		return this;
	}

	@Override
	public String toString () {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				", categoryID=" + categoryID +
				", rating=" + rating +
				", description='" + description + '\'' +
				", shortDescription='" + shortDescription + '\'' +
				", bigDescription='" + bigDescription + '\'' +
				", discount=" + discount +
				", photoUrlIcon='" + photoUrlIcon + '\'' +
				", photoUrlBig1='" + photoUrlBig1 + '\'' +
				", photoUrlBig2='" + photoUrlBig2 + '\'' +
				", photoUrlBig3='" + photoUrlBig3 + '\'' +
				", photoUrlBig4='" + photoUrlBig4 + '\'' +
				", count=" + count +
				'}';
	}
}
