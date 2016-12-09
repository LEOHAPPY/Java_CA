package controllerAdmin;

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

import dao.DAOException;
import dao.PersonDAO;
import dao.PersonDAOAdmin;
import model.Person;

/**
 * Servlet implementation class AuthenticationServletAdmin
 */
@WebServlet("/authenServlet")

public class AuthenticationServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthenticationServletAdmin() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			authentication(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			authentication(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void authentication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("userId", username);

		Person p = new Person();
		p.setId(username);
		p.setPw(password);
		p.setLoadTime(0);
		String error="Your UserName and/or Password is incorrect!";
		
		if(username.equals(null) && password.equals(null))
			error="Please Fill the Blank";
		else if(username.equals(null))
			error="Please Enter the user name.";
		else if(password.equals(null))
			error="Please Enter the password.";

		RequestDispatcher ra = request.getRequestDispatcher("/views/Login.jsp");
		request.setAttribute("error", error);
		char firstChar = username.trim().charAt(0);
		// Identification
		if (firstChar == 'S' || firstChar == 's') {
			p.setRole("Students");

			PersonDAO ad = dao.DAOFactory.getStudentDAO();
			ArrayList<Person> aList;
			try {
				aList = ad.findAllPerson();
				request.setAttribute("aList", aList);
				for (Person p1 : aList) {
					if (username.equals(p1.getId()) && password.equals(p1.getPw())) {
						ra = request.getRequestDispatcher("/studentload");
						
					}
					
					ra.forward(request, response);
					return;
				}
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (firstChar == 'L' || firstChar == 'l') {
			p.setRole("Lectures");
			PersonDAO ad = dao.DAOFactory.getLectureDAO();
			ArrayList<Person> aList;
			try {
				aList = ad.findAllPerson();
				request.setAttribute("aList", aList);
				for (Person pp : aList) {
					if (username.equals(pp.getId()) && password.equals(pp.getPw())) {
						
						session.setAttribute("profile", pp);

						session.setAttribute("username", request.getParameter("username"));

						ra = request.getRequestDispatcher("/lecturer?value=coursesTaught");
						
					}
					ra.forward(request, response);
					return;
				}
			} catch (DAOException e) {

				e.printStackTrace();
			}

		} else if (firstChar == 'A' || firstChar == 'a') {
			p.setRole("Admins");

			PersonDAO ad = dao.DAOFactory.getAdminDao();
			ArrayList<Person> aList;
			try {
				aList = ad.findAllPerson();
				request.setAttribute("aList", aList);
				for (Person pp : aList) {
					if (username.equals(pp.getId()) && password.equals(pp.getPw())) {
						
						session.setAttribute("profile", pp);

						session.setAttribute("username", request.getParameter("username"));

						ra = request.getRequestDispatcher("/loadData");
						
					}
					ra.forward(request, response);

					return;
				}
			} catch (DAOException e) {

				e.printStackTrace();
			}
		}

		else {
			request.setAttribute("error", null);
			ra = request.getRequestDispatcher("/views/Login.jsp");
			ra.forward(request, response);

		}

	}
}
