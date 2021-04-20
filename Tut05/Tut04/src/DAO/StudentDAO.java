package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnect;
import model.Student;

/**
 * This is a DAO (DATA ACCESS OBJECT) class which provides CRUD (CREATE - READ -
 * UPDATE - DELETE) database operations for the table student in the database
 */
public class StudentDAO {
	Connection connection = DBConnect.getConnection();

	public StudentDAO() {
	}

	public List<Student> selectAllStudents() {

		List<Student> students = new ArrayList<>();
		// Step 1: Establishing a Connection
		Connection connection = DBConnect.getConnection();
		try {
			// Step 2:Create a statement using connection object
			String SELECT_ALL_STUDENTS = "SELECT * FROM student";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String department = rs.getString("department");
				String year = rs.getString("year");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				students.add(new Student(id, name, department, year, address, email, phone));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	// TO-DO: Implement selectStudent() method to select student by ID (use in UPDATE
	// function)
	public Student selectStudent(int id) {
		Student student = null;
		try { 
			String SELECT_STUDENT_BY_ID = "SELECT id, name, department, year, address, email, phone FROM student WHERE ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String department = rs.getString("department");
				String year = rs.getString("year");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				student = new Student(id, name, department, year, address, email, phone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	// TO-DO: Implement insertStudent() method to add new record to table Student
	public void insertStudent(Student student) throws SQLException {
		try {
			String INSERT_USER = "INSERT INTO student (name, department, year, address, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getDepartment());
			preparedStatement.setString(3, student.getYear());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setString(5, student.getEmail());
			preparedStatement.setString(6, student.getPhone());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TO-DO: Implement updateStudent() method to update record in table Student
	public boolean updateStudent(Student student) throws SQLException {
		boolean rowUpdated = false;
		try {
			String UPDATE_STUDENT = "UPDATE student SET name=?, department=?, year=?, address=?, email=?, phone=? WHERE ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getDepartment());
			preparedStatement.setString(3, student.getYear());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setString(5, student.getEmail());
			preparedStatement.setString(6, student.getPhone());
			preparedStatement.setInt(7, student.getId());
			rowUpdated = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	// TO-DO: Implement deleteStudent() method to delete record in table Student
	public boolean deleteStudent(int id) throws SQLException {
		boolean rowDeleted = false;
		try {
			String DELETE_STUDENT = "DELETE FROM student WHERE ID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
}
