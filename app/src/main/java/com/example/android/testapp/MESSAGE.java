package com.example.android.testapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MESSAGE extends AppCompatActivity {

    private View imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.messageBox);
        textView.setText("Happy New Year " + message + "!");
        Toast.makeText(getApplicationContext(),"You can take a Screenshot :)", Toast.LENGTH_LONG).show();


    }

    public void finishActivity(View view) {
        finish();
        System.exit(0);
    }

    public void callOnThisNumber(View v){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Thank you for this card ! Happy New Year 2018 ");
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);

    }



//    public void captureScreenshot(View v) throws IOException {
//        ImageView imgView = (ImageView) findViewById(R.id.capImg);
//        Bitmap b = Screenshot.takeScreenshotOfRootView(imgView);
//        imgView.setImageBitmap(b);
//        ConstraintLayout c1=(ConstraintLayout)findViewById(R.id.messageLayout);
//       c1.removeViewAt(0);
//        c1.removeView(findViewById(R.id.btnScreen));
//        c1.removeView(findViewById(R.id.imageButton));
//        c1.removeView(findViewById(R.id.imageButton4));
//    }

    public void directCall(View v){
        Uri number=Uri.parse("tel:8878620568");
        Intent callIntent=new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);

    }


}
