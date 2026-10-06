package com.cg.bankapp.query;

import lombok.Data;

@Data
public class GetCustomerByIdQuery {
	private int id;

	public GetCustomerByIdQuery(int id) {
		super();
		this.id = id;
	}
}