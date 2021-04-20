package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBConnect;
import model.Student;

/**
 * This is a DAO (DATA ACCESS OBJECT) class which provides 
 * CRUD (CREATE - READ - UPDATE - DELETE) database operations 
 * for the table student in the database
 */
public class StudentDAO {

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
}
