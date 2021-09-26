package org.medical.dispense.system.boundary;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.medical.dispense.system.control.DispensaryResource;
import org.medical.dispense.system.entity.Patient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * @author johnybasha
 *
 */
@ApplicationScoped
@Path("patient")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Api(value = "PatientService", consumes = "application/json", produces = "Application/Json", tags = { "patient" })
public class PatientService {

	@Inject
	private DispensaryResource dispensaryResource;

	@Inject
	private Logger logger;

	@POST
	@ApiOperation(value = "This method adds the patient to the database.", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, response = Response.class)
	@ApiResponses(value = { @ApiResponse(message = "Added the patient to the database.", code = 201) })
	public Response addPatient(Patient patient) {
		logger.log(Level.INFO, "Adding patient:: {0}", patient);
		dispensaryResource.addPatient(patient);
		return Response.status(Status.CREATED).build();
	}

	@GET
	@Path("{id}")
	@ApiOperation(value = "This method finds the patient by id from the database.", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, response = Response.class)
	@ApiResponses(value = { @ApiResponse(message = "Found the matching patient from the database.", code = 200) })
	public Response findPatient(@PathParam("id") long id) {
		Patient patient = dispensaryResource.findPatientById(id);
		logger.log(Level.INFO, "Found {0}", patient);
		return Response.ok(patient).build();
	}

	@GET
	@Path("all")
	@ApiOperation(value = "This method finds all the patients from the database.", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, response = Response.class)
	@ApiResponses(value = { @ApiResponse(message = "Found all the patients from the database.", code = 200) })
	public List<Patient> findAll() {
		List<Patient> patients = dispensaryResource.findAllPatients();
		logger.log(Level.INFO, "Found {0}", patients);
		return patients;
	}
}