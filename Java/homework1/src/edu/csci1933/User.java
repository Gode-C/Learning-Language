package edu.csci1933;

/**
 * Created by chen1 on 9/30/2015.
 */
public class User {
    public String username;
    public int tweet_numbers=0;
    public int tweet_create_numbers=0;
    public int tweet_retweetfromothers_numbers=0;
    public int tweet_retweetedbyothers_numbers=0;
    public int tweetCount=0;
    public int[] userdata;

    public User(String username) {
        this.username = username;
    }

    public boolean is_tweet(String a) {
        if (a.equals(username)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean is_retweetfromothers(String a,String b) {
        if (this.is_tweet(a) && b.contains("RT")) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean is_tweet_create (String a,String b) {
        if (this.is_tweet(a) && this.is_retweetfromothers(a,b)==false) {
            return true;
        } else {
            return false;
        }
    }

    public boolean is_tweet_retweetbyothers(String b) {
        String c="RT"+" "+"@"+username;
        if (b.contains(c)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void userbehavior(TweetReader tweetReader) {
        while (tweetReader.advance()) {
            String a=tweetReader.getTweeterID();
            String b=tweetReader.getTweet();
            if (this.is_tweet(a)) {
                this.tweet_numbers++;
            }
            if (this.is_tweet_create(a, b)) {
                this.tweet_create_numbers++;
            }
            if (this.is_retweetfromothers(a, b)) {
                this.tweet_retweetfromothers_numbers++;
            }
            if (this.is_tweet_retweetbyothers(b)) {
                this.tweet_retweetedbyothers_numbers++;
            }
            this.tweetCount++;

        }
        int[] userdata=new int[5];
        userdata[0]=this.tweet_numbers;
        userdata[1]=Math.round((float) this.tweet_numbers / tweetCount * 100);
        userdata[2]=this.tweet_create_numbers;
        userdata[3]=this.tweet_retweetfromothers_numbers;
        userdata[4]=this.tweet_retweetedbyothers_numbers;
    }

    public String getUsername() {
        return username;
    }

    public int getTweet_numbers() {
        return tweet_numbers;
    }

    public int getTweet_create_numbers() {
        return tweet_create_numbers;
    }

    public int getTweet_retweetfromothers_numbers() {
        return tweet_retweetfromothers_numbers;
    }

    public int getTweet_retweetedbyothers_numbers() {
        return tweet_retweetedbyothers_numbers;
    }

    public int getTweetCount() {
        return tweetCount;
    }

    public int[] getUserdata() {
        return userdata;
    }
}
