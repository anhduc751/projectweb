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
 * Servlet implementation class CategoryControl
 */
@WebServlet("/Category")
public class CategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO productDao;
	private DAO categoryDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryControl() {
    	 productDao = new DAO();
         categoryDao = new DAO();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		List<Product> listProductByCate = new ArrayList<Product>();
		listProductByCate = productDao.listProductByCate(Integer.parseInt(cid));
        request.setAttribute("listProduct", listProductByCate);
        List<Category> listCategory = new ArrayList<Category>();
		listCategory = categoryDao.listAllCategory();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
        dispatcher.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
