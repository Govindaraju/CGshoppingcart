package com.gk.shop.cart.common.cache;

import java.util.HashMap;
import java.util.Map;

import com.gk.shop.cart.common.OffersOnProduct;
import com.gk.shop.cart.common.ProductMaster;

public final class OffersOnProductCache {

	private static final int GET_THREE = 3;
	private static final int BUY_TWO = 2;
	private static final int GET_TWO = 2;
	private static final int BUY_ONE = 1;

	private static final OffersOnProductCache eagerInstance = new OffersOnProductCache();
	private Map<String, OffersOnProduct> offersMap = new HashMap<>();

	private OffersOnProductCache() {
		offersMap.put(ProductMaster.APPLE.code(), new OffersOnProduct(BUY_ONE, GET_TWO));
		offersMap.put(ProductMaster.ORANGE.code(), new OffersOnProduct(BUY_TWO, GET_THREE));
	}

	public static OffersOnProductCache getInstance() {
		return eagerInstance;
	}

	public OffersOnProduct offerFor(String code) {
		return offersMap.get(code);
	}

}
