package com.typicode.jsonplaceholder.api;

import java.util.HashMap;
import java.util.Map;

public class ApiHeaders {

    Map<String, String> headers = new HashMap<>();

    public Map<String, String> jsonPlaceHeaders(String token){
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", token);
        return headers;
    }
}
