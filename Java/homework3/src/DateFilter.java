public class DateFilter implements Filter {

	private int start_month;
	private int start_day;
	private int end_month;
	private int end_day;
	
	/**
	 * Constructor that takes the date range for the filter
	 * 
	 * @param smonth the start month for the filter
	 * @param sday the start day for the filter
	 * @param emonth the end month for the filter
	 * @param eday the end day for the filter
	 */
	public DateFilter(int smonth, int sday, int emonth, int eday) {
		//TODO you will need to implement this method
	}
	
	/**
	 * Constructor that takes the beginning date for the filter, and sets the end date to the last day of the year (December 31)
	 * 
	 * @param smonth start month for the filter
	 * @param sday end month for the filter
	 */
	public DateFilter(int smonth, int sday) {
		//TODO you will need to implement this method
	}

	/**
	 * Defines whether or not the Entry is within a date range, where the start and end dates are inclusive
	 * @param e a given Entry
	 * @return boolean if the Entry matches the date range, false otherwise
	 */
	public Boolean filter(Entry e) {
		//TODO you will need to implement this method
		return false;
	}

}
