package edu.mum.cs472.util;


import com.google.gson.Gson;
import edu.mum.cs472.model.Tweets;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asme on 11/20/2016.
 */
public class TwitterCall {
    /**
     * @param count
     * @return Json string format
     */
    public static Query getQueryByType(int count, String searchType){
        Query query = new Query(searchType);
        query.count(count);
        return query;
    }
    public static Query getQueryByLocation(double lat,double lon,double radius, String unit,int count){
        Query query = new Query().geoCode(new GeoLocation(lat,lon), radius, unit);
        query.count(count);
        return query;
    }
    public static List<Tweets> getTweetsByCategory(int count, String searchType) {
        List<Tweets> tweetList = new ArrayList<>();
        ConfigurationBuilder cb = new ConfigurationBuilder();
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        QueryResult result = null;
        try {
            result = twitter.search(getQueryByType(count,searchType));
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        for (Status post : result.getTweets()) {
            tweetList.add(new Tweets(
                    post.getId(),
                    post.getUser().getOriginalProfileImageURL(),
                    post.getUser().getScreenName(),
                    post.getText()

            ));
        }
        return tweetList;
    }

    public static List<Tweets> getTrendsByGeoLocation(double lat,double lon,double radius, String unit,int count){
        List<Tweets> tweetList = new ArrayList<>();
        ConfigurationBuilder cb = new ConfigurationBuilder();
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        QueryResult result = null;
        try {
            result = twitter.search(getQueryByLocation(lat,lon,radius,unit,count));
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        for (Status post : result.getTweets()) {
            tweetList.add(new Tweets(
                    post.getId(),
                    post.getUser().getOriginalProfileImageURL(),
                    post.getUser().getScreenName(),
                    post.getText()
            ));
        }
        return tweetList;
    }

    public String getJsonFormatTweets(List<Tweets> list) {
        return new Gson().toJson(list);
    }

}
