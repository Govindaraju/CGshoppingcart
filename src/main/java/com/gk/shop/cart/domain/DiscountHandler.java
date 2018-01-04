package com.gk.shop.cart.domain;

import com.gk.shop.cart.common.OffersOnProduct;
import com.gk.shop.cart.common.cache.OffersOnProductCache;

public class DiscountHandler {

	// private OffersOnProductCache offersOnProductCache;

	static double discountedPrice(String productCode, int totalQuantiy, double pricePerItem){
		OffersOnProduct offer = OffersOnProductCache.getInstance().offerFor(productCode);
		
		int buyQuantity = offer.getBuyQuantity();
		int getQuantity = offer.getGetQuantity();
		
		int wholeQuantity = totalQuantiy / getQuantity;
		int remainingQuantity = totalQuantiy % getQuantity;
		
		return (wholeQuantity * buyQuantity + remainingQuantity) * pricePerItem;
				
	}

}
