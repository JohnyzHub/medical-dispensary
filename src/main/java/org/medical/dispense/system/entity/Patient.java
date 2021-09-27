package org.medical.dispense.system.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;

/**
 * @author johnybasha
 *
 */
@Entity
@Table(name = Patient.TABLE_NAME, catalog = "postgres", schema = "public")
@NamedQuery(name = Patient.FIND_ALL, query = "select p from Patient p")
@NamedQuery(name = Patient.FIND_PATIENT_BY_ID, query = "select p from Patient p where p.id = :id")
@JsonbPropertyOrder(value = { "id", "lastName", "firstName", "address" })
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "patient";

	public static final String FIND_ALL = "FIND_ALL";
	public static final String FIND_PATIENT_BY_ID = "FIND_PATIENT_BY_ID";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient-seq-generator")
	@SequenceGenerator(name = "patient-seq-generator", sequenceName = "patient_seq", allocationSize = 1)
	@Column(name = "id")
	@JsonbProperty("id")
	private long id;

	@Column(name = "lastname", nullable = false)
	@JsonbProperty("lastname")
	private String lastName;

	@Column(name = "firstname", nullable = false)
	@JsonbProperty("firstname")
	private String firstName;

	@Embedded
	@Valid
	@JsonbProperty("address")
	private Address address;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Prescription.class, mappedBy = "patient")
	@JsonbTransient
	private List<Prescription> prescriptions;

	public Patient() {
		super();
	}

	public Patient(String lastName, String firstName, Address address) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", address=" + address
				+ ", prescriptions=" + prescriptions + "]";
	}
}