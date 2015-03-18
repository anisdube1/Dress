package com.example.nikhpand.dress_recommender;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity  {

    SharedPreferences sharedpreferences;
    private static final int RESULT_SETTINGS = 1;
    double temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_main);

      //  showUserSettings();

        sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);


        if (sharedpreferences.contains("gender"))
        {
            Log.d("Print", "anish");
            Log.d("FINAL OUPUT",sharedpreferences.getString("gender" , "chutiya"));
          //  Gender.setText(sharedpreferences.getString("gender", ""));

        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_settings:
                Intent i = new Intent(this, UserSettingActivity.class);
                startActivityForResult(i, RESULT_SETTINGS);
                break;
            case R.id.change_city:
                showInputDialog();

        }

        return true;

    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // Log.d("TAG" , I came on menu)

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void showInputDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change city");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                changeCity(input.getText().toString());
            }
        });
        builder.show();
    }

    public void changeCity(String city){
//        WeatherFragment wf = (WeatherFragment)getSupportFragmentManager()
//                .findFragmentById(R.id.container);
//        wf.changeCity(city);
//        new CityPreference(this).setCity(city);
//        wf.changeCity(mAddressOutput);
//        new CityPreference(this).setCity(mAddressOutput);

//                wf.changeCity("Bryan US");
//        new CityPreference(this).setCity("Bryan US");
      try {
          temp = WeatherReport.updateWeatherData(city, getApplicationContext());
      }catch(Exception e){

      }
        Log.d("Temp", String.valueOf(temp));

        Intent i = new Intent(this , WeatherDisplay.class);
        i.putExtra("temp_key" , temp);
        startActivity(i);
    }


}
