package org.ccb.core.filter;

public class SearchFilter {

	private String key;
	private FilterOperator operation;
	private Object value;

	public SearchFilter() {
		super();
	}

	public SearchFilter(String key, String operation, Object value) {
		super();
		this.key = key;
		this.operation = FilterOperator.getOperator(operation);
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public FilterOperator getOperation() {
		return operation;
	}

	public void setOperation(FilterOperator operation) {
		this.operation = operation;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
