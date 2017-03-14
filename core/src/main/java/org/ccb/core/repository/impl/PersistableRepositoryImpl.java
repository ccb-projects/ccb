package org.ccb.core.repository.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.ccb.core.enums.Status;
import org.ccb.core.model.PersistableEntity;
import org.ccb.core.repository.PersistableRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class PersistableRepositoryImpl<T extends PersistableEntity> 
					extends SimpleJpaRepository<T, Long> implements PersistableRepository<T>{

	private EntityManager entityManager;
	
	public PersistableRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public T update(T entity) {
		entity.setLastUpdated(Date.from(Instant.now()));
		return save(entity);
	}

	@Override
	@Transactional
	public void logicalDelete(Long id) {
		T entity = findOne(id);
		entity.setRemoved(Status.REMOVED);
		update(entity);
	}

	@Override
	public List<T> list() {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getDomainClass());
		Root<T> root = query.from(getDomainClass());
		
		Predicate isRemoved = builder.equal(root.get("removed"), Status.ACTIVE);
		query.where(isRemoved);
		
		List<T> result = entityManager.createQuery(query.select(root)).getResultList();
		
		return result;
	}

}
