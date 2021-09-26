package org.medical.dispense.system.entity.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author johnybasha
 *
 */
public class PrescriptionDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String medication;

	private String patient;

	private int quantity;

	private int refills;

	public PrescriptionDto() {
	}

	public PrescriptionDto(Long id, String medication, String patient, int quantity, int refills) {
		super();
		this.id = id;
		this.medication = medication;
		this.patient = patient;
		this.quantity = quantity;
		this.refills = refills;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
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

	@Override
	public int hashCode() {
		return Objects.hash(id, medication, patient, quantity, refills);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrescriptionDto other = (PrescriptionDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(medication, other.medication)
				&& Objects.equals(patient, other.patient) && quantity == other.quantity && refills == other.refills;
	}

	@Override
	public String toString() {
		return "PrescriptionDto [id=" + id + ", medication=" + medication + ", patient=" + patient + ", quantity="
				+ quantity + ", refills=" + refills + "]";
	}

}
