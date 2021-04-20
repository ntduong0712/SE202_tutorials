package jersey.model;

public class Course {
	protected int id;
	protected String name;
	protected String semester;
	protected String credit;
	protected String department;
	
	public Course() {
	}
	
	public Course(String name, String semester, String credit, String department) {
		super();
		this.name = name;
		this.semester = semester;
		this.credit = credit;
		this.department = department;
	}

	public Course(int id, String name, String semester, String credit, String department) {
		super();
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.credit = credit;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
