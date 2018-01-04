package com.gk.shop.cart.domain.model;

public class ReceiptEntry {

	private String produceCode;
	private int quantityPurchased;
	private double pricePerItem;
	private double actualPrice;
	private double discountedPrice;

	public ReceiptEntry(String produceCode, int quantityPurchased, double pricePerItem, double actualPrice,
			double discountedPrice) {
		this.produceCode = produceCode;
		this.quantityPurchased = quantityPurchased;
		this.pricePerItem = pricePerItem;
		this.actualPrice = actualPrice;
		this.discountedPrice = discountedPrice;
	}

	public String getProduceCode() {
		return produceCode;
	}

	public int getQuantityPurchased() {
		return quantityPurchased;
	}

	public double getPricePerItem() {
		return pricePerItem;
	}

	public double getActualPrice() {
		return actualPrice;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}
	
}
