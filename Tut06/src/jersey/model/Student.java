package jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	private int StudentID;
	private String StudentName;
	private String StudentMobile;

	public Student() {
		super();
	}

	public Student(int studentID, String studentName, String studentMobile) {
		super();
		StudentID = studentID;
		StudentName = studentName;
		StudentMobile = studentMobile;
	}

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getStudentMobile() {
		return StudentMobile;
	}

	public void setStudentMobile(String studentMobile) {
		StudentMobile = studentMobile;
	}	
}
