package org.ccb.core.repository;

import java.util.List;

import org.ccb.core.model.PersistableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersistableRepository<T extends PersistableEntity> extends JpaRepository<T, Long>, 
						JpaSpecificationExecutor<T>{

	T update(T entity);
	
	void logicalDelete(Long id);
	
	List<T> list();
	
}
