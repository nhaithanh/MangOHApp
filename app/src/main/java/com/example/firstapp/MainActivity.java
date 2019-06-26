package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        List<Sensors> image_details = getListData();

        final ListView listView = (ListView) findViewById(R.id.listView);
        List<Sensors> list = new ArrayList<Sensors>();

        Sensors accelerometer = new Sensors("Accelerometer", "accelerometer", 1);
        Sensors air_quality = new Sensors("Air quality", "airquality", 2);
        Sensors gyroscope = new Sensors("Gyroscope", "gyroscope", 3);
        Sensors humidity = new Sensors("Humidity", "humidity", 4);
        Sensors light = new Sensors("Light", "light", 6);
        Sensors magnetometer = new Sensors("Magnetometer", "magnetometer", 6);
        Sensors pressure = new Sensors("Pressure", "pressure", 7);
        Sensors temperature = new Sensors("Temperature", "temperature", 8);

        list.add(accelerometer);
        list.add(air_quality);
        list.add(gyroscope);
        list.add(humidity);
        list.add(light);
        list.add(magnetometer);
        list.add(pressure);
        list.add(temperature);

        listView.setAdapter(new CustomListAdapter(this, list));

        // click list item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("Position", position);
                startActivity(intent);
            }
        });
    }

//    private List<Sensors> getListData() {
//        List<Sensors> list = new ArrayList<Sensors>();
//
//        Sensors humidity = new Sensors("Humidity", "humidity", 1);
//        Sensors light = new Sensors("Light", "light", 2);
//        Sensors pressure = new Sensors("Pressure", "pressure", 3);
//        Sensors temperature = new Sensors("Temperature", "temperature", 4);
//
//        list.add(humidity);
//        list.add(light);
//        list.add(pressure);
//        list.add(temperature);
//
//        return list;
//    }
}
