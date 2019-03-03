package com.fujian.task.model;

import org.json.JSONException;
import org.json.JSONObject;

public class BodyItem {
    private int Id;
    private String bodyType;
    private String text;
    private String mediaLocation;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMediaLocation() {
        return mediaLocation;
    }

    public void setMediaLocation(String mediaLocation) {
        this.mediaLocation = mediaLocation;
    }

    public BodyItem() {
    }

    public static BodyItem createBodyItemFromJson(JSONObject jsonObject) throws JSONException {
        BodyItem result = new BodyItem();
        try {
            result.setId(jsonObject.getInt("Id"));
            result.setBodyType(jsonObject.getString("bodyType"));
            if(result.getBodyType().equals("text")){
                result.setText(jsonObject.getString("text"));
                result.setMediaLocation("");
            }else if(result.getBodyType().equals("image")||result.getBodyType().equals("video")){
                result.setText("");
                result.setMediaLocation(jsonObject.getString("mediaLocation"));
            }
        } catch (JSONException e) {
            throw e;
        }
        return result;
    }
}
