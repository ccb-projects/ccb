package org.ccb.core.repository;

import org.ccb.core.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PersonRepository extends PersistableRepository<Person> {

}
