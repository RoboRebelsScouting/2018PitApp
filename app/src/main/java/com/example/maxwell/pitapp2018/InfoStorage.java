package com.example.maxwell.pitapp2018;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Maxwell on 1/31/2018.
 */

public class InfoStorage {

    public enum Frame {
        kitbot,
        steel,
        wood,
        aluminum,
        other,
    }

    public enum climb {
        noClimb,
        yesClimb,
        climbCarry,
        climbSupport,
    }
    public enum side{
        startLeft,
        startMiddle,
        startRight,
    }
    public enum feet{
        noScale,
        fourFeet,
        fiveFeet,
        sixFeet,
    }
    public enum cLanguage{
        codeJava,
        codeC,
        codeLab,
        codeOther;
    }
    public int team;
    public feet Feet;
    private String event;
    public Frame frame;
    public side sideAuto;
    public climb climbWay;
    public cLanguage codeLanguage;
    public int robotWeight;
    public int robotHeight;
    public String email;
    public String scout;
    public boolean vault;

    public boolean photoIsSent;

    public InfoStorage() {
        scout = "";
        team = 0;
        event = "";
        frame = null;
        photoIsSent = false;
        email = "";
    }
    public File getAlbumStorageDir(String albumName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), albumName);
        if (!file.mkdirs()) {
            Log.e("ERROR", "Directory NOT Created");
        }
        return file;
    }

    public void setHeader(String event, String scout, int team) {
        this.event = event;
        this.scout = scout;
        this.team = team;
    }

    /**
     * Creates CSV file
     */
    public void csvCreate(Activity theActivity, Boolean saveFileOnly) {
        String fileName= this.event + "-" + this.team + "-" + this.scout + "-pit.csv";

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");


        /**
         * Creates album to store files
         */
        File directory = getAlbumStorageDir("/FRC2018");
        File file = new File(directory,fileName);
        File photo = new File(mediaStorageDir.getPath() + File.separator +
                "Bot_" + Main.infoStorage.team + ".jpg");
        try {
            if(photo.exists()) {
                System.out.println("photo file name is: " + Uri.fromFile(photo));
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(photo));
                theActivity.startActivityForResult(intent, 0);
            } else {
                photoIsSent = true;
            }

            /**
             * Creates data for CSV file
             */
            FileWriter writer = new FileWriter(file);
            writer.write(this.scout + "," + this.team + "," + this.event+ "," + this.robotWeight + "," + this.robotHeight + "," +
                    this.frame.toString()+ "," + this.Feet  + "," + this.climbWay  + "," + this.vault + "," +
                    this.codeLanguage + "," + this.sideAuto);
            writer.close();
            if (saveFileOnly == false) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                theActivity.startActivityForResult(intent, 0);;
            }
        } catch (IOException e) {
            Log.e("ERROR", "File NOT Created", e);
        }
    }
}