package com.example.maxwell.pitapp2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

//import BluetoothStatusActivity;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Main.infoStorage == null) {
            Main.infoStorage = new InfoStorage();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
        TextView eventNameText = findViewById(R.id.eventName);
        EditText scoutName = findViewById(R.id.scoutName);
        if (!Main.infoStorage.scout.equals("")) {
            scoutName.setText(Main.infoStorage.scout);
        }
        try {
            long currentTimeInMillis = System.currentTimeMillis();

            if ((currentTimeInMillis >= sdf.parse("Feb 14 2018").getTime()) &&
                    (currentTimeInMillis < sdf.parse("Feb 19 2018").getTime())) {
                eventNameText.setText("Week 0");
            } else if ((currentTimeInMillis >= sdf.parse("Feb 20 2018").getTime()) &&
                    (currentTimeInMillis < sdf.parse("Mar 22 2018").getTime())) {
                eventNameText.setText("WPI");
            } else if ((currentTimeInMillis >= sdf.parse("Mar 22 2018").getTime()) &&
                    (currentTimeInMillis < sdf.parse("Mar 28 2018").getTime())) {
                eventNameText.setText("Bryant");
            } else if ((currentTimeInMillis >= sdf.parse("Mar 22 2018").getTime()) &&
                    (currentTimeInMillis < sdf.parse("Mar 31 2018").getTime())) {
                eventNameText.setText("UNH");
            } else {
                eventNameText.setText("Worlds");
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }

    public void nextButton(View view) {
        TextView event = findViewById(R.id.eventName);
        EditText scout = findViewById(R.id.scoutName);
        EditText team = findViewById(R.id.teamNumber);
        if (event.getText().toString().equals("") || scout.getText().toString().equals("") || team.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Type all fields in", Toast.LENGTH_LONG).show();
        } else {
            Main.infoStorage.setHeader(event.getText().toString(), scout.getText().toString(), Integer.parseInt(team.getText().toString()));
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);

        }
    }
    public void saveFile(View view) {
}

    public void sendFile(View view) {
    }
}

