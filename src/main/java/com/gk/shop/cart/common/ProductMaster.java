package com.gk.shop.cart.common;

public enum ProductMaster {

	APPLE("apple"), ORANGE("orange");

	private final String code;

	ProductMaster(String value) {
		this.code = value;
	}

	public String code() {
		return code;
	}
}
