package com.example.nikhpand.dress_recommender;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    double temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       // String change_city = ""Change city;
        if(item.getItemId() == R.id.change_city){
            showInputDialog();
        }
        return false;
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

        Intent i = new Intent(this , DressDisplay.class);
        i.putExtra("temp_key" , temp);
        startActivity(i);
    }


}
