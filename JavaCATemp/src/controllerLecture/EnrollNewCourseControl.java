package controllerLecture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOException;
import dao.DAOFactory;
import dao.PersonDAO;
import exception.NotFoundException;
import model.Course;
import model.Enrollment;
import model.Person;
import model.Student;
import service.CourseService;
import service.EnrollmentService;

/**
 * Servlet implementation class EnrollNewCourseControl
 */
@WebServlet("/checkEnroll")
public class EnrollNewCourseControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollNewCourseControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request,response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request,response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
private void process(HttpServletRequest request, HttpServletResponse response) throws NotFoundException, DAOException {
	//String sId=Session.get
	HttpSession session=request.getSession();
	Person pp=(Person) session.getAttribute("profile");
	String sId=pp.getId(); 
	
	String cId=request.getParameter("id");	
	
	EnrollmentService es=new EnrollmentService();
	CourseService cs=new CourseService();
	
	ArrayList<Enrollment> courseList = es.findEnrollment();		
	
	Course newCourse=cs.findCourseById(cId);
	
	int lEnrollID=0;
	
	for (Enrollment enrollment : courseList) {
		
		 lEnrollID=enrollment.getEnrollmentId();
	}
	
	Date d=new Date();
	Boolean overlap=false;
	Boolean canChange=true;
	RequestDispatcher rd = request.getRequestDispatcher("/studentload");
	
	PersonDAO sDAO=DAOFactory.getStudentDAO();
	Person currentStudent=(Person) sDAO.findPerson(sId);
	System.out.println(currentStudent.getEmail());
	for (Enrollment e : courseList) {
		if(e.getStudentId().equals(sId)){
			Course c=cs.findCourseById(e.getCourseId());
			
			if(!c.getCourseEnd().before(newCourse.getCourseStart()) ) {
				if(!c.getCourseStart().after(newCourse.getCourseEnd())){
					overlap=true;
					if(c.getCourseStart().before(d))
						canChange=false;
					System.out.println(canChange);
					request.setAttribute("canChange", canChange);
					request.setAttribute("overlapCourse", c);
					request.setAttribute("newCourse", newCourse);
					request.setAttribute("email", currentStudent.getEmail());
				}
			}
			
				
		}
	}
	if(!overlap){
		Enrollment newEnroll=new Enrollment();
		newEnroll.setEnrollmentId(lEnrollID+1);		
		newEnroll.setStudentId(sId);
		newEnroll.setCourseId(cId);
		newEnroll.setCourseGrade(null);				
		es.createEnrollment(newEnroll);
		
	}
	else
		rd=request.getRequestDispatcher("views/Student/Duplicate.jsp");
		
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
