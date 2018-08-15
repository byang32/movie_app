/**
 * 
 */
package edu.cvtc.web.dao.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import edu.cvtc.web.dao.MoviesDao;
import edu.cvtc.web.model.Movies;
import edu.cvtc.web.util.DBUtility;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * @author beeyang
 *
 */
public class MoviesDaoImpl implements MoviesDao {

	private static final String DROP_TABLE_MOVIES = "drop table if exists movies;";
	private static final String CREATE_TABLE_MOVIES = "create table movies (id integer primary key autoincrement, title text, director text, lengthInMinutes integer);";
	private static final String SELECT_ALL_FROM_MOVIES = "select * from movies;";
	
	@Override
	public void populate(String filePath) throws MoviesDaoException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_MOVIES);
			statement.executeUpdate(CREATE_TABLE_MOVIES);
			
			final File inputFile = new File(filePath);
			final List<Movies> cinema = WorkbookUtility.retrieveCinemaFromWorkbook(inputFile);
			
			for (final Movies movies : cinema) {
				final String insertValues = "insert into movies (title, director, lengthInMinutes) "
						+ "values ('" + movies.getTitle() + "', "
								+ "'" + movies.getDirector() + "',"
										+ movies.getlengthInMinutes() + ");";
				
				System.out.println(insertValues); // NOTES: Log a message to the Console so we can see the data being added to the DB.
				
				statement.executeUpdate(insertValues);
			}
			
			
		} catch (ClassNotFoundException | SQLException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MoviesDaoException("Error Unable to populate database.");
		
		} finally {
			DBUtility.closeConnections(connection, statement);
		}

	}

	
	@Override
	public List<Movies> retrieveCinema() throws MoviesDaoException {
		// TODO Auto-generated method stub
		final List<Movies> cinema = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_MOVIES);
			
			while(resultSet.next()) {
				final String title = resultSet.getString("title");
				final String director = resultSet.getString("director");
				final int lengthInMinutes = resultSet.getInt("lengthInMinutes");
				
				cinema.add(new Movies(title, director, lengthInMinutes));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new MoviesDaoException("Error Unable to retrieve cinema.");
			
		} finally {
			
		}
		
		return cinema;
	}

	
	@Override
	public void insertMovies(Movies movies) throws MoviesDaoException {
		
		Connection connection = null;
		PreparedStatement insertStatement = null;
		
		try {
			connection = DBUtility.createConnection();
			
			final String sqlStatement = "insert into movies (title, director, lengthInMinutes) values (?,?,?);";
			insertStatement = connection.prepareStatement(sqlStatement);
			
			insertStatement.setString(1, movies.getTitle());
			insertStatement.setString(2, movies.getDirector());
			insertStatement.setInt(3, movies.getlengthInMinutes());
			
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			insertStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MoviesDaoException("Error: Unable to add this movie to the database.");

			
		} finally {
			DBUtility.closeConnections(connection, insertStatement);
		}
		
		
		
	}

}
