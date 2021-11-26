package control;

import dao.DAO;
import entity.*;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/Login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO loginDao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
    	loginDao = new DAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (loginDao.validate(username, password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
            dispatcher.forward(request, response);
        } else {
        	request.setAttribute("mess", "wrong user or password");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        }
    	    
    }

    	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	    	doGet(request, response);
    	    }

    	   

}
