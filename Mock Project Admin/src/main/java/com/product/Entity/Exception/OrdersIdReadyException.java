package com.product.Entity.Exception;

import java.text.MessageFormat;

public class OrdersIdReadyException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrdersIdReadyException(final Long ordersId, final Long usersId) {
		super(MessageFormat.format("Prodcuts: is ready", ordersId, usersId));
	}}
