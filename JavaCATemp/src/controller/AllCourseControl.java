package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.NotFoundException;
import model.Course;
import service.CourseService;

/**
 * Servlet implementation class AllCourseControl
 */
@WebServlet("/allcourse")
public class AllCourseControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllCourseControl() {
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
		}
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NotFoundException {
		int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        CourseService sc=new CourseService();
        ArrayList<Course> list = sc.findCourses((page-1)*recordsPerPage,
                recordsPerPage);
        int noOfRecords =sc.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("course", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("/views/Student/AllCourse.jsp");
        view.forward(request, response);
	}
	

}
