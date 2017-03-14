package org.ccb.core.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ccb_city")
@AttributeOverride(name = "id", column = @Column(name = "id_city"))
public class City extends PersistableEntity {

	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "sector_id")
	private Sector sector;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

}
