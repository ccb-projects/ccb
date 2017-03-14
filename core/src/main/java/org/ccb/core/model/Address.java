package org.ccb.core.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ccb_address")
@AttributeOverride(name = "id", column = @Column(name = "id_address"))
public class Address extends PersistableEntity{

	@Column(nullable = false)
	private String street;
	
	@Column
	private int number;
	
	@Column
	private String cep;
	
	@Column(nullable = false)
	private String neighborhood;
	
	@ManyToOne
    @JoinColumn(name = "city_id")
	private City city;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
