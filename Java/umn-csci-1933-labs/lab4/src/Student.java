
/**
 * Simple class representing information about a Student
 * @author terveen
 * @author bhecht
 *
 */
public class Student {

	private String name;
	private int numOfficeVisits;
	
	public Student (String n) {
		name = n;
		numOfficeVisits = 0;
	}
	
	/**
	 * Get the student's name
	 * @return the student's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the number of office hours visit by the student
	 * @return number of visits
	 */
	public int getNumOfficeVisits() {
		return numOfficeVisits;
	}
	
	/**
	 * Increment the number of visits to office hours by 1	
	 */
	public void incrementNumOfficeVisits() {
		numOfficeVisits++;
	}
	
	public String toString() {
		return String.format("%s %d", name, numOfficeVisits);
	}

}
