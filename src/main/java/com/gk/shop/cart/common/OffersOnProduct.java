package com.gk.shop.cart.common;

public class OffersOnProduct {

	private final int buyQuantity;
	private final int getQuantity;

	public OffersOnProduct(int buyQuantity, int getQuantity) {
		this.buyQuantity = buyQuantity;
		this.getQuantity = getQuantity;
	}

	public int getBuyQuantity() {
		return buyQuantity;
	}

	public int getGetQuantity() {
		return getQuantity;
	}
}
