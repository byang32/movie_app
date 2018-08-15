package edu.cvtc.web.util;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.sun.media.sound.InvalidFormatException;

import edu.cvtc.web.model.Movies;

public class WorkbookUtility {

	
	public static final String INPUT_FILE = "/assests/Movies.xlsx";

	public static List<Movies> retrieveCinemaFromWorkbook(final File inputFile) throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		
		final List<Movies> cinema = new ArrayList<>();
		
		final Workbook workbook = WorkbookFactory.create(inputFile);
		
		final Sheet sheet = workbook.getSheetAt(0);
		
		for (final Row row : sheet) {
			
			final Cell titleCell = row.getCell(0);
			final Cell directorCell = row.getCell(1);
			final Cell lengthInMinutesCell = row.getCell(2);
			
			final Movies movies = new Movies(titleCell.getStringCellValue().trim(), 
					directorCell.getStringCellValue().trim(), 
					(int)lengthInMinutesCell.getNumericCellValue());
			
			// NOTES: add each new Person to our List of people
			cinema.add(movies);
		}
		
		return cinema;
		
	}
}
