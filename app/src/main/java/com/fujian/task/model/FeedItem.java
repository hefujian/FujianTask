package com.fujian.task.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FeedItem {
    private int Id;
    private String username;
    private List<BodyItem> body;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<BodyItem> getBody() {
        return body;
    }

    public void setBody(List<BodyItem> body) {
        this.body = body;
    }

    public FeedItem() {
    }

    public static FeedItem createFeedItemFromJSON(JSONObject json) throws JSONException {
        FeedItem item = new FeedItem();
        List<BodyItem> body = new ArrayList<>();
        try {
            item.setId(json.getInt("Id"));
            item.setUsername(json.getString("username"));
            JSONArray jsonArray =json.getJSONArray("body");
            for(int i=0;i<jsonArray.length();i++){
                body.add(BodyItem.createBodyItemFromJson(jsonArray.getJSONObject(i)));
            }
            item.setBody(body);
        } catch (JSONException e) {
            throw e;
        }
        return  item;
    }
}
