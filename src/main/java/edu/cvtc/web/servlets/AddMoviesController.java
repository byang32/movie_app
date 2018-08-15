package edu.cvtc.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import edu.cvtc.web.dao.MoviesDao;
import edu.cvtc.web.dao.impl.MoviesDaoException;
import edu.cvtc.web.dao.impl.MoviesDaoImpl;
import edu.cvtc.web.model.Movies;

/**
 * Servlet implementation class AddMoviesController
 */
@WebServlet("/AddMovies")
public class AddMoviesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final String title = request.getParameter("title");
			final String director = request.getParameter("director");
			final String lengthInMinutesString = request.getParameter("lengthInMinutes");
			
			// Validate our data
			if (Strings.isNullOrEmpty(title) 
					|| Strings.isNullOrEmpty(director) 
					|| Strings.isNullOrEmpty(lengthInMinutesString)) {
				
				request.setAttribute("message", "You must complete all fields to submit the form.");
				target = "error.jsp";
				
			} else {
				
				final int lengthInMinutes = Integer.parseInt(lengthInMinutesString);
				
				final MoviesDao moviesDao = new MoviesDaoImpl();
				
				final Movies movies = new Movies(title, director, lengthInMinutes);
				
				moviesDao.insertMovies(movies);
				
				request.setAttribute("message", "The movie has been added to the database.");
				target = "success.jsp";
				
			}
					
			
		} catch (MoviesDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
