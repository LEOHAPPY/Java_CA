package controllerStudent;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.NotFoundException;
import model.Course;
import model.Enrollment;
import model.GradeSession;
import model.Person;
import service.CourseService;
import service.EnrollmentService;

/**
 * Servlet implementation class GradeAndGPAControl
 */
@WebServlet("/gadeandgpa")
public class GradeAndGPAControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GradeAndGPAControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			process(request, response);
		} catch (NotFoundException e) {
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
			process(request, response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws NotFoundException {

		HttpSession session=request.getSession();
		Person pp=(Person) session.getAttribute("profile");
		String sId=pp.getId();

		EnrollmentService es = new EnrollmentService();
		CourseService cs = new CourseService();
		ArrayList<Enrollment> courseList = es.findEnrollment();

		ArrayList<GradeSession> data = new ArrayList<GradeSession>();
		double totalMark = 0;
		int totalgrade = 0;
		for (Enrollment e : courseList) {
			if(e.getCourseGrade()!=null){
			if (e.getStudentId().equals(sId) && (!e.getCourseGrade().equals("notset"))) {
				Course c = cs.findCourseById(e.getCourseId());
				System.out.println((e.getCourseGrade()));
				System.out.println("notset");
				
				System.out.println((!e.getCourseGrade().equals("notset")));
				GradeSession gs = new GradeSession();
				gs.setCourseId(c.getCourseId());
				gs.setCourseName(c.getCourseName());
				gs.setStart(c.getCourseStart());
				gs.setEnd(c.getCourseEnd());
				gs.setCourseCredit(c.getCourseCredit());
				gs.setCourseGrade(e.getCourseGrade());
				
				data.add(gs);
				
				

				switch (e.getCourseGrade()) {
				case "A":
					totalMark += 5.0 * c.getCourseCredit();
					break;

				case "B":
					totalMark += 4.0 * c.getCourseCredit();
					break;

				case "C":
					totalMark += 3.0 * c.getCourseCredit();
					break;

				case "D":
					totalMark += 2.0 * c.getCourseCredit();
					break;

				case "E":
					totalMark += 1.0 * c.getCourseCredit();
					break;

				case "F":
					totalMark += 0.0 * c.getCourseCredit();
					break;
				}

				totalgrade += c.getCourseCredit();
			}
		}
		}
		double gpa = totalMark / totalgrade;
		
		request.setAttribute("grade", data);
		request.setAttribute("gpa", gpa);
		RequestDispatcher rd = request.getRequestDispatcher("/views/Student/GradeGPA.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
