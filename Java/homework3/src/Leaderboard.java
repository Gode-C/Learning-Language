import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Leaderboard {


	/**
	 * This is the main method for Leaderboard, where the output of the leaderboard occurs. Some of your logic will
	 * need to be implemented here.
	 * @param args
	 */
	
	public static void main(String[] args) {

		SortedList<Participant> getlist = readParticipantData("dat/participants.dat");
		ArrayList<Participant> mylist = new ArrayList<>(getlist.toList());
		Collections.sort(mylist, new NameComparator());


		System.out.println("sort_by_scores:");

		for (Participant k : getlist.toList()) {
			System.out.println(k);
		}


		System.out.println("sort_by_names:");

		for (Participant k : mylist){
				System.out.println(k);
		}


	}

	/**
	 * This method will take a filter as input, use it to filter the Entrys of all Participants.
	 * It will add the Entrys that pass to a new list and use Participant's setFilteredList()
     * to assign the list of filtered entries to the participant.
	 * 
	 * It will also call the Participant's computeAndSetFilteredScore() and setQualification() methods
	 * to properly re-calculate score and qualification values for the given Participant
	 * 
	 * @param filter - the filter by which to filter the 
	 * @param l - the list of participants who's entries should be filtered
	 * @return the list of Participants after having the filter applied (that is, a list that contains only the Participants that passed the filter).
	 */
	public static List<Participant> applyFilter(Filter filter, List<Participant> l) {
		//TODO you will need to implement this method
		return null;
	}

	/**
	 * This method will read the Participant and Entry data from the LeaderboardReader, and do the proper thing with the returned object.
	 * This means:
	 * 	- for Participant, wait until all of the Entrys have been read, then insert into the SortedList
	 * 	- for Entry, add to the associated Participant's listOfEntries
	 * 	- for a blank String line, move on to the next record
	 *
	 * @param filename - the name of the file that the LeaderboardReader will read from
     * @return The SortedList containing participants
	 */
	public static SortedList<Participant> readParticipantData(String filename) {

		SortedList<Participant> myplayers = new SortedList<>();
		Participant current = null;

		LeaderboardReader myreader = new LeaderboardReader(filename);
		Boolean nextline = myreader.advance();

		while(nextline){

			Object thisline = myreader.getRecord();

			if (thisline instanceof Participant){


				nextline = myreader.advance();
				current = (Participant)thisline;

			}
			else if (thisline instanceof Entry){


				current.addEntry((Entry) thisline);
				nextline = myreader.advance();
			}
			else if (thisline == ""){

				current.computeAndSetAverageScore();
				myplayers.add(current);



				nextline = myreader.advance();
			}
		}




		return myplayers;
	}

	/**
	 * This method will compute the global average across all Participants included in the parameter list. This will entail:
	 * 	- a sum of all the scores from each Entry, for all Participants
	 * 	- a total number of scores (or of Entrys)
	 * 	- dividing the sum of all scores by the number of Entrys
	 *
	 * @param list - the list of Participants for which to compute a global average
	 * @return the average score of all Participants
	 */
	public static double computeGlobalAverage(List<Participant> list) {
		//TODO you will need to implement this method
		return 0;
	}
}


