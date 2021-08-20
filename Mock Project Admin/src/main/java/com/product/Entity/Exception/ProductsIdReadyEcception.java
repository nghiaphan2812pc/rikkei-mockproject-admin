package com.product.Entity.Exception;

import java.text.MessageFormat;

public class ProductsIdReadyEcception extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductsIdReadyEcception(final Long productsId, final Long brandId) {
		super(MessageFormat.format("Prodcuts: is ready", productsId, brandId));
	}

}
