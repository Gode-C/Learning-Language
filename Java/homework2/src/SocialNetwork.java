import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SocialNetwork {
	private List<Identifiable> users;
	private List<Identifiable> groups;
	
	public SocialNetwork() {
		users = new ArrayList<Identifiable>();
		groups = new ArrayList<Identifiable>();
		
	}
	
	public IGroup getGroup(String groupID) {
		return (IGroup)groups.get(findIndex(groupID,groups));
	}
	
	public int getUserCount() {
		return users.size();
	}
	
	public int getGroupCount() {
		return groups.size();
	}
	
	public IUser getUser(String userID) {
		return (IUser)users.get(findIndex(userID,users));
	}
	
	public IUser getUser(int i) {
		return (IUser)users.get(i);
	}
	
	public IGroup getGroup(int i) {
		return (IGroup)groups.get(i);
	}
	
	public void addGroups(List<IGroup> gs) {
		for (int i = 0; i < gs.size(); ++i) {
			this.addGroup(gs.get(i));
		}
	}
	
	public int addGroup(IGroup group) {
		if (groups.isEmpty()) {
			groups.add(group);
			return 0;
		} else {
			int i = findIndex(group.getID(),groups);
			groups.add(i,group);
			return i;
		}
	}
	
	public void addUsers(List<IUser> us) {
		for (int i = 0; i < us.size(); ++i) {
			this.addUser(us.get(i));
		}
	}
	
	public int addUser(IUser user) {
		if (users.isEmpty()) {
			users.add(user);
			return 0;
		} else {
			int i = findIndex(user.getID(),users);
			users.add(i,user);
			return i;
		}
	}
	
	public List<IUser> recommendUsersToFollow(IUser user, double minCoefficient) {

		ArrayList<IUser> potentialUsersToRecommen = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		ArrayList<Integer> countgoup = new ArrayList<>();
		ArrayList<IUser> recommendedUser = new ArrayList<>();
		for (IUser k : user.getFollowedUsers()){
			for (IUser t : k.getFollowedUsers()) {
				if (user.equals(t)){}
				else if (user.getFollowedUsers().contains(t)){}
				else {
					if (potentialUsersToRecommen.contains(t)){
						count.set(potentialUsersToRecommen.indexOf(t)
								, count.get(potentialUsersToRecommen.indexOf(t))+1);
					}
					else {potentialUsersToRecommen.add(t);
						count.add(1);
						countgoup.add(0);
				}}}}
		for (IUser fof : potentialUsersToRecommen){
			for (IGroup gog : fof.getGroups()){
				for (IUser moo : gog.getUsers()){
					if (user.getFollowedUsers().contains(moo)){
						countgoup.set(potentialUsersToRecommen.indexOf(fof)
								,countgoup.get(potentialUsersToRecommen.indexOf(fof))+1);
					}
				}
			}
		}
		for (IUser po : potentialUsersToRecommen){
			if ((double)count.get(potentialUsersToRecommen.indexOf(po))
					+ countgoup.get(potentialUsersToRecommen.indexOf(po)*5/user.getFollowedUsers().size())
					/user.getFollowedUsers().size() > minCoefficient){
				recommendedUser.add(po);
			}
		}
		return recommendedUser;
	}

	private static int findIndex(String id, List<Identifiable> list) {
		//binary search to add users in order
		int startIndex = 0;
		int endIndex = list.size();
		int midIndex;
		while (startIndex < endIndex) {
			midIndex = (startIndex + endIndex) / 2;
			Identifiable other = list.get(midIndex);
			//If someone accidently added  null to the list, it should go to the end.
			int compValue = other != null ? id.compareTo(other.getID()) : -1;
			if (compValue == 0) {
				//The user already exists in users list
				return midIndex;
			} else if (compValue > 0) {
				startIndex = midIndex + 1;
			} else {
				endIndex = midIndex;
			}
		}
		return endIndex;
	}
	
	public static void main(String[] args) {
		try {
			//set up our network
			SocialNetwork sn = new SocialNetwork();
			DataReader dr = new DataReader("network.dat");
			dr.readDataSet();
			sn.addUsers(dr.getUserList());
			sn.addGroups(dr.getGroupList());
			
			//process the twitter data
			TweetReader tr = new TweetReader("tweets.dat");
			while (tr.advance()) {
				sn.getUser(tr.getTweeterID()).tweeted(tr.getTweet());
			}
			
			//gather personal info
			IUser lt = sn.getUser("lorenterveen");
			List<IUser> friends = lt.getFollowedUsers();
			List<IGroup> groups = lt.getGroups();
			
			// print out user data
			System.out.format("The social network has %d users, and %d groups.\n", sn.getUserCount(), sn.getGroupCount());
			System.out.format("%s has %d friends and is in %d groups\n", lt, friends.size(), groups.size());
			
			System.out.println();
			
			for (IUser friend : friends) {
				System.out.format("%s => %s\n", friend, friend.getLastTweet());
			}
			
			System.out.println();
		} catch (Exception e) {
			// panic - and tell us about it
			e.printStackTrace();
		}
	}
}
