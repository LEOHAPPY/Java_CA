package controller;

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
import dao.DAOFactory;
import dao.PersonDAO;
import dao.PersonDAOAdmin;
import model.Person;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/authenServlet")

public class AuthenticationServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthenticationServlet2() {
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
		// get input
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String error = "please input username/password";

		// validate
		if (username == "" || password == "") {
			System.out.print(error);
			RequestDispatcher ra = request.getRequestDispatcher("/views/Login.jsp");
			ra.forward(request, response);
		} else {
			// get first Char of username
			char firstChar = username.trim().toUpperCase().charAt(0);
			// identification
			//record username and password
			Person pp = new Person();
			pp.setId(username);
			pp.setPw(password);
			pp.setLoadTime(0);
			
			HttpSession session = request.getSession();
			session.setAttribute("profile", pp);
			//get dao
			PersonDAOAdmin pd = DAOFactory.getPersonDAO();
			String role = "";
			ArrayList<Person> aList;
			
			switch (firstChar) {
			case 'A':
				role = "Admins";
				try {
					
					aList= pd.findAllPerson(role);
					for (Person p1 : aList) {
						if (username.equals(p1.getId()) && password.equals(p1.getPw())) {
							pp.setSelNav("Admins");
							session.setAttribute("profile", pp);
							RequestDispatcher ra = 
									request.getRequestDispatcher("/loadData");
							ra.forward(request, response);
							//return;
						}
					}
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher ra = request.getRequestDispatcher("/views/Login.jsp");
				ra.forward(request, response);
				break;
			case 'S':
				role = "Students";
				try {
					aList= pd.findAllPerson(role);
					for (Person p1 : aList) {
						if (username.equals(p1.getId()) && password.equals(p1.getPw())) {
							session = request.getSession();
							session.setAttribute("userId", username);
							ra = 
									request.getRequestDispatcher("/studentload");
							ra.forward(request, response);
							//return;
						}
					}
					//if not match still in login 
					ra = request.getRequestDispatcher("/views/Login.jsp");
					ra.forward(request, response);
					
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 'L':
				role = "Lectures";
				try {
					aList= pd.findAllPerson(role);
					for (Person p1 : aList) {
						if (username.equals(p1.getId()) && password.equals(p1.getPw())) {
							session = request.getSession();
							//session.setAttribute("profile", pp);
							session.setAttribute("username", request.getParameter("username"));
							ra = request.getRequestDispatcher("/lecturer?value=coursesTaught");
							ra.forward(request, response);
							return;
						}
					}
				    ra = request.getRequestDispatcher("/views/Login.jsp");
					ra.forward(request, response);
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.print(error);
				ra = request.getRequestDispatcher("/views/Login.jsp");
				ra.forward(request, response);
				break;
			}
		}

	}
}
