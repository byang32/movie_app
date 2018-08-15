/**
 * 
 */
package edu.cvtc.web.dao;

import java.util.List;

import edu.cvtc.web.dao.impl.MoviesDaoException;
import edu.cvtc.web.model.Movies;



/**
 * @author beeyang
 *
 */
public interface MoviesDao {

	void populate(String filePath) throws MoviesDaoException;
	
	List<Movies> retrieveCinema() throws MoviesDaoException;
	
	void insertMovies(Movies movies) throws MoviesDaoException;
	
}
