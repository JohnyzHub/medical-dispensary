package org.medical.dispense.system.control.produce;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author johnybasha
 *
 */
public class EntityManagerProducer {

	@PersistenceContext(unitName = "medical-dispense-pu")
	private EntityManager em;

	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return em;
	}
}
