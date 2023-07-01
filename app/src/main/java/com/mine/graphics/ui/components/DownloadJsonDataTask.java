package com.mine.graphics.ui.components;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DownloadJsonDataTask extends AsyncTask<String, Void, String> {
    private String accessKey;

    public DownloadJsonDataTask(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    protected String doInBackground(String... urls) {
        String url = urls[0];
        try {
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
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            // Handle any errors here
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        // Process the downloaded JSON data here
        if (result != null) {
            // Handle the result
        }
    }
}

