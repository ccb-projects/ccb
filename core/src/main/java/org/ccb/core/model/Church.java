package org.ccb.core.model;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ccb_church")
@AttributeOverride(name = "id", column = @Column(name = "id_church"))
public class Church extends PersistableEntity{

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String code;
	
	@Column(name = "immobile_type")
	private int immobileType;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "address_id")
	private Address address;

	public Church() {
		super();
	}

	public Church(Long id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getImmobileType() {
		return immobileType;
	}

	public void setImmobileType(int immobileType) {
		this.immobileType = immobileType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
