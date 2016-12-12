package controllerLecture;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.servlet.http.HttpSession;

import dao.CourseDAOImpl;
import dao.DAOException;
import dao.DAOFactory;
import dao.LectureDAOImpl;
import dao.PersonDAO;
import exception.NotFoundException;
import model.Course;
import model.Enrollment;
import model.Person;
import service.CourseService;
import service.EnrollmentService;

/**
 * Servlet implementation class StudentLoadController
 */
@WebServlet("/lecturer")
public class LecturerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LecturerController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (NotFoundException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (NotFoundException | DAOException e) {

			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws NotFoundException, DAOException, ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		Person person = (Person) session.getAttribute("profile");
		if (person == null) {
			rd = request.getRequestDispatcher("/views/Login.jsp");
		} else {

			String urlRequest = request.getParameter("value");
			ArrayList<Course> list = null;
			String dispatch = null;
			LectureDAOImpl LDI = new LectureDAOImpl();
			if (urlRequest.equals("coursesTaught")) {
				list = LDI.CourseList(person);
				dispatch = "/views/Lecture/CourseTaught.jsp";
			} else if (urlRequest.equals("courseEnrollment")) {
				list = LDI.studentEnrolled(person);
				dispatch = "/views/Lecture/CourseEnrol.jsp";
			}
			request.setAttribute("data", list);
			System.out.println(list);
			rd = request.getRequestDispatcher(dispatch);
		}
		try {
			rd.forward(request, response);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
