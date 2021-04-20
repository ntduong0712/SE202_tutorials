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
		// TO-DO: Implement switch-case structure for page navigation with
		// request-response
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/newCourse":
				showNewFormCourse(request, response);
				break;
			case "/insertCourse":
				insertCourse(request, response);
				break;
			case "/updateCourse":
				updateCourse(request, response);
				break;
			case "/editCourse":
				showEditFormCourse(request, response);
				break;
			case "/deleteCourse":
				deleteCourse(request, response);
				break;
			default:
				listCourse(request, response);
				System.out.println(action);
				break;
			}
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

	// TO-DO: Implement showNewForm() method which navigates to ADD COURSE view
	// (add-course.jsp)
	private void showNewFormCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-course.jsp");
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement showEditForm() method which navigates to UPDATE COURSE view
	// (edit-course.jsp)
	private void showEditFormCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Course course = courseDAO.selectCourse(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-course.jsp");
		request.setAttribute("course", course);
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement insertCourse() method for adding new course
	private void insertCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String semester = request.getParameter("semester");
		String credit = request.getParameter("credit");
		String department = request.getParameter("department");
		Course newCourse = new Course(name, semester, credit, department);
		courseDAO.insertCourse(newCourse);
		response.sendRedirect("Course");
	}

	// TO-DO: Implement updateCourse() method for updating existing course
	private void updateCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String semester = request.getParameter("semester");
		String credit = request.getParameter("credit");
		String department = request.getParameter("department");
		Course user = new Course(id, name, semester, credit, department);
		courseDAO.updateCourse(user);
		response.sendRedirect("Course");
	}

	// TO-DO: Implement deleteCourse() method for deleting existing course
	private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		courseDAO.deleteCourse(id);
		response.sendRedirect("Course");
	}
}
