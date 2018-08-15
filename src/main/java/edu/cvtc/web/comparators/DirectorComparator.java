/**
 * 
 */
package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Movies;

/**
 * @author beeyang
 *
 */
public class DirectorComparator implements Comparator<Movies>{

	@Override
	public int compare(Movies director1, Movies director2) {
		
		return director1.getDirector().compareTo(director2.getDirector());
	}

}
