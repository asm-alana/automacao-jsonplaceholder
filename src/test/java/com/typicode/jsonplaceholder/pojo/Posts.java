package com.typicode.jsonplaceholder.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Posts {
    private int userId;
    private int id;
    private String tittle;
    private String body;

    public JSONObject getJson() throws JSONException {
        return new JSONObject(new Gson().toJson(this));
    }

    public String getXml(){
        return XML.toString(getJson());
    }
}
