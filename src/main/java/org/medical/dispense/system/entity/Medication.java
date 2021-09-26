package org.medical.dispense.system.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author johnybasha
 *
 */
@Entity
@Table(name = Medication.TABLE_NAME)
@NamedQuery(name = Medication.FIND_MEDICATION_BY_ID, query = "select m from Medication m where m.id = :id")
@JsonbPropertyOrder(value = { "id", "name" })
public class Medication implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "medication";

	public static final String FIND_MEDICATION_BY_ID = "FIND_MEDICATION_BY_ID";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medication-seq-generator")
	@SequenceGenerator(name = "medication-seq-generator", sequenceName = "med_seq", allocationSize = 1)
	@Column(name = "id")
	@JsonbProperty("id")
	private Long id;

	@Column(name = "name")
	@JsonbProperty("name")
	private String name;

	public Medication() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Medication(String name) {
		super();
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medication other = (Medication) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Medication [id=" + id + ", name=" + name + "]";
	}
}