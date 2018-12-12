
public class ClassFullException extends Exception {

	public ClassFullException() {
		super ("The class roster is full. No more students can be added.");
	}
	
	public ClassFullException(String message) {
		super (message);
	}

}
