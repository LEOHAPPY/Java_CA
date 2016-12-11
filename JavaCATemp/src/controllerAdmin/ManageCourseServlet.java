package controllerAdmin;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

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
import model.Person;
import service.CourseService;

@WebServlet({"/MCServlet","/MCServlet/*"})
public class ManageCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PersonDAO lDao = DAOFactory.getLectureDAO();
			ArrayList<Person> lListforCourse = lDao.findAllPerson();
			CourseService cs = new CourseService();
			ArrayList<Course> cList = cs.findAllCourses();
			request.setAttribute("cList", cList);
			
			String newCourseID="C1001";
			for (Course course : cList) {
				String courseID= course.getCourseId();
				String newID = courseID.substring(1);
				Integer id=Integer.parseInt(newID);
				id++;
				newID="C"+id.toString();
				if(newCourseID.compareTo(newID)<0)
				{
					newCourseID =newID;
				}
			}
			HttpSession session = request.getSession();
			session.setAttribute("newCourseID", newCourseID);
			session.setAttribute("lListforCourse", lListforCourse);
			RequestDispatcher ra = request.getRequestDispatcher("/views/Admin/ManageCourse.jsp");
			ra.forward(request, response);
		} catch ( NotFoundException | DAOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		switch(action){
		case "/Update":
			Course c = new Course();
			c.setCourseId(request.getParameter("id"));
			c.setCourseName(request.getParameter("courseName"));
			c.setCourseStart(Date.valueOf(request.getParameter("courseStart")));
			c.setCourseEnd(Date.valueOf(request.getParameter("courseEnd")));
			c.setCourseCredit(Integer.parseInt(request.getParameter("courseCredit")));
			c.setLectureId(request.getParameter("lecturerId"));
			c.setCourseMaxSize(Integer.parseInt(request.getParameter("courseMaxSize")));
			c.setCourseDesc(request.getParameter("CourseDesc"));
			if (request.getParameter("ins").equals("false")) {
				try {
					CourseService cs = new CourseService();
					cs.updateCourse(c);
					doGet(request, response);
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (request.getParameter("ins").equals("true") ) {
				try {
					CourseService cs = new CourseService();
					cs.createCourse(c);
					doGet(request, response);
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		case "/Delete":
			try {
				CourseService cs = new CourseService();
				cs.deleteCourse(request.getParameter("courseId"));
				doGet(request, response);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		

	}

}
