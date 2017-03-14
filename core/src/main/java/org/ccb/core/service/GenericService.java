package org.ccb.core.service;

import java.util.List;

import org.ccb.core.model.PersistableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<E extends PersistableEntity>{
	
	E save(E entity) throws Exception;
	
	E update(E entity) throws Exception;
	
	void logicalDelete(Long id);
	
	void delete(E entity);
	
	void delete(Long id);
	
	void delete(List<E> entities);
	
	List<E> list();
	
	Page<E> list(Pageable pagination);
	
	List<E> listAll();
	
	E findOne(Long id);
	
	List<E> findByProperty(String property, Object value);
	
	Page<E> generalSearch(Object value, Pageable page);

}
