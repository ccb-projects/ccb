package org.ccb.core.enums;

public enum ImmobileType {

	OWN("Pr�prio"),
	RENTED("Alugado"),
	ASSIGNED("Cedido");
	
	private String value;
	
	ImmobileType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
