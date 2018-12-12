import java.util.ArrayList;

/**
 * Created by chen3736 on 9/29/15.
 */
public class Lab3 {
    public static void main(String args[]){

        String thisTw;
        String thisId;
        int numumn;
        numumn=0;
        int numgop;
        numgop=0;
        Integer numoftw;
        numoftw = 0;
        String[] thisGroup;
        TwitterReader myreader= new TwitterReader("tweets.dat");
        Integer[] numofTwBygroup = {0,0,0,0,0,0};
        thisGroup = myreader.getMNTwitterList();

        while(myreader.advance()){
            thisTw = myreader.getTweet();
            thisId = myreader.getTweeterID();
            if(thisTw.contains("Twin Cities") || thisTw.contains("gophers")){
                numoftw++;
                if (thisTw.contains("Twin Cities")){
                    numumn++;
                }
                if (thisTw.contains("gophers")){
                    numgop++;
                }
                for(int i = 0; i < numofTwBygroup.length;i++){
                    if (thisGroup[i].equals(thisId)){
                        numofTwBygroup[i]++;
                    }
                }
            }
        }
        System.out.println("Twin Cities: "+numumn+"\nGopher: "+numgop);
        for (int i = 0 ; i < numofTwBygroup.length;i++){
            System.out.println(thisGroup[i]+" - "+numofTwBygroup[i]/numoftw+"%");
        }
    }


}


