package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBConnect;
import model.Teacher;

/**
 * This is a DAO (DATA ACCESS OBJECT) class which provides 
 * CRUD (CREATE - READ - UPDATE - DELETE) database operations 
 * for the table student in the database
 */
public class TeacherDAO {

	public TeacherDAO() {
	}

	public List<Teacher> selectAllTeachers() {

		List<Teacher> teachers = new ArrayList<>();
		// Step 1: Establishing a Connection
		Connection connection = DBConnect.getConnection();
		try {
			// Step 2:Create a statement using connection object
			String SELECT_ALL_TEACHERS = "SELECT * FROM teacher";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TEACHERS);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String department = rs.getString("department");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				teachers.add(new Teacher(id, name, department, address, email, phone));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}
}
