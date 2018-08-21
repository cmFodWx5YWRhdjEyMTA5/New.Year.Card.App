package com.example.android.testapp;

import android.graphics.Bitmap;
import android.view.View;

/**
 * Created by pcs on 26-Dec-17.
 */

public class Screenshot {


   public static Bitmap takeScreenshot(View v) {
       v.setDrawingCacheEnabled(true);
       v.buildDrawingCache(true);

       Bitmap b=Bitmap.createBitmap(v.getDrawingCache());
       v.setDrawingCacheEnabled(false);
       return b;

   }


   public static Bitmap takeScreenshotOfRootView(View v){
       return takeScreenshot(v.getRootView());
   }

}
