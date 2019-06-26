package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.shinelw.library.ColorArcProgressBar;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    int position = 0;
    private List<Sensors> listData;

    private ColorArcProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("Position");

        TextView tvName = (TextView) findViewById(R.id.tvName);

        switch(position) {
            case 0:
                tvName.setText("Accelerometer");
                break;
            case 1:
                tvName.setText("Air quality");
                break;
            case 2:
                tvName.setText("Gyroscope");
                break;
            case 3:
                tvName.setText("Humidity");
                break;
            case 4:
                tvName.setText("Light");
                break;
            case 5:
                tvName.setText("Magnetometer");
                break;
            case 6:
                tvName.setText("Pressure");
                break;
            case 7:
                tvName.setText("Temperature");
                break;
            default:
                tvName.setText("Sensor");
        }

        progressBar = (ColorArcProgressBar) findViewById(R.id.progressBar);
        // Pass value sensor to progress bar, max 100%
        progressBar.setCurrentValues(70);

//        Log.d("TAG: ", String.valueOf(pos));
    }
}
