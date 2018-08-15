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
public class TitleComparator implements Comparator<Movies>{

	@Override
	public int compare(Movies title1, Movies title2) {

		return title1.getTitle().compareTo(title2.getTitle());
	}

}
