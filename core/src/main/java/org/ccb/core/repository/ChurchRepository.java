package org.ccb.core.repository;

import javax.transaction.Transactional;

import org.ccb.core.model.Church;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ChurchRepository extends PersistableRepository<Church>{

}
