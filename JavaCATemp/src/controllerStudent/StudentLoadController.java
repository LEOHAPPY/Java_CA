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
import javax.websocket.Session;

import dao.DAOFactory;
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
@WebServlet("/studentload")
public class StudentLoadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws NotFoundException {
		
		HttpSession session=request.getSession();
		Person pp=(Person) session.getAttribute("profile");
		String sId=pp.getId();
		
		EnrollmentService es=new EnrollmentService();
		CourseService cs=new CourseService();		
		ArrayList<Enrollment> courseList = es.findEnrollment();
		
		ArrayList<Course> data=new ArrayList<Course>();
		
		for (Enrollment e : courseList) {			
			
			if(e.getStudentId().equals(sId) && ((e.getCourseGrade()==null)  || (e.getCourseGrade().equals("notset")))){				
				Course c=cs.findCourseById(e.getCourseId());
				
				data.add(c);
			}
		}
		
		request.setAttribute("course", data);
		RequestDispatcher rd = request.getRequestDispatcher("/views/Student/StudentDefault.jsp");
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
