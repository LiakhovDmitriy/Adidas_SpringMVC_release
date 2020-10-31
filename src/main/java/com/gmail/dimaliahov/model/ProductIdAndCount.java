package com.gmail.dimaliahov.model;

public class ProductIdAndCount {

	private int productId;
	private int count;

	public ProductIdAndCount (int productId, int count) {
		this.productId = productId;
		this.count = count;
	}

	public ProductIdAndCount () {
	}

	public int getProductId () {
		return productId;
	}

	public void setProductId (int productId) {
		this.productId = productId;
	}

	public int getCount () {
		return count;
	}

	public void setCount (int count) {
		this.count = count;
	}

	@Override
	public String toString () {
		return "ProductIdAndCount{" +
				"productId=" + productId +
				", count=" + count +
				'}';
	}
}
