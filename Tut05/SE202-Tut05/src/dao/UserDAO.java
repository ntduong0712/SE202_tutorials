package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import model.User;

/**
 * This is a DAO (DATA ACCESS OBJECT) class which provides CRUD (CREATE - READ -
 * UPDATE - DELETE) database operations for the table user in the database
 */
public class UserDAO {

	// Step 1: Establishing a Connection
	Connection connection = DBConnect.getConnection();

	public UserDAO() {
	}

	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		try {
			// Step 2:Create a statement using connection object
			String SELECT_ALL_USERS = "SELECT * FROM user";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String mobile = rs.getString("mobile");
				users.add(new User(id, name, address, mobile));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	// TO-DO: Implement selectUser() method to select user by ID (use in UPDATE function)
	public User selectUser(int id) {
		User user = null;
		try {
			String SELECT_USER_BY_ID = "SELECT id, name, address, mobile FROM user WHERE ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				String mobile = rs.getString("mobile");
				user = new User(id, name, address, mobile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	// TO-DO: Implement insertUser() method to add new record to table User  
	public void insertUser(User user) throws SQLException {
		try {
			String INSERT_USER = "INSERT INTO user (name, address, mobile) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getAddress());
			preparedStatement.setString(3, user.getMobile());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TO-DO: Implement updateUser() method to update record in table User  
	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated = false;
		try {
			String UPDATE_USER = "UPDATE user SET name=?, address=?, mobile=? WHERE ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getAddress());
			preparedStatement.setString(3, user.getMobile());
			preparedStatement.setInt(4, user.getId());
			rowUpdated = preparedStatement.executeUpdate() > 0; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	// TO-DO: Implement deleteUser() method to delete record in table User  
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted = false;
		try {
			String DELETE_USER = "DELETE FROM user WHERE ID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
}
