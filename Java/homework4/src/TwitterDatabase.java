import java.util.*;

/**
 * Created by cyrus on 11/30/15.
 */
public class TwitterDatabase {

    private Map <String,TwitterUser> name2User;
    private Map<Tweet,TwitterUser> tweet2User;
    private Map<String,Set<Tweet>> word2Tweet;
    private Map<TwitterUser,Set<Tweet>> user2Tweet;
    private long time;

    public TwitterDatabase(String datfile){
        TweetReader myreader = new TweetReader(datfile);
        this.name2User=new HashMap<>();
        this.tweet2User=new HashMap<>();
        this.word2Tweet=new HashMap<>();
        this.user2Tweet=new HashMap<>();

        while(myreader.advance()){
            myreader.advance();
            this.addTweet(myreader.getTweet(),this.addOrGetUser(myreader.getTweeterID()));
        }
    }
    public TwitterDatabase(String datfile,Map<String,TwitterUser> name2User,Map<Tweet,TwitterUser> tweet2User,
                           Map<String,Set<Tweet>> word2Tweet,Map<TwitterUser,Set<Tweet>> user2Tweet){
        TweetReader myreader = new TweetReader(datfile);
        this.name2User=name2User;
        this.tweet2User=tweet2User;
        this.word2Tweet=word2Tweet;
        this.user2Tweet=user2Tweet;

        while(myreader.advance()) {

            myreader.advance();

            addOrGetUser(myreader.getTweeterID());

            addTweet(myreader.getTweet(), this.addOrGetUser(myreader.getTweeterID()));


        }
    }

    public int addWord(String word, Tweet tweet){

        if(word2Tweet.containsKey(word)){

            word2Tweet.get(word).add(tweet);

            return word2Tweet.get(word).size();
        }
        else{


            Set<Tweet> newset = new HashSet<>();

            newset.add(tweet);

            word2Tweet.put(word, newset);

            return 1;
        }
    }
    public Tweet addTweet(String msg,TwitterUser user){

        Tweet newTweet = new Tweet(msg);

        tweet2User.put(newTweet, user);

        user2Tweet.get(user).add(newTweet);


        for(String word: newTweet.getWords()){
            addWord(word,newTweet);
        }
        return newTweet;
    }


    public Map<String,TwitterUser> getNameTable(){
        return this.name2User;}
    public Map<Tweet,TwitterUser> getTweetTable(){
        return this.tweet2User;}
    public Map<String,Set<Tweet>> getWordTable(){
        return this.word2Tweet;}
    public Map<TwitterUser,Set<Tweet>> getUserTable(){
        return this.user2Tweet;}



    public TwitterUser addOrGetUser(String name){

        if(name2User.containsKey(name)){
            return name2User.get(name);
        }
        else {
            TwitterUser newuser = new TwitterUser(name);
            name2User.put(name, newuser);

            HashSet<Tweet> newset = new HashSet<>();
            user2Tweet.put(newuser,newset);
            return newuser;
        }
    }

    // PART 2 //

    public List<ItemCount> getTweetCounts(){
        long start=System.currentTimeMillis();
        List<ItemCount> tweetCounts=new ArrayList<>();
        for(TwitterUser curUser:getUserTable().keySet()){
            ItemCount curCount=new ItemCount(curUser,getUserTable().get(curUser).size());
            tweetCounts.add(curCount);
        }
        Collections.sort(tweetCounts);
        this.setTime(System.currentTimeMillis()-start);
        return tweetCounts;
    }


    public List<ItemCount> getWordCounts() {
        long start=System.currentTimeMillis();
        List<ItemCount> wordCounts = new ArrayList<>();
        for (String word : getWordTable().keySet()) {
            ItemCount curCount = new ItemCount(word, getWordTable().get(word).size());
            wordCounts.add(curCount);
        }
        Collections.sort(wordCounts);
        this.setTime(System.currentTimeMillis()-start);
        return wordCounts;
    }


