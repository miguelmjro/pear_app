package com.miguelmjro.appstore.pearstroe.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by miguel on 21/10/16.
 */
public class Json {
    JSONObject jsObject;
    JSONObject raiz;
    JSONArray aplicaicones;
    public Json(String st_json){
        try {
            jsObject = new JSONObject(st_json);
            raiz =jsObject.getJSONObject("feed");
            aplicaicones = raiz.getJSONArray("entry");
            for (int i=0; i < aplicaicones.length(); i++)
            {
                try {
                    JSONObject oneObject = aplicaicones.getJSONObject(i);
                    // Pulling items from the array
                    String oneObjectsItem = oneObject.getString("im:name");
                    System.out.println(oneObjectsItem);
                } catch (JSONException e) {
                    // Oops
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
