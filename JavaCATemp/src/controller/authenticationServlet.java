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

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.DAOException;
import dao.PersonDAO;
import data.AdminDAO;
import data.DAOFactory;
import data.LecturerDAO;
import data.StudentDAO;
import model.Admin;
import model.Lecturer;
import model.Person;
import model.Student;

/**
 * Servlet implementation class authenticationServlet
 */
@WebServlet(name ="authenServlet", urlPatterns = { "/authenServlet" })
public class authenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public authenticationServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PersonDAO ad = dao.DAOFactory.getAdminDao();
//		ArrayList<Admin> admins;
//		try {
//			admins = ad.findAllPerson();
//			request.setAttribute("admins", admins);
//			RequestDispatcher rd = request.getRequestDispatcher("/AdminPages/AdminDefault.jsp");
//			rd.forward(request, response);
//
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
//		String role = request.getParameter("role");
		String role = "Admin";
		PersonDAO ad= dao.DAOFactory.getAdminDao();
		ArrayList<Person> aList;
		try {
			aList = ad.findAllPerson();
			for (Person p : aList) {
				RequestDispatcher ra = request.getRequestDispatcher("${pageContext.request.contextPath}/views/Admin/AdminDefault.jsp");
				ra.forward(request, response);
				return;
			} 
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
		
//			
////			
////			try {
////				aList = ad.findAllPerson();
////				for (Person p : aList) {
////					if(p.getLogin()==username&&p.getPw()==password)
////					{
////						RequestDispatcher ra = request.getRequestDispatcher("${pageContext.request.contextPath}/views/Admin/AdminDefault.jsp");
////						ra.forward(request, response);
////						return;
////					}
////				} 
////				}catch (DAOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//		}
//		
//		}
//
//		}}}
