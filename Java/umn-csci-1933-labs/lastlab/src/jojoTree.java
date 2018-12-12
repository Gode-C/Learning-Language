import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by chen3736 on 12/8/15.
 */
public class jojoTree {

    private ArrayList<Integer> numberlistist;
    private ArrayList<String> operationlist;

    public jojoTree(String numbs){

        this.numberlistist = new ArrayList<Integer>();
        this.operationlist = new ArrayList<String>();
        for (char ch: numbs.toCharArray()){
            if (("1,2,3,4,5,6,7,8,9,0").contains(String.valueOf(ch))){
                this.numberlistist.add((String.valueOf(ch)));
            }
            else {
                System.out.println("bad input, try again");
                System.exit(0);
            }
        }
    }

    public Integer meargeit(ArrayList<Integer> arr){

        List<Integer> myhead = arr.subList(0,(arr.size()/2));
        List<Integer> mytile = arr.subList((arr.size()/2+1),arr.size());

        if (arr.size()==1){

            return (mylist.get(0));
        }
        else{}




    }





}
