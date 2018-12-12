import com.sun.org.apache.bcel.internal.generic.IUSHR;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyrus on 10/30/15.
 */
public class User implements IUser {

    private String id = new String();
    private ArrayList<IUser> followed = new ArrayList<>();
    private  ArrayList<IGroup> ingroup = new ArrayList<>();
    private  ArrayList<String> tweethis = new ArrayList<>();
    public User(){
    }

    @Override
    public void follow(IUser user) {

        followed.add(user);
    }

    @Override
    public void unfollow(IUser user) {

        followed.remove(user);

    }

    @Override
    public void addToGroup(IGroup group) {

        ingroup.add(group);
        group.addUser(this);

    }

    @Override
    public void removeFromGroup(IGroup group) {

        ingroup.remove(group);
        group.removeUser(this);

    }

    @Override
    public List<IUser> getFollowedUsers() {
        return followed;
    }

    @Override
    public List<IGroup> getGroups() {
        return ingroup;
    }

    @Override
    public List<IUser> getFollowedUsersInGroup(IGroup group) {

        ArrayList<IUser> i = new ArrayList<>();
        for(IUser k : group.getUsers()) {
            if (this.followed.contains(k)) {
                i.add(k);
            }
        }
        return i;
    }

    @Override
    public void tweeted(String tweet) {
        tweethis.add(tweet);
    }

    @Override
    public String getLastTweet() {

        return tweethis.get(tweethis.size()-1);
    }

    @Override
    public List<String> getTweetHistory() {
        return tweethis;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public void setID(String id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return this.getID();
    }

    @Override
    public int compareTo(Identifiable i) {
        return this.getID().compareTo(i.toString());
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof IUser){
            if (this.toString().equals( o.toString())){
                return true;}
            else{return false;}}
        else{return false;}
        }
    }

