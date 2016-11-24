package edu.mum.cs472.model;

/**
 * Created by Asme on 11/23/2016.
 */
public class Tweets {
    private long id;
    private String imageUrl;
    private String screenName;
    private String text;

    public Tweets(long id, String imageUrl, String screenName, String text) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.screenName = screenName;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Tweets{" +
                "imageUrl='" + imageUrl + '\'' +
                ", screenName='" + screenName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
