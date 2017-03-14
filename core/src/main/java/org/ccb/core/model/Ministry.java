package org.ccb.core.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ccb_ministry")
@AttributeOverride(name = "id", column = @Column(name = "id_ministry"))
public class Ministry extends PersistableEnum{

	public static final Ministry SEM_MINISTERIO = new Ministry(0L, "Sem ministério");
	public static final Ministry ANCIAO = new Ministry(1L, "Ancião");

	public Ministry(Long id, String description) {
		super(id, description);
	}

}