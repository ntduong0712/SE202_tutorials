package jersey.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jersey.model.Enrolment;
import jersey.service.EnrolmentService;

@Path("/enrolment")
public class EnrolmentResource {
	EnrolmentService enrolmentService = new EnrolmentService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Enrolment> getEnrolment() {
		return enrolmentService.getAllEnrolments();
	}
}
