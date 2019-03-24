package com.ysi.shop.vo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
@Component
@Scope("prototype")
@Lazy
public class ShoppingCart {
	private List<Product> items = new ArrayList<>();

	public void addItem(Product item) {
		items.add(item);
	}

	public List<Product> getItems() {
		return items;
	}
}