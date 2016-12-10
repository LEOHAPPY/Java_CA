package controllerAdmin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOException;
import model.Person;

/**
 * Servlet implementation class AdminNav
 */
/*@WebServlet("/AdminNav")*/
@WebServlet(name="AdminNav",urlPatterns={"/AdminNav","/AdminNav/*"})
public class AdminNav extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNav() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		System.out.print(request.getPathInfo());
		String selNav = request.getPathInfo().substring(1);
		
		HttpSession session = request.getSession();
		Person pp = (Person)session.getAttribute("profile");
		
		if (pp.getSelNav()==""){
			pp.setSelNav("Admins");
		}else{
			pp.setSelNav(selNav);
		}
		
		RequestDispatcher ra = request.getRequestDispatcher("/loadData");
		try {
			ra.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
