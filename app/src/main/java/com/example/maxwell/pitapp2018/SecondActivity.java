package com.example.maxwell.pitapp2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;
public class SecondActivity extends AppCompatActivity {
    public boolean saveFileOnly = false;
    public boolean useBluetoothActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void toPhoto(View view) {
        Intent intent = new Intent(this, PhotoActivity.class);
        startActivity(intent);
    }
    public void submit(View view) {
        EditText robotWeight = findViewById(R.id.robotWeight);
        EditText robotHeight = findViewById(R.id.robotHeight);
        RadioButton noClimb = findViewById(R.id.noClimb);
        RadioButton  yesClimb = findViewById(R.id.yesClimb);
        RadioButton  climbCarry = findViewById(R.id.climbCarry);
        RadioButton  climbSupport = findViewById(R.id.climbSupport);
        ToggleButton shootVault = findViewById(R.id.shootVault);
        RadioButton frameSteel = findViewById(R.id.steel);
        RadioButton frameAluminum = findViewById(R.id.aluminum);
        RadioButton frameKitbot = findViewById(R.id.kitbot);
        RadioButton frameWood = findViewById(R.id.wood);
        RadioButton frameOther = findViewById(R.id.frameOther);
        RadioButton startLeft = findViewById(R.id.startLeft);
        RadioButton startMiddle = findViewById(R.id.startMiddle);
        RadioButton startRight = findViewById(R.id.startRight);
        RadioButton noScale = findViewById(R.id.noScale);
        RadioButton fourFeet = findViewById(R.id.fourFeet);
        RadioButton fiveFeet = findViewById(R.id.fiveFeet);
        RadioButton sixFeet = findViewById(R.id.sixFeet);
        RadioButton  codeJava = findViewById(R.id.codeJava);
        RadioButton codeC = findViewById(R.id.codeC);
        RadioButton codeLab = findViewById(R.id.codeLab);
        RadioButton codeOther = findViewById(R.id.codeOther);

        if (robotWeight.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Type in the robot weight", Toast.LENGTH_LONG).show();
        } else {
            Main.infoStorage.robotWeight = Integer.parseInt(robotWeight.getText().toString());
        }
        Main.infoStorage.vault = shootVault.isChecked();

        if (robotHeight.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Type in the robot height", Toast.LENGTH_LONG).show();
        } else {
            Main.infoStorage.robotHeight = Integer.parseInt(robotHeight.getText().toString());
        }

        if (frameSteel.isChecked()) {
                Main.infoStorage.frame = InfoStorage.Frame.steel;
            } else if (frameAluminum.isChecked()) {
                Main.infoStorage.frame = InfoStorage.Frame.aluminum;
            } else if (frameKitbot.isChecked()) {
                Main.infoStorage.frame = InfoStorage.Frame.kitbot;
            }else if (frameWood.isChecked()) {
                Main.infoStorage.frame = InfoStorage.Frame.wood;
            }else if (frameOther.isChecked()) {
            Main.infoStorage.frame = InfoStorage.Frame.other;
        }

        if (frameSteel.isChecked()) {
            Main.infoStorage.frame = InfoStorage.Frame.steel;
        } else if (frameAluminum.isChecked()) {
            Main.infoStorage.frame = InfoStorage.Frame.aluminum;
        } else if (frameKitbot.isChecked()) {
            Main.infoStorage.frame = InfoStorage.Frame.kitbot;
        }else if (frameWood.isChecked()) {
            Main.infoStorage.frame = InfoStorage.Frame.wood;
        }

        if (fourFeet.isChecked()) {
            Main.infoStorage.Feet = InfoStorage.feet.fourFeet;
        } else if (fiveFeet.isChecked()) {
            Main.infoStorage.Feet = InfoStorage.feet.fiveFeet;
        } else if (sixFeet.isChecked()) {
            Main.infoStorage.Feet = InfoStorage.feet.sixFeet;
        }else if (noScale.isChecked()) {
            Main.infoStorage.Feet = InfoStorage.feet.noScale;
        }

        if (climbCarry.isChecked()) {
            Main.infoStorage.climbWay = InfoStorage.climb.climbCarry;
               }
        if (yesClimb.isChecked()) {
            Main.infoStorage.climbWay = InfoStorage.climb.yesClimb;
        }
        if (climbSupport.isChecked()) {
            Main.infoStorage.climbWay = InfoStorage.climb.climbSupport;
        }
        if (noClimb.isChecked()) {
        Main.infoStorage.climbWay = InfoStorage.climb.noClimb;
    }
        if (codeJava.isChecked()) {
            Main.infoStorage.codeLanguage= InfoStorage.cLanguage.codeJava;
        } else if (codeC.isChecked()) {
            Main.infoStorage.codeLanguage= InfoStorage.cLanguage.codeC;
        } else if (codeLab.isChecked()) {
            Main.infoStorage.codeLanguage= InfoStorage.cLanguage.codeLab;
        }else if (codeOther.isChecked()) {
            Main.infoStorage.codeLanguage= InfoStorage.cLanguage.codeOther;
        }
        if (startLeft.isChecked()) {
            Main.infoStorage.sideAuto = InfoStorage.side.startLeft;
        }
        if (startMiddle.isChecked()) {
            Main.infoStorage.sideAuto = InfoStorage.side.startMiddle;
        }
        if (startRight.isChecked()) {
            Main.infoStorage.sideAuto = InfoStorage.side.startRight;
        }
        Main.infoStorage.csvCreate(this, saveFileOnly);
        if (saveFileOnly == true){
            startMainActivity();
        }
    }
    public void saveFile (View view) {
        saveFileOnly = true;
        this.submit(view);
    }

    public void sendFile (View view) {
        saveFileOnly = false;
        this.submit(view);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Main.infoStorage.photoIsSent) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Main.infoStorage.photoIsSent = true;
        }
    }

    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class) ;
        startActivity(intent);
    }

}

