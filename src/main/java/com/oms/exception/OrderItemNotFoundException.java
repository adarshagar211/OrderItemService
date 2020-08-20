package com.oms.exception;

public class OrderItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3018713382753926456L;

	public OrderItemNotFoundException() {
		this("OrderItem does not exist in database");
	}

	public OrderItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderItemNotFoundException(String message) {
		super(message);
	}

	public OrderItemNotFoundException(Throwable cause) {
		super(cause);
	}
}
