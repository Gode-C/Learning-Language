/* $Id: GradeReader.java,v 1.2 2008/01/28 17:45:08 ekstrand Exp $ */
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class for reading tweets from a data file. Adapted by
 * Jacob Thebault-Spieker <thebault@cs.umn.edu>
 * from the original GradeReader class by:
 * @author Michael Ekstrand <ekstrand@cs.umn.edu>
 *
 */
public class TwitterReader {
    private Scanner scanner;
    
    private boolean valid;
    private String curID;
    private String curTweet;
    private String fileName;
    
    /**
     * Construct a new TwitterReader to read Twitter data from a file.
     * @param filename The file to read Twitter data from.
     */
    public TwitterReader(String fileName) {

        valid = false;
        this.fileName = fileName;

        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            // convert the exception to a runtime exception so the client doesn't
            // need exception handling
            throw new RuntimeException(e);
        }
    }

    /**
     * Starts things over again from the beginning
     */
    public void reset(){
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Advances the Twitter reader to the next tweet.
     * @return {@code true} if there is another user/tweet pair to access, false
     * otherwise.
     */
    public boolean advance() {
        valid = false;
        try {
            curID = scanner.next();
            curTweet = scanner.nextLine();
            valid = true;
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    /**
     * Get the current student's ID.
     * @return The ID of the current twitter user
     */
    public String getTweeterID() {
        assertValid();
        return curID;
    }
    
    public String getTweet() {
    	assertValid();
    	return curTweet;
    }
    
    public boolean isMore() {
    	assertValid();
    	return scanner.hasNext();
    }
    
    public String[] getMNTwitterList() {
    	String[] ret =   {"Cargill", "nine2fives", "TeacherJobMN", "UMMorris", "Jessy__Fox", "TimPostMPR"};
    	return ret;
    }
   

    private void assertValid() {
        if (!valid)
            throw new RuntimeException("Tweet reader not in valid state.");
    }
}
