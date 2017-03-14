package org.ccb.core.repository;

import java.util.List;

import org.ccb.core.model.PersistableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<E extends PersistableEntity> extends JpaRepository<E, Long> {

	@Query("select e from #{#entityName} e where e.removed = 0")
	List<E> list();
}
