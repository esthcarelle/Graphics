package com.mine.graphics.ui.components;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DecodedToken {

    public static String getDecoded(String encodedToken) throws UnsupportedEncodingException, UnsupportedEncodingException {
        String[] parts = encodedToken.split("\\.", 0);

        for (String part : parts) {
            byte[] bytes = new byte[0];
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                bytes = Base64.getUrlDecoder().decode(part);
            }
            String decodedString = new String(bytes, StandardCharsets.UTF_8);

            System.out.println("Decoded: " + decodedString);
        }
        return "";
    }

    public static void getData(){
        String url = "https://api.jsonbin.io/v3/b/646bed328e4aa6225ea22a79";
        String accessKey = "$2b$10$Ke1iwieFO7/7qsSKU.GYU.oYXZMW1EeHrwd4xx9ylboJik5mstZk6";
        try {
            // Download JSON data from the URL
            String jsonData = downloadJsonData(url, accessKey);

            // Parse the JSON data into a JSONArray
            JSONArray jsonArray = new JSONArray(jsonData);

            // Sort the JSONArray by the 'bar' key
            List<JSONObject> sortedList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                sortedList.add(jsonArray.getJSONObject(i));
            }
            sortedList.sort(Comparator.comparingInt(obj -> {
                try {
                    return obj.getInt("bar");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }));

            List<JSONObject> filteredList = sortedList.stream()
                    .filter(obj -> {
                        try {
                            return obj.getInt("baz") % 3 == 0;
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());
            StringBuilder result = new StringBuilder();
            for (JSONObject obj : filteredList) {
                result.append(obj.getString("foo"));
            }



        }catch (JSONException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String downloadJsonData(String url, String accessKey) throws IOException {
        URL apiUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Master-Key", accessKey);

        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        connection.disconnect();
        return response.toString();
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

    public static void main(String[] args) {
        try {
           DecodedToken.getDecoded("R3JlYXQgam9iISAKCk5leHQgd2UndmUgaG9zdGVkIGEgSlNPTiBmaWxlIGF0IGF0IHRoaXMgdXJsOiBodHRwczovL2FwaS5qc29uYmluLmlvL3YzL2IvNjQ2YmVkMzI4ZTRhYTYyMjVlYTIyYTc5LiBZb3VyIGpvYiBpcyB0byB3cml0ZSBhIHNjcmlwdCB0bwpkb3dubG9hZCB0aGUgY29udGVudHMgb2YgdGhlIFVSTCAoaGludDogVGhlIFgtQUNDRVNTLUtFWSBpcyAkMmIkMTAkS2UxaXdpZUZPNy83cXNTS1UuR1lVLm9ZWFpNVzFFZUhyd2Q0eHg5eWxib0ppazVtc3RaazYpCnNvcnQgdGhlIGRhdGEgYnkgZWFjaCBlbGVtZW50cyAnYmFyJyBrZXkKZmlsdGVyIG91dCBlbGVtZW50cyB3aGVyZSAnYmF6JyBpcyBub3QgZGl2aXNpYmxlIGJ5IDMKY29uY2F0ZW5hdGUgZWFjaCBlbGVtZW50cyAnZm9vJyB2YWx1ZQoKRG8gZWFjaCBvZiB0aGVzZSBzdGVwcyB0byByZXZlYWwgdGhlIGluc3RydWN0aW9ucyBmb3IgdGhlIGZpbmFsIHBhcnQuIFJlbWVtYmVyIHRvIHNob3cgeW91ciB3b3JrIQ==");

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
