package com.gk.shop.cart.domain;

import java.util.List;

import com.gk.shop.cart.domain.exception.EmptyBasketException;
import com.gk.shop.cart.domain.model.Product;

public class CheckoutHandler {

	private final List<Product> basket;

	public CheckoutHandler(List<Product> basket) {
		this.basket = basket;
	}

	public double doCheckout() {
		if (basket == null || basket.isEmpty())
			throw new EmptyBasketException("Basket empty please proceed to exit");

		return basket.stream().mapToDouble(product -> product.getPrice()).sum();
	}

}
