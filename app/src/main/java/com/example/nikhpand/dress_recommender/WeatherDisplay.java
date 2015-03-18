package com.example.nikhpand.dress_recommender;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Thread.sleep;


public class WeatherDisplay extends ActionBarActivity {


    SharedPreferences sharedpreferences;
    Double temperature;

    TextView  cityText , temp , condDescr , hum , press , windSpeed , windDeg;
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_display);
        Bundle extra = getIntent().getExtras();
        temperature = extra.getDouble("temp_key");
        Log.d("New_Activity_Temp", String.valueOf(temp));

        cityText = (TextView) findViewById(R.id.cityText);
        condDescr = (TextView) findViewById(R.id.condDescr);
        temp = (TextView) findViewById(R.id.temp);
        hum = (TextView) findViewById(R.id.hum);
        press = (TextView) findViewById(R.id.press);
        windSpeed = (TextView) findViewById(R.id.windSpeed);
        windDeg = (TextView) findViewById(R.id.windDeg);
        imgView = (ImageView) findViewById(R.id.condIcon);

        cityText.setText("Bryan US");
        temp.setText(temperature.toString());
        imgView.setImageResource(R.drawable.sunny);
       // temp.setText(temperature);

        sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        final Button button = (Button) findViewById(R.id.Cloth_page);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {





                if (sharedpreferences.contains("gender"))
                {
                    Intent i;

                    String gen = sharedpreferences.getString("gender" , "defualt");

                    if(gen.equals("Male"))
                    {
                        i = new Intent(WeatherDisplay.this , DressDisplay.class);
                        i.putExtra("temp_key" , temperature);
                        startActivity(i);
                    }
                    else
                    {
//                        Log.d("Video", "Video-1");
//                        Intent myIntent = new Intent(WeatherDisplay.this, VideoViewActivity.class);
//                        startActivity(myIntent);
//
//                        try {
//                            sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        Log.d("Video", "Video-2");
                        i = new Intent(WeatherDisplay.this , DressDisplayFemale.class);
                        i.putExtra("temp_key" , temperature);
                        startActivity(i);
                        Log.d("Video", "Video-3");
                    }

                }



            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weather_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
