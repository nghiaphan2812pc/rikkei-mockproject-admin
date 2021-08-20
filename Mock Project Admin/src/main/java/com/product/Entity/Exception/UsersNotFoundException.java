package com.product.Entity.Exception;

import java.text.MessageFormat;

public class UsersNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */


	public UsersNotFoundException(final Long id) {
		super(MessageFormat.format("khong tim thay id" , id));
	}}
