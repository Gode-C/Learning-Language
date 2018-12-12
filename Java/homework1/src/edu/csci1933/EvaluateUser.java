package edu.csci1933;

/**
 * Created by chen1 on 10/1/2015.
 */
public class EvaluateUser {
    public User user;
    public double totalmoney;
    public double original_money;
    public double retweet_money;
    public double retweeted_money;

    public EvaluateUser(User user) {
        this.user = user;
    }

    public double getTotalmoney() {
        double totalmoney=this.getOriginal_money()+this.getRetweet_money()+this.getRetweeted_money();
        return totalmoney;
    }

    public double getOriginal_money() {
        original_money=user.getTweet_create_numbers()*0.1;
        return original_money;
    }

    public double getRetweet_money() {
        retweet_money=user.getTweet_retweetfromothers_numbers()*0.05;
        return retweet_money;
    }

    public double getRetweeted_money() {
        retweeted_money=user.getTweet_retweetedbyothers_numbers()*0.25;
        return retweeted_money;
    }

}
