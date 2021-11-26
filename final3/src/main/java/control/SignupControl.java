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
 * Servlet implementation class SignupControl
 */
@WebServlet("/signup")
public class SignupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO signupDao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupControl() {
    	signupDao = new DAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	 String user = request.getParameter("user");
         String pass = request.getParameter("pass");
         String repass = request.getParameter("repass");
         if (!pass.equals(repass)) {
         	request.setAttribute("passcheck", "password and re-password not the same!!");
         	RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
             dispatcher.forward(request, response);
         } else {
        	    if(signupDao.accountcheck(user)) {
        	    	request.setAttribute("usercheck", "user already exit !!!!!");
        	    	RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                    dispatcher.forward(request, response);
        	    }
        	    else {
         		useraccount users = new useraccount();
				users.setuName(user); 
				users.setuPass(pass);
				users.setIsAdmin(0); 
				users.setIsSeller(0);
				 
         		
         		signupDao.saveUser(users);
         		request.setAttribute("confirm", "successful registration, please login with your account");
         		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                 dispatcher.forward(request, response);
        	    }
         }
        	
        	
        
    	    
    }

     protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	 doGet(request, response);
    	    }
    

}
