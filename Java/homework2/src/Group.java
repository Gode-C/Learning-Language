import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyrus on 10/30/15.
 */
public class Group implements IGroup {

    public Group() {
    }

    private String id = new String();
    private ArrayList<IUser> members = new ArrayList<>();
    @Override


    public List<IUser> getUsers() {
        return members;
    }

    @Override
    public void addUser(IUser user) {
        members.add(user);
    }

    @Override
    public void removeUser(IUser user) {

        members.remove(user);
    }

    @Override
    public int getUserCount() {
        return members.size();
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public void setID(String id) {

        this.id = id;
    }

    @Override
    public int compareTo(Identifiable i) {
        return this.getID().compareTo(i.getID());
    }

    @Override
    public String toString(){
        return this.getID();
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof IGroup){
            if (this.toString().equals( o.toString())){
                return true;}
            else{return false;}}
        else{return false;}
    }
}




