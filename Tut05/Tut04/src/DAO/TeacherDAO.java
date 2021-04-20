package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnect;
import model.Teacher;

/**
 * This is a DAO (DATA ACCESS OBJECT) class which provides CRUD (CREATE - READ -
 * UPDATE - DELETE) database operations for the table student in the database
 */
public class TeacherDAO {
	Connection connection = DBConnect.getConnection();

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

	// TO-DO: Implement selectTeacher() method to select teacher by ID (use in
	// UPDATE
	// function)
	public Teacher selectTeacher(int id) {
		Teacher teacher = null;
		try {
			String SELECT_TEACHER_BY_ID = "SELECT id, name, department, address, email, phone FROM teacher WHERE ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEACHER_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String department = rs.getString("department");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				teacher = new Teacher(id, name, department, address, email, phone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacher;
	}

	// TO-DO: Implement insertTeacher() method to add new record to table Teacher
	public void insertTeacher(Teacher teacher) throws SQLException {
		try {
			String INSERT_TEACHER = "INSERT INTO teacher (name, department, address, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHER);
			preparedStatement.setString(1, teacher.getName());
			preparedStatement.setString(2, teacher.getDepartment());
			preparedStatement.setString(4, teacher.getAddress());
			preparedStatement.setString(5, teacher.getEmail());
			preparedStatement.setString(6, teacher.getPhone());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TO-DO: Implement updateTeacher() method to update record in table Teacher
	public boolean updateTeacher(Teacher teacher) throws SQLException {
		boolean rowUpdated = false;
		try {
			String UPDATE_TEACHER = "UPDATE teacher SET name=?, department=?, address=?, email=?, phone=? WHERE ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TEACHER);
			preparedStatement.setString(1, teacher.getName());
			preparedStatement.setString(2, teacher.getDepartment());
			preparedStatement.setString(4, teacher.getAddress());
			preparedStatement.setString(5, teacher.getEmail());
			preparedStatement.setString(6, teacher.getPhone());
			preparedStatement.setInt(7, teacher.getId());
			rowUpdated = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	// TO-DO: Implement deleteTeacher() method to delete record in table Teacher
	public boolean deleteTeacher(int id) throws SQLException {
		boolean rowDeleted = false;
		try {
			String DELETE_TEACHER = "DELETE FROM teacher WHERE ID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TEACHER);
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
}
