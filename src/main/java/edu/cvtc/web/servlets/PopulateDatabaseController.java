package edu.cvtc.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.MoviesDao;

import edu.cvtc.web.dao.impl.MoviesDaoException;
import edu.cvtc.web.dao.impl.MoviesDaoImpl;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * Servlet implementation class PopulateDatabaseController
 */
@WebServlet("/PopulateDatabase")
public class PopulateDatabaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String target = null;
		
		try {
			final String filePath = getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
			final MoviesDao moviesDao = new MoviesDaoImpl();
			
			moviesDao.populate(filePath);
			
			request.setAttribute("message", "Database populated...");
			target = "success.jsp";
			
		} catch (MoviesDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
