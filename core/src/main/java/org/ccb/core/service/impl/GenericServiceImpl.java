package org.ccb.core.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.ccb.core.model.PersistableEntity;
import org.ccb.core.model.specifications.FilterSpecificationBuilder;
import org.ccb.core.model.specifications.PropertySpecifications;
import org.ccb.core.repository.PersistableRepository;
import org.ccb.core.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

public class GenericServiceImpl<E extends PersistableEntity> 
					implements GenericService<E>{

	@Autowired
	private PersistableRepository<E> repository;
	
	@Override
	public E save(E entity) throws Exception{
		return repository.save(entity);
	}

	@Override
	public E update(E entity) throws Exception {
		return repository.update(entity);
	}

	@Override
	public void logicalDelete(Long id) {
		repository.logicalDelete(id);
	}

	@Override
	public void delete(E entity) {
		repository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}
	
	@Override
	public void delete(List<E> entities) {
		repository.delete(entities);
	}

	@Override
	public List<E> list() {
		return repository.list();
	}

	@Override
	public Page<E> list(Pageable pagination) {
		return repository.findAll(pagination);
	}
	
	@Override
	public List<E> listAll() {
		return repository.findAll();
	}

	@Override
	public E findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<E> findByProperty(String property, Object value) {
		E entity = (E) new PersistableEntity();
		return repository.findAll(Specifications.where(PropertySpecifications.byProperty(entity, property, value)));
	}

	@Override
	public Page<E> generalSearch(Object value, Pageable page) {
		E entity = (E) new PersistableEntity();
		
		Field[] fields = entity.getClass().getDeclaredFields();
		
		FilterSpecificationBuilder specBuilder = new FilterSpecificationBuilder();
		
		for(Field field : fields) {
			if(value.getClass() == field.getType())
				specBuilder.with(field.getName(), "%", value);
		}
		
		Specification<E> spec = specBuilder.build();
		
		return getRepository().findAll(spec, page);
	}

	public PersistableRepository<E> getRepository() {
		return repository;
	}
}