    public List<ItemCount> getWordUsage(String word){
        long start=System.currentTimeMillis();
        word=word.toLowerCase();
        List<ItemCount> wordUsage=new ArrayList<>();
        for(TwitterUser curUser:getUserTable().keySet()){
            int count=0;
            for(Tweet curTweet:getUserTable().get(curUser)){

                    if(curTweet.getWords().contains(word)){
                        count++;
                }
            }
            ItemCount curCount=new ItemCount(curUser,count);
            wordUsage.add(curCount);
        }
        Collections.sort(wordUsage);
        this.setTime(System.currentTimeMillis()-start);

        return wordUsage;
    }

    public static  void main(String[]args){

        System.out.println("-- Part 1 --");
        TwitterDatabase database=new TwitterDatabase("dat/uofmtweets.dat");
        System.out.format("name tale size = %d\n",database.getNameTable().size());
        System.out.format("tweet table size = %d\n",database.getTweetTable().size());
        System.out.format("word table size = %d\n",database.getWordTable().size());
        System.out.format("user table size = %d\n",database.getUserTable().size());
        System.out.println("\n-- Part 2 --");
        System.out.println("Top 10 results of getTweetCounts\n");
        for(int i=0;i<10;i++){
            System.out.println(database.getTweetCounts().get(i));
        }
        System.out.println("\nTop 10 results of getWordCounts");
        for(int i=0;i<10;i++){
            System.out.println(database.getWordCounts().get(i));
        }
        System.out.println("\nTop 10 results of getWordUsage(\"minnesota\")");
        for(int i=0;i<10;i++){
            System.out.println(database.getWordUsage("minnesota").get(i));
        }
        System.out.println("\nTop 10 results of getWordUsage(\"university\")");
        for(int i=0;i<10;i++){
            System.out.println(database.getWordUsage("university").get(i));
        }


        // Part 3


        System.out.println("\n-- Part 3 --");
        TwitterDatabase treebase=new TwitterDatabase("dat/uofmtweets.dat",new TreeMap<String,TwitterUser>(),new TreeMap<Tweet,TwitterUser>(),
                new TreeMap<String,Set<Tweet>>(),new TreeMap<TwitterUser,Set<Tweet>>());

        TwitterDatabase linearscanbase=new TwitterDatabase("dat/uofmtweets.dat",new LinearScanMap<String,TwitterUser>(),new LinearScanMap<Tweet,TwitterUser>(),
                new LinearScanMap<String,Set<Tweet>>(),new LinearScanMap<TwitterUser,Set<Tweet>>());



        System.out.println("HashMap");

        database.getTweetCounts();
        System.out.format("getTweetCounts() took %dms to execute.\n", database.getTime());
        database.getWordCounts();
        System.out.format("getWordCounts() took %dms to execute.\n", database.getTime());
        database.getWordUsage("minnesota");
        System.out.format("getWordUsage(\"minnesota\") took %dms to execute.\n", database.getTime());
        database.getWordUsage("university");
        System.out.format("getWordUsage(\"university\") took %dms to execute.\n", database.getTime());

        System.out.println("TreeMap");

        treebase.getTweetCounts();
        System.out.format("getTweetCounts() took %dms to execute.\n",treebase.getTime());
        treebase.getWordCounts();
        System.out.format("getWordCounts() took %dms to execute.\n",treebase.getTime());
        treebase.getWordUsage("minnesota");
        System.out.format("getWordUsage(\"minnesota\") took %dms to execute.\n",treebase.getTime());
        treebase.getWordUsage("university");
        System.out.format("getWordUsage(\"university\") took %dms to execute.\n",treebase.getTime());


        System.out.println("LinearScanMap");

        linearscanbase.getTweetCounts();
        System.out.format("getTweetCounts() took %dms to execute.\n",linearscanbase.getTime());
        linearscanbase.getWordCounts();
        System.out.format("getWordCounts() took %dms to execute.\n",linearscanbase.getTime());
        linearscanbase.getWordUsage("minnesota");
        System.out.format("getWordUsage(\"minnesota\") took %dms to execute.\n",linearscanbase.getTime());
        linearscanbase.getWordUsage("university");
        System.out.format("getWordUsage(\"university\") took %dms to execute.\n",linearscanbase.getTime());

    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
