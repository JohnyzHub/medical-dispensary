/**
 * 
 */
package org.medical.dispense.system.control;

import org.medical.dispense.system.entity.Prescription;
import org.medical.dispense.system.entity.dto.PrescriptionDto;

/**
 * @author johnybasha
 *
 */

public class DtoMapper {

	public PrescriptionDto toDto(Prescription prescription) {
		PrescriptionDto prescriptionDto = new PrescriptionDto();
		prescriptionDto.setId(prescription.getId());
		prescriptionDto.setMedication(prescription.getMedication().getName());
		prescriptionDto
				.setPatient(prescription.getPatient().getLastName() + ", " + prescription.getPatient().getFirstName());
		prescriptionDto.setQuantity(prescription.getQuantity());
		prescriptionDto.setRefills(prescription.getRefills());
		return prescriptionDto;

	}

}
