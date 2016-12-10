package controllerAdmin;

import java.awt.Window;
import java.io.IOException;
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
import dao.PersonDAOAdmin;
import model.Person;

/**
 * Servlet implementation class deleteProcess
 */
@WebServlet("/deleteProcess")
public class deleteProcess extends HttpServlet {
	
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public deleteProcess() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				processRequest(request, response);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			try {
				processRequest(request, response);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void processRequest(HttpServletRequest request, HttpServletResponse response) throws DAOException {
			
//			//get role
//			String role = roleGetClass.roleGeter(request, response);
			HttpSession session = request.getSession();
			Person pp = (Person)session.getAttribute("profile");
			String role = pp.getSelNav();
			
			String id = request.getParameter("id");
			PersonDAOAdmin pdao = DAOFactory.getPersonDAO();
			Person p = pdao.findPerson(id,role);
			System.out.println(p.toString());
			pdao.deletePerson(p,role);
			//refresh data and go to AdminDefault 
			ArrayList<Person> aList = pdao.findAllPerson(role);
			request.setAttribute("aList", aList);
			
			request.setAttribute("idd", pp.getId());
			RequestDispatcher rd = request.getRequestDispatcher("/views/Admin/AdminDefault.jsp");
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
