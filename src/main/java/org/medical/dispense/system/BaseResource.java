package org.medical.dispense.system;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.medical.dispense.system.boundary.PatientService;
import org.medical.dispense.system.boundary.PrescriptionService;

/**
 * @author johnybasha
 *
 */
@ApplicationPath("rest")
public class BaseResource extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();

		resources.add(PatientService.class);
		resources.add(PrescriptionService.class);

		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		return resources;
	}
}