package com.codecool.enterprise.overcomplicated.controller;

import org.springframework.stereotype.Controller;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Controller
public class ApiController {

    public ApiController() {
    }

    private static final String USER_AGENT = "Mozilla/5.0";

    public JSONObject sendGet(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        JSONParser parser = new JSONParser();
        Object inputJson = parser.parse(new InputStreamReader((InputStream) con.getContent()));
        JSONObject jsonObject = (JSONObject) inputJson;

        return jsonObject;
    }
}
