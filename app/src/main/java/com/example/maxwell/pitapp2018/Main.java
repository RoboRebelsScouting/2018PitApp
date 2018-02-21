package com.example.maxwell.pitapp2018;

import android.app.Application;

/**
 * Created by Maxwell on 1/31/2018.
 */

public class Main extends Application {
   public static InfoStorage infoStorage = new InfoStorage();

   private static Main singleton;

   public  static Main getInstance(){
      return singleton;
   }
   @Override
   public void onCreate() {
      super.onCreate();
      singleton = this;
   }
}