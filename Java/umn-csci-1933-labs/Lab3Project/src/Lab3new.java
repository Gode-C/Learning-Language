/**
 * Created by chen3736 on 9/29/15.
 */
public class Lab3new {
    private String nowId;
    private String totalTw;
    private String[] thisGroup;
    private Integer[] numofTwBygroup = {0,0,0,0,0,0};
    private TwitterReader myreader = new TwitterReader("tweets.dat");

    public String printbykeywords(String s, String nowId, TwitterReader myreader, Integer[] numofTwBygroup, String[] thisGroup, String totalTw, String keyword) {
        this.nowId = nowId;
        this.myreader = myreader;
        this.numofTwBygroup = numofTwBygroup;
        this.thisGroup = thisGroup;
        this.totalTw = totalTw;
        keyword = s;
        int numofcount;
        numofcount = 0;
        while(myreader.advance()){
            String thisTw;
            String thisId;

            thisTw = this.myreader.getTweet();
            thisId = myreader.getTweeterID();
            if(thisTw.contains(keyword)){
                numofcount++;
                }

            }
        return (keyword+": "+numofcount);
        }

    private String[] printUserCount(String nowId){

        int totalcount;
        totalcount = 0;

        while(myreader.advance()) {
            for (int i = 0; i < numofTwBygroup.length; i++) {
                if (myreader.getMNTwitterList()[i].equals(myreader.getTweeterID())) {
                    numofTwBygroup[i]++;
                }
            }
        }



    }


    public static void main(String args[]){
        TwitterReader myreader = new TwitterReader("tweets.dat");

        Lab3new lab3new = new Lab3new(myreader.getMNTwitterList(),myreader);

        lab3new.printbykeywords("Twin Cities");
        lab3new.printbykeywords("gopher");
        lab3new.printUserCount();


    }





}
W