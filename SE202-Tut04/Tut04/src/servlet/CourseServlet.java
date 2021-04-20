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

import DAO.CourseDAO;
import model.Course;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */
@WebServlet("/Course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseDAO courseDAO;
	
	public void init() {
		courseDAO = new CourseDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			listCourse(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void listCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Course> listCourse = courseDAO.selectAllCourses();
		request.setAttribute("listCourse", listCourse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("course-list.jsp");
		dispatcher.forward(request, response);
	}

}
