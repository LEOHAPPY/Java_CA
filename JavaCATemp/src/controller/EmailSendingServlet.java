package controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmailUtility;
 
/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 *
 * @author www.codejava.net
 *
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String host;
    private String port;
    //private String user;
    //private String pass;
    private String recipient;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        recipient = context.getInitParameter("recipient");
        //user = "hannizaw93@gmail.com";
        //pass = context.getInitParameter("pass");
        System.out.println("Init is ok");
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
    	ServletContext context = getServletContext();
        //String recipient = request.getParameter("recipient");
    	String user =request.getParameter("user");
        String pass=request.getParameter("pass");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
 
        String resultMessage = "";
 
        try {
        	System.out.println("Before");
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
            System.out.println("after");
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/views/Student/Result.jsp").forward(
                    request, response);
        }
    }
}