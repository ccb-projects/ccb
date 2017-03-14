package org.ccb.core.filter;

public enum FilterOperator {

	EQUAL(":"),
	LIKE("%"),
	GREAT_THAN(">"),
	LESS_THAN("<");
	
	String operator;
	
	private FilterOperator(String operator) {
		this.operator = operator;
	}
	
	public static FilterOperator getOperator(String operator) {
		for(FilterOperator value : values()) {
			if(value.operator.equalsIgnoreCase(operator)) {
				return value;
			}
		}
		
		return null;
	}
}
