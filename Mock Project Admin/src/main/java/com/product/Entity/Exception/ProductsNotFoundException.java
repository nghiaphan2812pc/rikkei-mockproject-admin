package com.product.Entity.Exception;

import java.text.MessageFormat;

public class ProductsNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ProductsNotFoundException(final Long id) {
		super(MessageFormat.format("khong tim thay id" , id));
	}

}