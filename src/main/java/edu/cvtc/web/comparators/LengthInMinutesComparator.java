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
public class LengthInMinutesComparator implements Comparator<Movies>{

	@Override
	public int compare(Movies lengthInMinutes1, Movies lengthInMinutes2) {
		
		return lengthInMinutes1.getlengthInMinutes().compareTo(lengthInMinutes2.getlengthInMinutes());
	}

}
