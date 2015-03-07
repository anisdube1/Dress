package com.example.nikhpand.dress_recommender;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by nikhpand on 2/25/15.
 */
public class WeatherReport {

    static double temperature=0.0;
    public static double  updateWeatherData(final String city , final Context context) throws InterruptedException {
        new Thread() {
            public void run() {
                final JSONObject json = RemoteFetch.getJSON(city, context);
                if (json == null) {
                    //TOAST
                } else {
                    temperature = renderWeather(json);
                }
              //  return 0.0;
            }
        }.start();

        Thread.sleep(3000);
        return  temperature;
    }

    private static double renderWeather(JSONObject json){
        try {

           return json.getJSONObject("main").getDouble("temp");

//            cityField.setText(json.getString("name").toUpperCase(Locale.US) +
//                    ", " +
//                    json.getJSONObject("sys").getString("country"));
//
//            JSONObject details = json.getJSONArray("weather").getJSONObject(0);
//            JSONObject main = json.getJSONObject("main");
//
//            detailsField.setText(
//                    details.getString("description").toUpperCase(Locale.US) +
//                            "\n" + "Humidity: " + main.getString("humidity") + "%" +
//                            "\n" + "Pressure: " + main.getString("pressure") + " hPa");
//
//            currentTemperatureField.setText(
//                    String.format("%.2f", main.getDouble("temp"))+ " ℃");
//
//            DateFormat df = DateFormat.getDateTimeInstance();
//            String updatedOn = df.format(new Date(json.getLong("dt")*1000));
//            updatedField.setText("Last update: " + updatedOn);
//
//            Log.d("Text" ,"I came at changeCity-5");
//            setWeatherIcon(details.getInt("id"),
//                    json.getJSONObject("sys").getLong("sunrise") * 1000,
//                    json.getJSONObject("sys").getLong("sunset") * 1000);
//
//            Intent i = new Intent(this , DressDisplay.class);
//            i.putExtra("temp",56);
//            startActivity(i);


        }catch(Exception e){
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
        return 0.0;
    }
            }
