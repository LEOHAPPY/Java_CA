// remember session 
// work as front controller

package controllerAdmin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.DAOException;
import dao.DAOFactory;
import dao.PersonDAO;
import model.Person;

/**
 * Servlet implementation class loadData
 */
@WebServlet("/loadData")
public class loadData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loadData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws DAOException {
		// get 
		HttpSession session = request.getSession();
		Person pp = (Person) session.getAttribute("profile");
		//System.out.println(pp.getLoadTime());

		if (pp.getLoadTime() == 0) {
			PersonDAO ad = dao.DAOFactory.getPersonDAO();
			ArrayList<Person> aList;
			try {
				aList = ad.findAllPerson("Admins");
				for (Person p : aList) {
					request.setAttribute("aList", aList);
				}
				try {
					pp.setLoadTime(pp.getLoadTime() + 1);
					System.out.println(pp.getLoadTime());
					RequestDispatcher ra = request.getRequestDispatcher("/views/Admin/AdminDefault.jsp");
					ra.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			HttpSession session2 = request.getSession();
			Person pp2 = (Person) session2.getAttribute("profile");
			String selNav = pp2.getSelNav();

			PersonDAO ad = dao.DAOFactory.getPersonDAO();
			ArrayList<Person> aList = ad.findAllPerson(selNav);
			for (Person p : aList) {
				request.setAttribute("aList", aList);
			}
			pp.setLoadTime(pp.getLoadTime() + 1);
			
			RequestDispatcher ra1 = request.getRequestDispatcher("/views/Admin/AdminDefault.jsp");
			try {
				ra1.forward(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
}
