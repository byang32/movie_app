/**
 * 
 */
package edu.cvtc.web.model;

import java.io.Serializable;

/**
 * @author beeyang
 *
 */
public class Movies implements Serializable{

	private static final long serialVersionUID = 7382200546916256306L;
	
	private String title;
	private String director;
	private Integer lengthInMinutes;
	
	
	public Movies() {
		
	}
	
	public Movies(final String title, final String director, final int lengthInMinutes) {

		this.title = title;
		this.director = director;
		this.lengthInMinutes = lengthInMinutes;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getlengthInMinutes() {
		return lengthInMinutes;
	}

	public void setlengthInMinutes(Integer lengthInMinutes) {
		this.lengthInMinutes = lengthInMinutes;
	}

	@Override
	public String toString() {
		return "Movies [title=" + title + ", director=" + director + ", lengthInMinutes=" + lengthInMinutes + "]";
	}
	
	
	}

