package jersey.service;

import java.util.ArrayList;
import java.util.List;

import jersey.model.Teacher;

public class TeacherService {
	public List<Teacher> getAllTeachers() {
		Teacher t1 = new Teacher (1,"Xuan Dai", "FIT", "Hanoi", "xuandai@gmail.com", "0912345678");
		Teacher t2 = new Teacher (2,"Thi Giang", "FIT", "Hanoi", "ntgiang@gmail.com", "0986868686");
		List<Teacher> list = new ArrayList<Teacher>();
		list.add(t1);
		list.add(t2);
		return list;
	}
}
