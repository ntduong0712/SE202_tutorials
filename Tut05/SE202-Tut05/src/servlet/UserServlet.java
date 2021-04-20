package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public void init() {
		userDAO = new UserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TO-DO: Implement switch-case structure for page navigation with
		// request-response
		String action = request.getServletPath();
		try {
			switch(action) {
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					insertUser(request, response);
					break;
				case "/update":
					updateUser(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/delete":
					deleteUser(request, response);
					break;
				default:
					listUser(request, response);
					break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement showNewForm() method which navigates to ADD USER view
	// (add-user.jsp)
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-user.jsp");
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement showEditForm() method which navigates to UPDATE USER view
	// (edit-user.jsp)
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-user.jsp");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement insertUser() method for adding new user
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		User newUser = new User(name, address, mobile);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}

	// TO-DO: Implement updateUser() method for updating existing user
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		User user = new User(id, name, address, mobile);
		userDAO.updateUser(user);
		response.sendRedirect("list");
	}

	// TO-DO: Implement deleteUser() method for deleting existing user
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");
	}
}
