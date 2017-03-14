package org.ccb.core.model.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.ccb.core.filter.SearchFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

public class FilterSpecificationBuilder {
	
	private List<SearchFilter> params;
	
	public FilterSpecificationBuilder() {
		params = new ArrayList<>();
	}
	
	public FilterSpecificationBuilder with(String key, String operator, Object value) {
		params.add(new SearchFilter(key, operator, value));
		return this;
	}
	
	public <T> Specification<T> build() {
		
		if (params.size() == 0) {
            return null;
        }
		
		List<FilterSpecification<T>> specs = params.stream()
												.map(param -> new FilterSpecification(param))
												.collect(Collectors.toList());
		
		Specification<T> query = specs.get(0);
		for(int i = 1; i < specs.size(); i++) {
			query = Specifications.where(query).and(specs.get(i));
		}
		
		return query;
		
	}
}
