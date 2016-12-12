package controllerLecture;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Enrollment;
import service.LecturerService;

@WebServlet(urlPatterns = { "/LecturerServlet", "/LecturerServlet/*" })
public class LecturerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LecturerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getParameter("page")) {
		case "GradeCourse":
			try {
				LecturerService.showGradeCourse(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		switch (action) {
		case "/View":
			try {
				LecturerService.showGradePage(request, response);
				RequestDispatcher rd = request.getRequestDispatcher("/views/Lecture/ViewGrade.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/Grade":
			try {
				LecturerService.showGradePage(request, response);
				HttpSession session = request.getSession();
				session.setAttribute("eList", (ArrayList<Enrollment>) request.getAttribute("eList"));
				RequestDispatcher rd = request.getRequestDispatcher("/views/Lecture/GradePage.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/UpdateGrade":
			try {
				LecturerService.updateGrade(request, response);
				LecturerService.showGradeCourse(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}

}
