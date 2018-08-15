package edu.cvtc.web.servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.MoviesDao;
import edu.cvtc.web.dao.impl.MoviesDaoException;
import edu.cvtc.web.dao.impl.MoviesDaoImpl;
import edu.cvtc.web.model.Movies;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/Search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String target = null;
		
		try {
			
			final MoviesDao moviesDao = new MoviesDaoImpl();
			final List<Movies> cinema = moviesDao.retrieveCinema();
			
			final String title = request.getParameter("title");
			
			
			final List<Movies> filterTitle = cinema
												.stream()
												.filter((movies) -> movies.getTitle().equalsIgnoreCase(title))
												.collect(Collectors.toList());
			
			request.setAttribute("cinema", filterTitle);
			
			
			target = "view-all.jsp";
			
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
