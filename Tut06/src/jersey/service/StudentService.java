package jersey.service;

import java.util.ArrayList;
import java.util.List;

import jersey.model.Student;

public class StudentService {
	public List<Student> getAllStudents() {
		Student s1 = new Student (1,"Hoang Tuan", "0912345678");
		Student s2 = new Student (2,"Phuong Linh", "0986868686");
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		return list;
	}
}
