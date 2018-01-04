package com.gk.shop.cart.domain.exception;

public class EmptyBasketException extends RuntimeException {
	private static final long serialVersionUID = 8873020628884174468L;

	public EmptyBasketException(String message) {
		super(message);
	}
}
