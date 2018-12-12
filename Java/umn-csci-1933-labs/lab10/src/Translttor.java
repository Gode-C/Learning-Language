import java.util.HashMap;
import java.util.Map;

/**
 * Created by chen3736 on 11/17/15.
 */
public class Translttor {





    public static void main(String[]args) {


        if (args.length == 0) {
            System.exit(1);
            System.out.println("Error");
            }

        String sentence = "";
//        Map<String,String> mymap  = new HashMap<>(99);

        MyHashMap mymap = new MyHashMap();
        DictionaryReader myreader = new DictionaryReader("./Dictionary.txt");

        while(myreader.advance()){

            mymap.put(myreader.getKey(),myreader.getValue());

        }
        for(String i : args){
            if (mymap.containsKey(i)) {
                if (sentence.equals("")) {
                    sentence += mymap.get(i);
                } else {
                    sentence += " " + mymap.get(i);
                }
            }
            else{System.exit(1);}
            }


        for (KeyValuePair i:mymap.mylist)
        System.out.println(i);
        }

    }















