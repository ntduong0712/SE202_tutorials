package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBConnect;
import model.Course;

/**
 * This is a DAO (DATA ACCESS OBJECT) class which provides 
 * CRUD (CREATE - READ - UPDATE - DELETE) database operations 
 * for the table student in the database
 */
public class CourseDAO {

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
}
