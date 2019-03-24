package com.ysi.shop.vo;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
public class Disc extends Product {
	private int capacity;

	public Disc() { }

	public Disc(String name, double price) {
		super(name, price);
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}