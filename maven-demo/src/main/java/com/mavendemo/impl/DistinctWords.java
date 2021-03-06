package com.mavendemo.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.SortedSet;

import org.apache.log4j.Logger;

public class DistinctWords {
	
	private static final Logger LOGGER = Logger.getLogger(DistinctWords.class);
	private static SortedSet<String> set = new TreeSet<>();
	
	public void readFile() {	
		
		ClassLoader classLoader = DistinctWords.class.getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("INTERVIEW.txt");
		
		try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
			String line = "";
			while ( ( line = bufferedReader.readLine()) != null ) {
				findDistinctWord(line);
			}
		} catch (FileNotFoundException e1) {
			LOGGER.error(e1.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		} 
		
	}
	
	public void findDistinctWord(String line) {
		String[] words = line.split(" ");
		for (String word : words) {
			if (word.matches("[a-zA-Z]+")) set.add(word);
		}
	}
	
	
	public void display() {
		for (String word : set) {
			LOGGER.info(word);
		}
	}

	public static void main(String[] args) {
		
		DistinctWords distinctWords = new DistinctWords();
		distinctWords.readFile();
		distinctWords.display();

	}

}
