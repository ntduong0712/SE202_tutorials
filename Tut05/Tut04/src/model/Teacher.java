package model;

/**
 * This is a model class represents a Teacher entity for the table Teacher in database
 */

public class Teacher {
	protected int id;
	protected String name;
	protected String department;
	protected String address;
	protected String email;
	protected String phone;
	
	public Teacher() {
	}
	
	public Teacher(String name, String department,  String address, String email, String phone) {
		super();
		this.name = name;
		this.department = department;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public Teacher(int id, String name, String department, String address, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.address = address;
		this.email = email;
		this.phone = phone;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
