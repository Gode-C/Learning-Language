import java.util.Comparator;


public class NameComparator implements Comparator<Participant> {

	/**
	 * This method will compare 2 objects, and return a negative value if arg1 comes after arg0 in the list, 
	 * 0 if arg1 and arg0 are the same, 
	 * and a positive value of arg1 goes before arg0 in the list
	 * @param arg0 - argument 1 to compare
	 * @param arg1 - argument 2 to compare
	 * @return a positive value if arg0 > arg1, 0 if arg0 == arg1, a negative value if arg0 < arg1 (follow standard compareTo() structure).
	 */
	public int compare(Participant arg0, Participant arg1) {



		return 	arg0.getName().compareTo(arg1.getName());
	}


}
