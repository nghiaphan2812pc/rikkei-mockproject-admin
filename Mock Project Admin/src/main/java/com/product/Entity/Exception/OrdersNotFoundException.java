package com.product.Entity.Exception;

import java.text.MessageFormat;

public class OrdersNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public OrdersNotFoundException(final Long id) {
		super(MessageFormat.format("khong tim thay id" , id));
	}
}
