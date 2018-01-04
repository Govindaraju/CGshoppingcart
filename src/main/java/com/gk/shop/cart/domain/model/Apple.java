package com.gk.shop.cart.domain.model;

import com.gk.shop.cart.common.ProductMaster;

public final class Apple extends Product {

	public Apple(double price) {
		super(ProductMaster.APPLE.code(), price);
	}

}
