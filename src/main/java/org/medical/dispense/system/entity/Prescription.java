package org.medical.dispense.system.entity;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author johnybasha
 *
 */

@Entity
@Table(name = Prescription.TABLE_NAME, catalog = "postgres", schema = "public")
@NamedQuery(name = Prescription.FIND_PRESCRIPTION_BY_ID, query = "select p from Prescription p where p.id = :id")
@JsonbPropertyOrder(value = { "id", "medication", "patient", "quantity", "refills" })
public class Prescription implements Serializable {

	public static final String TABLE_NAME = "prescription";

	private static final long serialVersionUID = 1L;

	public static final String FIND_PRESCRIPTION_BY_ID = "FIND_PRESCRIPTION_BY_ID";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescription-seq-generator")
	@SequenceGenerator(name = "prescription-seq-generator", sequenceName = "prescription_seq", allocationSize = 1)
	@Column(name = "id")
	@JsonbProperty("id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "MEDICATION")
	@JsonbProperty("medication")
	private Medication medication;

	@ManyToOne
	@JoinColumn(name = "PATIENT")
	@JsonbProperty("patient")
	private Patient patient;

	@Column(name = "quantity")
	@JsonbProperty("quantity")
	private int quantity;

	@Column(name = "refills")
	@JsonbProperty("refills")
	private int refills;

	public Prescription() {
		super();
	}

	public Prescription(Patient patient, Medication medication, int quantity, int refills) {
		super();
		this.medication = medication;
		this.patient = patient;
		this.quantity = quantity;
		this.refills = refills;
	}

	public long getId() {
		return id;
	}

	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRefills() {
		return refills;
	}

	public void setRefills(int refills) {
		this.refills = refills;
	}
}