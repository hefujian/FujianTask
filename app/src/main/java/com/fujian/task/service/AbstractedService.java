package com.fujian.task.service;

import com.fujian.task.model.FeedItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AbstractedService {
    public String getFeed() {
        return "[ \n" +
                "{ \n" +
                "\"Id\":1, \"username\":\"test user\", \"body\":[ { \n" +
                "\"Id\":3, \"bodyType\":\"text\", \"text\":\"Hello World\" \n" +
                "}, { \n" +
                "\"Id\":4, \"bodyType\":\"image\", \"mediaLocation\":\"\u200Bhttp://.../\u200B\" \n" +
                "} \n" +
                "  \n" +
                "] \n" +
                "}, { \n" +
                "\"Id\":2, \"username\":\"test user\", \"body\":[ { \n" +
                "\"Id\":4, \"bodyType\":\"video\", \"mediaLocation\":\"\u200Bhttp://.../\u200B\" \n" +
                "} \n" +
                "] \n" +
                "} \n" +
                "] ";//returns a json array of json objects representing the feed items.
    }

    public List<FeedItem> parserJsonToFeedItem(String json) throws JSONException {
        List<FeedItem> list = new ArrayList<FeedItem>();
        if(json!=null && !json.equals("")){
            try {
                JSONArray jsonArray = new JSONArray(json);
                FeedItem feedItem;
                for(int i =0;i <jsonArray.length();i++){
                    JSONObject jsonItem = jsonArray.getJSONObject(i);
                    feedItem = FeedItem.createFeedItemFromJSON(jsonItem);
                    list.add(feedItem);
                }
            } catch (JSONException e) {
                throw e;
            }
        }
        return list;
    }
}
