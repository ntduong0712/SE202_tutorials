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

import DAO.StudentDAO;
import model.Student;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */
@WebServlet("/Student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;

	public void init() {
		studentDAO = new StudentDAO();
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
			switch (action) {
			case "/newStudent":
				showNewFormStudent(request, response);
				break;
			case "/insertStudent":
				insertStudent(request, response);
				break;
			case "/updateStudent":
				updateStudent(request, response);
				break;
			case "/editStudent":
				showEditFormStudent(request, response);
				break;
			case "/deleteStudent":
				deleteStudent(request, response);
				break;
			default:
				listStudent(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Student> listStudent = studentDAO.selectAllStudents();
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement showNewFormStudent() method which navigates to ADD STUDENT
	// view
	// (add-student.jsp)
	private void showNewFormStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-student.jsp");
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement showEditFormStudent() method which navigates to UPDATE
	// STUDENT view
	// (edit-student.jsp)
	private void showEditFormStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentDAO.selectStudent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-student.jsp");
		request.setAttribute("student", student);
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement insertStudent() method for adding new student
	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String year = request.getParameter("year");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Student newStudent = new Student(name, department, year, address, email, phone);
		studentDAO.insertStudent(newStudent);
		response.sendRedirect("Student");
	}

	// TO-DO: Implement updateStudent() method for updating existing student
	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String year = request.getParameter("year");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Student student = new Student(id, name, department, year, address, email, phone);
		studentDAO.updateStudent(student);
		response.sendRedirect("Student");
	}

	// TO-DO: Implement deleteStudent() method for deleting existing student
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentDAO.deleteStudent(id);
		response.sendRedirect("Student");
	}
}
