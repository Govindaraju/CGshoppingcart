package com.gk.shop.cart.domain;

import static com.gk.shop.cart.domain.DiscountHandler.discountedPrice;
import static com.gk.shop.cart.common.NumberUtil.round;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.gk.shop.cart.domain.exception.EmptyBasketException;
import com.gk.shop.cart.domain.model.Product;
import com.gk.shop.cart.domain.model.Receipt;
import com.gk.shop.cart.domain.model.ReceiptEntry;

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

	public Receipt doCheckOutWithDiscount() {

		Map<String, ReceiptEntry> countOfProductsByType = new HashMap<>();
		return produceReceipt(countOfProductsByType);
	}

	Receipt produceReceipt(Map<String, ReceiptEntry> typeToCount) {

		Receipt receipt = new Receipt();
		basket.stream().collect(Collectors.groupingBy(Product::getCode, TreeMap::new, Collectors.toList()))
				.forEach((productCode, products) -> {

					Optional<ReceiptEntry> optionalReceiptEntry = buildReceiptEntry(productCode, products);

					if (optionalReceiptEntry.isPresent()) {
						receipt.addEntry(optionalReceiptEntry.get());
					}

				});

		return receipt;
	}

	private Optional<ReceiptEntry> buildReceiptEntry(String productCode, List<Product> products) {
		Optional<ReceiptEntry> optionalReceiptEntry = Optional.empty();

		Long count = products.stream().count();

		if (count == 0) {
			return optionalReceiptEntry;
		}

		Product anyProduct = products.get(0);

		int quantityPurchased = count.intValue();
		double pricePerItem = anyProduct.getPrice();
		double actualPrice = round(quantityPurchased * pricePerItem, 2);
		double discountedPrice = round(discountedPrice(productCode, quantityPurchased, pricePerItem), 2);

		ReceiptEntry receiptEntry = new ReceiptEntry(productCode, quantityPurchased, pricePerItem, actualPrice,
				discountedPrice);

		return Optional.of(receiptEntry);
	}

}
