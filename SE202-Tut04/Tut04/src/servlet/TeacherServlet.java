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

		try {
			listTeacher(request, response);
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

}
