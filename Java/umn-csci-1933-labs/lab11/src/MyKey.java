
public class MyKey {
	private int theInteger;
	
	public MyKey(int theInteger) {
		this.theInteger = theInteger;
	}
	
	public boolean equals(Object o) {
		return theInteger == ((MyKey) o).theInteger;
	}
	
	public int hashCode() {
		return theInteger;
	}
	
	public String toString() {
		return Integer.toString(theInteger);
	}

}
