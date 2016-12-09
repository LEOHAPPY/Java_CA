//package controllerAdmin;
//
//import java.io.IOException;
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.tomcat.util.codec.binary.StringUtils;
//
//import dao.CourseDAO;
//import dao.DAOException;
//import dao.DAOFactory;
//import model.Course;
//import model.Person;
//import service.CourseService;
//
//
///**
// * Servlet implementation class modifyProcess
// */
//@WebServlet("/modifyProcessCourse")
//public class modifyProcessCourse extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public modifyProcessCourse() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
//			processRequest(request, response);
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		try {
//			processRequest(request, response);
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws DAOException {
//		//get role
//		//String role = roleGetClass.roleGeter(request, response);
////		HttpSession session = request.getSession();
////		Person pp = (Person)session.getAttribute("profile");
////		String role = pp.getSelNav();
//		
//		//PersonDAOAdmin pdao = DAOFactory.getPersonDAO();
//		CourseDAO cdao = DAOFactory.getCourseDao();
// 		CourseService cs = new CourseService();
// 		
//		//Person p = new Person();
//		Course c = new Course();
//		String ins = (String) request.getParameter("ins");
//		System.out.print(ins);
//
//		if (ins.equals("true")){
//			
//			String lastRow;
//			ArrayList<Course> courseList = cs.findCourses();
//			for (Course course : courseList) {
//				lastRow=course.getCourseId();
//			}
//			int lastId = Integer.parseInt(lastRow.substring(1))+1;
//			String temp=Integer.toString(lastId);
//			String zero="0000";
//			String result="S"+zero.substring(0, (4-temp.length()))+temp;
//			c.setCourseId(result);
//		}else{
//			//p.setId(request.getParameter("id"));
//			c.setCourseId(request.getParameter("courseId"));
//		}
//		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
//		c.setCourseName(request.getParameter("courseName"));
//		c.setCourseStart((Date)formatter.parse(request.getParameter("courseStart")));
//		c.setCourseEnd((Date)formatter.parse(request.getParameter("courseCredit")));
//		c.setCourseCredit(Integer.parseInt(request.getParameter("courseCredit")));
//		c.setCourseMaxSize(Integer.parseInt(request.getParameter("courseMaxSize")));
//		
//		/*Logger.getLogger(getClass().getName()).log(Level.INFO,
//				"Insert Flag: " + ins);
//		System.out.println("MESSAGE");*/
//		
//		if (ins.equals("true")) {
//			//cdao.(c.); 
//		}else{
//			cdao.updatePerson(p,role);
//		}
//		//refresh data and go to AdminDefault 
//		ArrayList<Person> aList = cdao.findAllPerson(role);
//		request.setAttribute("aList", aList);
//		RequestDispatcher rd = request.getRequestDispatcher("/views/Admin/AdminDefault.jsp");
//		try {
//			rd.forward(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//
//}
