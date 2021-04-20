package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnect;
import model.Course;

/**
 * This is a DAO (DATA ACCESS OBJECT) class which provides CRUD (CREATE - READ -
 * UPDATE - DELETE) database operations for the table student in the database
 */
public class CourseDAO {
	Connection connection = DBConnect.getConnection();

	public CourseDAO() {
	}

	public List<Course> selectAllCourses() {

		List<Course> courses = new ArrayList<>();
		// Step 1: Establishing a Connection
		Connection connection = DBConnect.getConnection();
		try {
			// Step 2:Create a statement using connection object
			String SELECT_ALL_COURSES = "SELECT * FROM course";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COURSES);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String semester = rs.getString("semester");
				String credit = rs.getString("credit");
				String department = rs.getString("department");
				courses.add(new Course(id, name, semester, credit, department));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	// TO-DO: Implement selectCourse() method to select course by ID (use in
	// UPDATE
	// function)
	public Course selectCourse(int id) {
		Course course = null;
		try {
			String SELECT_COURSE_BY_ID = "SELECT id, name, semester, credit, department FROM course WHERE ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSE_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String semester = rs.getString("semester");
				String credit = rs.getString("credit");
				String department = rs.getString("department");
				course = new Course(id, name, semester, credit, department);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}

	// TO-DO: Implement insertCourse() method to add new record to table Course
	public void insertCourse(Course course) throws SQLException {
		try {
			String INSERT_COURSE = "INSERT INTO course (name, semester, credit, department) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURSE);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setString(2, course.getSemester());
			preparedStatement.setString(3, course.getCredit());
			preparedStatement.setString(4, course.getDepartment());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TO-DO: Implement updateCourse() method to update record in table Course
	public boolean updateCourse(Course course) throws SQLException {
		boolean rowUpdated = false;
		try {
			String UPDATE_COURSE = "UPDATE course SET name=?, semester=?, credit=?, department=? WHERE ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COURSE);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setString(2, course.getSemester());
			preparedStatement.setString(3, course.getCredit());
			preparedStatement.setString(4, course.getDepartment());
			preparedStatement.setInt(7, course.getId());
			rowUpdated = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	// TO-DO: Implement deleteCourse() method to delete record in table Course
	public boolean deleteCourse(int id) throws SQLException {
		boolean rowDeleted = false;
		try {
			String DELETE_COURSE = "DELETE FROM course WHERE ID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COURSE);
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
}
