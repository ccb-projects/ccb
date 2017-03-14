package org.ccb.core.model.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.ccb.core.filter.FilterOperator;
import org.ccb.core.filter.SearchFilter;
import org.springframework.data.jpa.domain.Specification;

public class FilterSpecification<T> implements Specification<T>{

	private SearchFilter filter;

	public FilterSpecification(SearchFilter filter) {
		this.filter = filter;
	}
	
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (filter.getOperation() == FilterOperator.GREAT_THAN) {
            return cb.greaterThan(root.get(filter.getKey()), filter.getValue().toString());
        } 
        else if (filter.getOperation() == FilterOperator.LESS_THAN) {
            return cb.lessThan(root.get(filter.getKey()), filter.getValue().toString());
        } 
        else if (filter.getOperation() == FilterOperator.LIKE) {
            if (root.get(filter.getKey()).getJavaType() == String.class) {
                return cb.like(root.get(filter.getKey()), "%" + filter.getValue() + "%");
            } else {
                return cb.equal(root.get(filter.getKey()), filter.getValue());
            }
        }
        return null;
	}

}
