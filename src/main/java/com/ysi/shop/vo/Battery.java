package com.ysi.shop.vo;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
public class Battery extends Product {
	private boolean rechargeble;
	private int Capacity;

	public Battery() {}

	public Battery(String name, double price) {
		super(name, price);
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public boolean isRechargeble() {
		return rechargeble;
	}

	public void setRechargeble(boolean rechargeble) {
		this.rechargeble = rechargeble;
	}
}