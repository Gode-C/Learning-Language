package edu.csci1933;

/**
 * Created by chen1 on 9/29/2015.
 */
public class TweetProcessor {
    public User[] userlist;

    public TweetProcessor(User[] userlist) {
        this.userlist = userlist;
    }

    private int findbestone() {
        int index_best =0;
        double a=0;
        for (int i = 0; i <userlist.length;i++){
            EvaluateUser evaluateUser=new EvaluateUser(userlist[i]);
            double money=evaluateUser.getTotalmoney();
            if (a<money) {
                index_best=i;
                a=money;
            }
        }
        return index_best;
    }

    public void printerall() {
        double total_money=0;
        double total_tweetmoney=0;
        double total_retweetmoney=0;
        double total_retweetedmoeny=0;

        for (int i = 0; i < userlist.length; i++) {
            EvaluateUser evaluate = new EvaluateUser(userlist[i]);
            if (i == this.findbestone()) {
                double extramoney = 0.05 * (userlist[i].getTweet_numbers());
                total_money=total_money+extramoney;
            }
            total_tweetmoney=total_tweetmoney+evaluate.getOriginal_money();
            total_retweetmoney=total_retweetmoney+evaluate.getRetweet_money();
            total_retweetedmoeny=total_retweetedmoeny+evaluate.getRetweeted_money();
            total_money=total_money+evaluate.getTotalmoney();
        }

        System.out.format("Overall cost: $%.2f\n",total_money);
        System.out.format("Overall cost of original tweets: $%.2f\n",total_tweetmoney);
        System.out.format("Overall cost of retweeting others: $%.2f\n",total_retweetmoney);
        System.out.format("Overall cost of being retweeted: $%.2f\n",total_retweetedmoeny);
        System.out.format("Cost of top Tweeter award: $%.2f\n",total_money-total_retweetedmoeny-total_retweetmoney-total_tweetmoney);
    }

    public void printuser() {
        for (int i = 0; i < userlist.length; i++) {
            if (i == this.findbestone()) {
                System.out.format("%s - %d - %d%% - %d - %d - Top Tweeter\n", userlist[i].username, userlist[i].tweet_numbers, Math.round((float) userlist[i].tweet_numbers / userlist[i].tweetCount * 100), userlist[i].tweet_retweetfromothers_numbers, userlist[i].getTweet_retweetedbyothers_numbers());
                double extramoney = 0.05 * (userlist[i].getTweet_numbers());
                EvaluateUser evaluate = new EvaluateUser(userlist[i]);
                System.out.format("Top tweeter: $%.2f Tweets: $%.2f Retweets: $%.2f Retweeted: $%.2f\n", extramoney, evaluate.getOriginal_money(), evaluate.getRetweet_money(), evaluate.getRetweeted_money());
            } else {
                System.out.format("%s - %d - %d%% - %d - %d\n", userlist[i].username, userlist[i].tweet_numbers, Math.round((float) userlist[i].tweet_numbers / userlist[i].tweetCount * 100), userlist[i].tweet_retweetfromothers_numbers, userlist[i].getTweet_retweetedbyothers_numbers());
                EvaluateUser evaluate = new EvaluateUser(userlist[i]);
                System.out.format("Tweets: $%.2f Retweets: $%.2f Retweeted: $%.2f\n", evaluate.getOriginal_money(), evaluate.getRetweet_money(), evaluate.getRetweeted_money());
            }
        }
    }


    public static void main(String[] args) {
        String[] followers = {"lorenterveen", "pjrey", "katypearce", "wyoumans", "caseyspruill", "pstamara", "jvitak", "sharoda", "MO_GY", "barrywellman"};
        User[] userlist=new User[followers.length];
        for (int i = 0; i < followers.length; i++) {
            TweetReader reader = new TweetReader("dat/tweets.dat");
            User follower = new User(followers[i]);
            follower.userbehavior(reader);
            userlist[i]=follower;
        }

        TweetProcessor processor=new TweetProcessor(userlist);
        processor.printerall();
        processor.printuser();
    }


}
