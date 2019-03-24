package com.ysi.shop.vo;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
public abstract class Product {
	private String name;
	private double price;

	public Product() {}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name + " " + price;
	}

}