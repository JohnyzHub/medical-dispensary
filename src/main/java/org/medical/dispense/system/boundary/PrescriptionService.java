package org.medical.dispense.system.boundary;

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

import org.medical.dispense.system.control.DispensaryResource;
import org.medical.dispense.system.entity.dto.PrescriptionDto;

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
@Path("prescription")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Api(value = "PrescriptionService", consumes = "application/json", produces = "Application/Json", tags = {
		"prescription" })
public class PrescriptionService {

	@Inject
	private DispensaryResource dispensaryResource;

	@Inject
	private Logger logger;

	@POST
	@Path("{patientId}/{medicationId}/{quantity}/{refills}")
	@ApiOperation(value = "This method adds the prescription to the database.", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, response = Response.class)
	@ApiResponses(value = { @ApiResponse(message = "Added the prescription to the database.", code = 201) })
	public Response addPrescription(@PathParam("patientId") long patientId,
			@PathParam("medicationId") long medicationId, @PathParam("quantity") int quantity,
			@PathParam("refills") int refills) {
		dispensaryResource.addPrescription(patientId, medicationId, quantity, refills);
		return Response.ok().build();
	}

	@GET
	@Path("{id}")
	@ApiOperation(value = "This method finds the prescription by id from the database.", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(message = "Found the prescription matching the id from the database.", code = 200) })
	public Response findPrescription(@PathParam("id") long id) {
		PrescriptionDto prescription = dispensaryResource.findPrescriptionById(id);
		logger.log(Level.INFO, "Found {0}", prescription);
		return Response.ok(prescription).build();
	}
}