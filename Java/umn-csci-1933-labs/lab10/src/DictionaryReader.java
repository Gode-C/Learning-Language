import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Random;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class DictionaryReader {
	private Scanner scanner;

	private boolean valid;
	private String key;
	private String value;

	public DictionaryReader(String filename) {
		valid = false;
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}

	public boolean advance() {
		valid = false;
		try {
			key = scanner.next().trim();
			value = scanner.nextLine().trim();
		
			valid = true;
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public String getKey() {
		assertValid();
		return key;
	}

	public String getValue() {
		assertValid();
		return value;
	} 
	
	public boolean isMore() {
		return scanner.hasNext();
	}

	private void assertValid() {
		if (!valid)
			throw new RuntimeException("Media reader not in valid state.");
	}
	
	public static void main(String[] args) {
		DictionaryReader m = new DictionaryReader("./Dictionary.txt");
		while (m.advance()) {
			System.out.println(m.getKey() + " -> " + m.getValue());
		}
	}
}
