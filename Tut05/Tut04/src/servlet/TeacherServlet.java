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

import DAO.TeacherDAO;
import model.Teacher;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */
@WebServlet("/Teacher")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDAO teacherDAO;

	public void init() {
		teacherDAO = new TeacherDAO();
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
			case "/newTeacher":
				showNewFormTeacher(request, response);
				break;
			case "/insertTeacher":
				insertTeacher(request, response);
				break;
			case "/updateTeacher":
				updateTeacher(request, response);
				break;
			case "/editTeacher":
				showEditFormTeacher(request, response);
				break;
			case "/deleteTeacher":
				deleteTeacher(request, response);
				break;
			default:
				listTeacher(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Teacher> listTeacher = teacherDAO.selectAllTeachers();
		request.setAttribute("listTeacher", listTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-list.jsp");
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement showNewFormTeacher() method which navigates to ADD TEACHER
	// view
	// (add-teacher.jsp)
	private void showNewFormTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-teacher.jsp");
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement showEditFormStudent() method which navigates to UPDATE
	// TEACHER view
	// (edit-student.jsp)
	private void showEditFormTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Teacher teacher = teacherDAO.selectTeacher(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-teacher.jsp");
		request.setAttribute("teacher", teacher);
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement insertTeacher() method for adding new teacher
	private void insertTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Teacher newTeacher = new Teacher(name, department, address, email, phone);
		teacherDAO.insertTeacher(newTeacher);
		response.sendRedirect("Teacher");
	}

	// TO-DO: Implement updateTeacher() method for updating existing teacher
	private void updateTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Teacher teacher = new Teacher(id, name, department, address, email, phone);
		teacherDAO.updateTeacher(teacher);
		response.sendRedirect("Teacher");
	}

	// TO-DO: Implement deleteTeacher() method for deleting existing teacher
	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		teacherDAO.deleteTeacher(id);
		response.sendRedirect("Teacher");
	}
}
