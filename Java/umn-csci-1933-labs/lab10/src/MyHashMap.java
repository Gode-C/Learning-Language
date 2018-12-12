import java.util.*;

/**
 * Created by chen3736 on 11/17/15.
 */
public class MyHashMap {


    LinkedList<KeyValuePair> mylist = new LinkedList<>();



    public boolean containsKey(Object o) {
        int i = 0;
        for (KeyValuePair ii : mylist){
            if (ii.getKey()==o){
                i=1;
            }
        }
        return i==1;
    }

    public Object get(Object o) {
        String i= "";

        for (KeyValuePair ii : mylist){
            if (ii.getKey()==o) {
                i = ii.getValue();
            }}

        if(i.equals("")){return null;}
        else {
        return i;
    }}



    public Object put(String  o, String  o2) {
        KeyValuePair newpair = new KeyValuePair(o,o2);
        mylist.add(newpair);

        return null;
    }}
