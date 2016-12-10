package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDAO;
import dao.DAOFactory;
import dao.EnrollmentDAO;
import model.Course;
import model.Enrollment;

public class LecturerService {
	public static void showGradeCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		CourseDAO cd = DAOFactory.getCourseDao();
		HttpSession session = request.getSession();
		ArrayList<Course> cList = cd.findCoursesByLecturer((String) session.getAttribute("username"));
		request.setAttribute("cList", cList);
		RequestDispatcher rd = request.getRequestDispatcher("/views/Lecture/GradeCourse.jsp");
		rd.forward(request, response);
	}

	public static void showGradePage(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		EnrollmentDAO ed = DAOFactory.getEnrollmentDao();
		ArrayList<Enrollment> eList = ed.findEnrollmentsByCourse(request.getParameter("id"));
		request.setAttribute("eList", eList);
	}

	public static void updateGrade(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		ArrayList<Enrollment> eList = (ArrayList<Enrollment>) session.getAttribute("eList");
		EnrollmentDAO ed= DAOFactory.getEnrollmentDao();
		for (Enrollment enrollment : eList) {
			enrollment.setCourseGrade(request.getParameter(String.valueOf(enrollment.getEnrollmentId())));
			ed.updateEnrollment(enrollment);
		}
	}
}
