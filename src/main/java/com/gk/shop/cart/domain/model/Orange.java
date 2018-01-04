package com.gk.shop.cart.domain.model;

import com.gk.shop.cart.common.ProductMaster;

public class Orange extends Product {

	public Orange(double price) {
		super(ProductMaster.ORANGE.code(), price);
	}
}
