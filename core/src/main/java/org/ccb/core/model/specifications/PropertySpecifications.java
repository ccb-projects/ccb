package org.ccb.core.model.specifications;

import org.springframework.data.jpa.domain.Specification;

public class PropertySpecifications{

	public static <T> Specification<T> byProperty(T clazz, String propertyName, Object propertyValue) {
		return (root, query, criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(propertyName), propertyValue);
		};
	}
	
}
