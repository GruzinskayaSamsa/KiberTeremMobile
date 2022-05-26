package com.example.cyberteremmobile.adapters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonAdapter {

    public List getListOfShortNames(JSONObject jsonObject) throws JSONException {
        ArrayList<String> list = new ArrayList<String>();
        JSONArray jsonArray = jsonObject.getJSONObject("devices").getJSONArray("sensorTypes");
        if (jsonArray != null) {
            int len = jsonArray.length();
            for (int i=0;i<len;i++){
                list.add(jsonArray.get(i).toString());
            }
        }
        return list;
    }
}
