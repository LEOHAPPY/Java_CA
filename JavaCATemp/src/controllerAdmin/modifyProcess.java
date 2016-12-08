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
import javax.swing.plaf.synth.SynthSeparatorUI;

import dao.DAOException;
import dao.DAOFactory;
import dao.PersonDAO;
import model.Person;


/**
 * Servlet implementation class modifyProcess
 */
@WebServlet("/modifyProcess")
public class modifyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyProcess() {
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
		//get role
		//String role = roleGetClass.roleGeter(request, response);
		HttpSession session = request.getSession();
		Person pp = (Person)session.getAttribute("profile");
		String role = pp.getSelNav();
		
		PersonDAO pdao = DAOFactory.getPersonDAO();
		
		Person p = new Person();
		String ins = (String) request.getParameter("ins");
		System.out.print(ins);

		if (ins.equals("true")){
			int lastId = pdao.findAllPerson(role).size() + 1;
			String fourNumId = "0";
			if(lastId <10){
				fourNumId = "000" + Integer.toString(lastId);
			}else if (lastId <100){
				fourNumId = "00" + Integer.toString(lastId);
			}else if (lastId < 1000){
				fourNumId = "0" + Integer.toString(lastId);
			}
			
			String newId = role.charAt(0) + fourNumId;
			p.setId(newId);
		}else{
			p.setId(request.getParameter("id"));
		}
		p.setName(request.getParameter("name"));
		p.setEmail(request.getParameter("email"));
		p.setPw(request.getParameter("pw"));
		
		/*Logger.getLogger(getClass().getName()).log(Level.INFO,
				"Insert Flag: " + ins);
		System.out.println("MESSAGE");
		*/
		if (ins.equals("true")) {
			pdao.insertPerson(p,role); 
		}else{
			pdao.updatePerson(p,role);
		}
		//refresh data and go to AdminDefault 
		ArrayList<Person> aList = pdao.findAllPerson(role);
		request.setAttribute("aList", aList);
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
