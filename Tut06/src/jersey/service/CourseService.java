package jersey.service;

import java.util.ArrayList;
import java.util.List;

import jersey.model.Course;

public class CourseService {
	public List<Course> getAllCourses() {
		Course c1 = new Course (1,"SE2", "7", "3", "FIT");
		Course c2 = new Course (2, "SQA", "7", "3", "FIT");
		List<Course> list = new ArrayList<Course>();
		list.add(c1);
		list.add(c2);
		return list;
	}
}
