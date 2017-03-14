package org.ccb.core.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ccb_sector")
@AttributeOverride(name = "id", column = @Column(name = "id_sector"))
public class Sector extends PersistableEntity{

	@Column(nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
