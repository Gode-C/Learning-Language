
public class ScoreFilter implements Filter {
	
	private double threshold = 0;

    public ScoreFilter(double threshold) {
        setThreshold(threshold);
    }


	/**
	 * Checks to see if the a given Entry passes the filter
	 * @param e a given Entry
	 * @return true if the Entry score is greater than or equal to the threshold, false otherwise
	 */
	public Boolean filter(Entry e) {
		//TODO you will need to implement this method
		return false;
	}

	/**
	 * 
	 * @param threshold the argument to set to the field of this object
	 */
	public void setThreshold(double threshold) {
		//TODO you will need to implement this method
	}
	
	

}
