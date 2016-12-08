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
import model.Person;

/**
 * Servlet implementation class authenticationServlet
 */
@WebServlet("/authenServlet")

public class authenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public authenticationServlet() {
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
		
		Person p = new Person();
		p.setId(username);
		p.setPw(password);
		p.setLoadTime(0);
		
		char firstChar = username.trim().charAt(0);
		//Identification
		if(firstChar == 'S' || firstChar == 's'){
			p.setRole("Students");
		}else if(firstChar == 'L' || firstChar == 'l' ) {
			p.setRole("Lectures");
		}else if (firstChar == 'A' || firstChar == 'a'){
			p.setRole("Admins");
		}
		
		HttpSession session = request.getSession();
    	session.setAttribute("profile", p);
		
		//go to /loadData
		RequestDispatcher ra = request.getRequestDispatcher("/loadData");
		ra.forward(request, response);
	}
}
