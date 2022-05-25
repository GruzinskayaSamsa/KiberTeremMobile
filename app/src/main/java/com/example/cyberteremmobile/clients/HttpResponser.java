package com.example.cyberteremmobile.clients;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HttpResponser extends AsyncTask<String, String, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String doInBackground(String... urls) {
        Map<String, String> postArg = new HashMap<>();
        postArg.put("type", "dataRequest");
        postArg.put("frameStart", "0");
        postArg.put("frameEnd", "100");
        postArg.put("dataResolution", "10");

        byte[] out = postArg.toString().getBytes();

        URL url = null;
        try {
            url = new URL(urls[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        connection.setDoOutput(true);
        connection.setDoInput(true);

        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader rd = null;
        OutputStream os = null;

        try {
            os = connection.getOutputStream();
            os.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = "", line = null;
        try {
            if (connection.HTTP_OK == connection.getResponseCode()) {
                rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        while (true) {
                            try {
                                if (!((line = rd.readLine()) != null)) break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            content += line + "\n";
                        }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

}
