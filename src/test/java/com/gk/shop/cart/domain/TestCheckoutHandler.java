package com.gk.shop.cart.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.gk.shop.cart.domain.exception.EmptyBasketException;
import com.gk.shop.cart.domain.model.Apple;
import com.gk.shop.cart.domain.model.Orange;
import com.gk.shop.cart.domain.model.Product;

public class TestCheckoutHandler {

	@Test(expected = EmptyBasketException.class)
	public void shouldNotBeAbleToCheckoutWithNullCart() {
		CheckoutHandler checkoutHandler = new CheckoutHandler(null);
		checkoutHandler.doCheckout();
	}

	@Test(expected = EmptyBasketException.class)
	public void shouldNotBeAbleToCheckoutWithAnEmptyCart() {
		List<Product> products = new ArrayList<>();
		CheckoutHandler checkoutHandler = new CheckoutHandler(products);
		checkoutHandler.doCheckout();
	}

	@Test
	public void totalCostOfAllProductsShouldBeCalcuatedOnCheckout() {
		Product[] products = { new Apple(0.60), new Apple(0.60), new Orange(0.25), new Apple(0.60),new Orange(0.25) };
		CheckoutHandler checkoutHandler = new CheckoutHandler(Arrays.asList(products));
		double totalCost = checkoutHandler.doCheckout();
		Assert.assertTrue(totalCost == 2.30);
	}

}
