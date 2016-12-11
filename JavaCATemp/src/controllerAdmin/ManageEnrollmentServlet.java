package controllerAdmin;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import service.EnrollmentService;

@WebServlet({"/MEServlet","/MEServlet/*"})
public class ManageEnrollmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageEnrollmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			EnrollmentService es = new EnrollmentService();
			ArrayList<Enrollment> eList = es.findEnrollment();
			request.setAttribute("eList", eList);
			
			int newEnrollmentID=1;
			for (Enrollment enrollment : eList) {
				int courseID= enrollment.getEnrollmentId();
				courseID++;
				if(newEnrollmentID<courseID)
				{
					newEnrollmentID=courseID;
				}
			}
			HttpSession session = request.getSession();
			session.setAttribute("newEnrollmentID", newEnrollmentID);
			
			RequestDispatcher ra = request.getRequestDispatcher("/views/Admin/ManageEnrollment.jsp");
			ra.forward(request, response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/Update":
			Enrollment e = new Enrollment();
			e.setEnrollmentId(Integer.parseInt(request.getParameter("id")));
			e.setStudentId(request.getParameter("studentId"));
			e.setCourseId(request.getParameter("courseId"));
			e.setCourseGrade(request.getParameter("courseGrade"));
			if (request.getParameter("ins").equals("false")) {
				try {
					EnrollmentService es = new EnrollmentService();
					es.updateEnrollment(e);
					doGet(request, response);
				} catch (NotFoundException en) {
					// TODO Auto-generated catch block
					en.printStackTrace();
				}

			} else if (request.getParameter("ins").equals("true")) {
				try {	
					EnrollmentService es = new EnrollmentService();
					es.createEnrollment(e);
					doGet(request, response);
				} catch (NotFoundException en) {
					// TODO Auto-generated catch block
					en.printStackTrace();
				}
			}
			break;
		case "/Delete":
			try {
				EnrollmentService es = new EnrollmentService();
				es.deleteEnrollment(Integer.parseInt(request.getParameter("enrollmentId")));
				doGet(request, response);
			} catch (NotFoundException en) {
				// TODO Auto-generated catch block
				en.printStackTrace();
			}
			break;
		}

	}
}