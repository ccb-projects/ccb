package org.ccb.core.model;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ccb_person")
@AttributeOverride(name = "id", column = @Column(name = "id_person"))
public class Person extends PersistableEntity {

	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "ministry")
	private Ministry ministry;
	
	@Column
	private String phone;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "address_id")
	private Address address;
	
	public Person() {
		super();
	}
	public Person(Long id) {
		super(id);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Ministry getMinistry() {
		return ministry;
	}
	public void setMinistry(Ministry ministry) {
		this.ministry = ministry;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
