/* $Id: GradeReader.java,v 1.2 2008/01/28 17:45:08 ekstrand Exp $ */
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class for reading leaderboard data from a file. Adapted by 
 * @author Jacob Thebault-Spieker <thebault@cs.umn.edu> from the original GradeReader class
 * by:
 * 
 * @author Michael Ekstrand <ekstrand@cs.umn.edu>
 * 
 */
public class LeaderboardReader {
	private Scanner scanner;

	private boolean valid;
	private String record;
	private int which = 0;
	private String[] tmpString;
	private Participant tmpParticipant;
	private Entry tmpEntry;

	/**
	 * Construct a new LeaderboardReader to read the data from a leaderboard
	 * file.
	 * 
	 * @param filename
	 *            The file to read leaderboard data from.
	 */
	public LeaderboardReader(String filename) {
		valid = false;
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			// convert the exception to a runtime exception so the client
			// doesn't
			// need exception handling
			throw new RuntimeException(e);
		}
	}

	/**
	 * Advances the Leaderboard reader to the next record in the file.
	 * 
	 * @return {@code true} if there is another line in the file to access, false
	 *         otherwise.
	 */
	public boolean advance() {
		valid = false;
		try {
			record = scanner.nextLine();
			if (record.matches("^[A-Za-z].*")) {
				which = 1;
				tmpString = record.split(",");
				tmpParticipant = new Participant(tmpString[0], tmpString[1]);
			} else if (record.matches("^[0-9].*")) {
				which = 2;
				tmpString = record.split(",");
				tmpEntry = new Entry(Integer.parseInt(tmpString[0]),
						Integer.parseInt(tmpString[1]),
						Integer.parseInt(tmpString[2]));
			} else {
				//we've reached the end of a record
				which = 0;
			}
			valid = true;
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Get the the current record, or an empty String if there we have completed the Participant
	 * 
	 * @return an Object of type Participant, Entry, or String. 
	 */
	public Object getRecord() {
		assertValid();
		switch (which) {
			case 1:
				return tmpParticipant;
			case 2:
				return tmpEntry;
		}

		return "";
	}

	private void assertValid() {
		if (!valid)
			throw new RuntimeException("Leaderboard Reader not in valid state.");
	}

}
