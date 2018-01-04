package com.gk.shop.cart.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

import com.gk.shop.cart.domain.exception.EmptyBasketException;
import com.gk.shop.cart.domain.model.Apple;
import com.gk.shop.cart.domain.model.Orange;
import com.gk.shop.cart.domain.model.Product;
import com.gk.shop.cart.domain.model.Receipt;
import com.gk.shop.cart.domain.model.ReceiptEntry;

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
		Product[] products = { new Apple(0.60), new Apple(0.60), new Orange(0.25), new Apple(0.60), new Orange(0.25) };
		CheckoutHandler checkoutHandler = new CheckoutHandler(Arrays.asList(products));
		double totalCost = checkoutHandler.doCheckout();
		assertTrue(totalCost == 2.30);
	}

	@Test
	public void doCheckOutWithDiscount() {
		Product[] products = { new Apple(0.60), new Apple(0.60), new Orange(0.25), new Apple(0.60), new Orange(0.25),new Orange(0.25),new Orange(0.25) };
		CheckoutHandler checkoutHandler = new CheckoutHandler(Arrays.asList(products));
		Receipt receipt = checkoutHandler.doCheckOutWithDiscount();
		
		assertNotNull(receipt);
		assertTrue(receipt.entriesCount() == 2);
		
		ReceiptEntry appleEntry = receipt.getEntry(0);
		ReceiptEntry OrangeEntry = receipt.getEntry(1);
		
		assertTrue(1.8 == appleEntry.getActualPrice());
		assertTrue(1.2 == appleEntry.getDiscountedPrice());
		
		assertTrue(1.0 == OrangeEntry.getActualPrice());
		assertTrue(0.75 == OrangeEntry.getDiscountedPrice());

	}
}
