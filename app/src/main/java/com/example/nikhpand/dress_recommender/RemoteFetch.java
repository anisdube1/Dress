package com.example.nikhpand.dress_recommender;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class RemoteFetch {

    private static final String OPEN_WEATHER_MAP_API =
            "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric";


  //  public static JSONObject getJSON(Context context, String city){
  public static JSONObject getJSON(String city , Context context){
        try {
            Log.d("Text" ,"I came at changeCity-11");
            URL url = new URL(String.format(OPEN_WEATHER_MAP_API, city));
            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();

            connection.addRequestProperty("x-api-key",
                    context.getString(R.string.open_weather_maps_app_id));

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());

            // This value will be 404 if the request was not
            // successful
            if(data.getInt("cod") != 200){
                Log.d("Text" ,"I came at changeCity-12");
                return null;
            }

            Log.d("Text" ,"I came at changeCity-13");
            return data;
        }catch(Exception e){
            e.printStackTrace();
            Log.d("Text" ,"I came at changeCity-14");
            return null;
        }
    }

}