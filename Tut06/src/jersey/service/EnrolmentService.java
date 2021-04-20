package jersey.service;

import java.util.ArrayList;
import java.util.List;

import jersey.model.Enrolment;

public class EnrolmentService {
	public List<Enrolment> getAllEnrolments() {
		Enrolment e1 = new Enrolment (1,"Hoang Tuan", "SE2", 8, 8, 8);
		Enrolment e2 = new Enrolment (2,"Phuong Linh", "SQA", 7, 5, 6);
		List<Enrolment> list = new ArrayList<Enrolment>();
		list.add(e1);
		list.add(e2);
		return list;
	}
}
