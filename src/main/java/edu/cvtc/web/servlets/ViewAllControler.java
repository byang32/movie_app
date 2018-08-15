package edu.cvtc.web.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.comparators.DirectorComparator;
import edu.cvtc.web.comparators.LengthInMinutesComparator;
import edu.cvtc.web.comparators.TitleComparator;
import edu.cvtc.web.dao.MoviesDao;
import edu.cvtc.web.dao.impl.MoviesDaoException;
import edu.cvtc.web.dao.impl.MoviesDaoImpl;
import edu.cvtc.web.model.Movies;

/**
 * Servlet implementation class ViewAllControler
 */
@WebServlet("/ViewAll")
public class ViewAllControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String target = null;
		
		try {
			final MoviesDao moviesDao = new MoviesDaoImpl();
			final List<Movies> cinema = moviesDao.retrieveCinema();	
	
		final String sortType = request.getParameter("sortType");
		
		if (sortType != null) {
			
			sortCinema(cinema, sortType);
		}
		request.setAttribute("cinema", cinema);
		
		target = "view-all.jsp";
		
		} catch (MoviesDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
	}


	private void sortCinema(final List<Movies> people, final String sortType) {
		switch (sortType) {
		case "title":
			Collections.sort(people, new TitleComparator());
			break;
			
		case "director":
			Collections.sort(people, new DirectorComparator());
			break;
			
		case "lengthInMinutes":
			Collections.sort(people, new LengthInMinutesComparator());
			break;
			
		default:
			break;
			
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
