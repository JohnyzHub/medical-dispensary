package org.medical.dispense.system.control;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.medical.dispense.system.entity.Medication;
import org.medical.dispense.system.entity.Patient;
import org.medical.dispense.system.entity.Prescription;
import org.medical.dispense.system.entity.dto.PrescriptionDto;

/**
 * @author johnybasha
 *
 */
@ApplicationScoped
@Transactional
public class DispensaryResource {

	@Inject
	private EntityManager em;

	@Inject
	private DtoMapper dtoMapper;

	public void addPrescription(long patientId, long medicationId, int quantity, int refills) {
		Patient patient = findPatientById(patientId);
		Medication medication = findMedicationById(medicationId);
		Prescription prescription = new Prescription(patient, medication, quantity, refills);
		em.persist(prescription);
	}

	public Patient findPatientById(long id) {
		Optional<Patient> optionalPatient = em.createNamedQuery(Patient.FIND_PATIENT_BY_ID, Patient.class)
				.setParameter("id", id).getResultList().stream().findFirst();
		if (optionalPatient.isPresent()) {
			return optionalPatient.get();
		}
		return null;
	}

	public Medication findMedicationById(long id) {
		Optional<Medication> optionalMedication = em
				.createNamedQuery(Medication.FIND_MEDICATION_BY_ID, Medication.class).setParameter("id", id)
				.getResultList().stream().findFirst();
		if (optionalMedication.isPresent()) {
			return optionalMedication.get();
		}
		return null;
	}

	public PrescriptionDto findPrescriptionById(long id) {
		Optional<Prescription> optionalPrescription = em
				.createNamedQuery(Prescription.FIND_PRESCRIPTION_BY_ID, Prescription.class).setParameter("id", id)
				.getResultList().stream().findFirst();
		PrescriptionDto prescriptionDto = new PrescriptionDto();
		if (optionalPrescription.isPresent()) {
			Prescription prescription = optionalPrescription.get();
			prescriptionDto = dtoMapper.toDto(prescription);
		}
		return prescriptionDto;
	}

	public void addPatient(Patient patient) {
		em.persist(patient);
	}

	public List<Patient> findAllPatients() {
		return em.createNamedQuery(Patient.FIND_ALL, Patient.class).getResultList();
	}
}