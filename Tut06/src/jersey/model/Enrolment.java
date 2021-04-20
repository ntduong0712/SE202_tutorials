package jersey.model;

public class Enrolment {
	protected int id;
	protected String studentName;
	protected String course;
	protected int internalMark;
	protected int finalMark;
	protected int averageMark;
	
	public Enrolment() {
	}

	public Enrolment(int id, String studentName, String course, int internalMark, int finalMark, int averageMark) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.course = course;
		this.internalMark = internalMark;
		this.finalMark = finalMark;
		this.averageMark = averageMark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getInternalMark() {
		return internalMark;
	}

	public void setInternalMark(int internalMark) {
		this.internalMark = internalMark;
	}

	public int getFinalMark() {
		return finalMark;
	}

	public void setFinalMark(int finalMark) {
		this.finalMark = finalMark;
	}

	public int getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(int averageMark) {
		this.averageMark = averageMark;
	}
	
	
	
}
