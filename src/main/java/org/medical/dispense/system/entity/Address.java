package org.medical.dispense.system.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 * @author johnybasha
 *
 */
@Embeddable
@JsonbPropertyOrder(value = { "address1", "address2", "city", "state", "zipCode" })
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "address1", length = 50, nullable = false)
	@Size(min = 1, max = 50)
	@JsonbProperty("address1")
	private String address1;

	@Column(name = "address2")
	@JsonbProperty("address2")
	private String address2;

	@Column(name = "city", length = 50, nullable = false)
	@Size(min = 2, max = 20)
	@JsonbProperty("city")
	private String city;

	@Column(name = "state", length = 20, nullable = false)
	@Size(min = 2, max = 20)
	@JsonbProperty("state")
	private String state;

	@Column(name = "zipcode", length = 10, nullable = false)
	@Size(min = 2, max = 10)
	@JsonbProperty("zipCode")
	private String zipCode;

	public Address() {
		super();
	}

	public Address(@Size(min = 1, max = 50) String address1, String address2, @Size(min = 2, max = 20) String city,
			@Size(min = 2, max = 20) String state, @Size(min = 2, max = 10) String zipCode) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address1, address2, city, state, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(address1, other.address1) && Objects.equals(address2, other.address2)
				&& Objects.equals(city, other.city) && Objects.equals(state, other.state)
				&& Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}
}