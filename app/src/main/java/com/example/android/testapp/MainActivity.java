package com.example.android.testapp;

import android.app.ActionBar;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static int RESULT_LOAD_IMAGE = 1;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final int REQUEST_ID = 1;
    private static final int HALF = 2;
//    public static final int PICK_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Nullable




    //    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data)
//    {
//        if (requestCode == PICK_IMAGE) {
//            //TODO: action
//        }
//    }


    public void browseFiles(View v){
//        Intent intent= new Intent();
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//        intent.setType("image/*");
//
//
//
//        startActivity(intent);

        Intent i= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i,RESULT_LOAD_IMAGE);
    }

    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent Data){

        super.onActivityResult(requestCode,resultCode,Data);
        if(requestCode==RESULT_LOAD_IMAGE && resultCode==RESULT_OK && null!=Data){
            Uri returnUri=Data.getData();
            String[] filePathColumn={MediaStore.Images.Media.DATA};
            Cursor returnCursor=getContentResolver().query(returnUri, filePathColumn, null,null,null);
            returnCursor.moveToFirst();
            int nameIndex=returnCursor.getColumnIndex(filePathColumn[0]);
            String picturePath=returnCursor.getString(nameIndex);
            returnCursor.close();

            TextView txt=(TextView)findViewById(R.id.success);
            txt.setText(picturePath);

            ImageView viewer=(ImageView)findViewById(R.id.viewer);
            viewer.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }


    }

    public void sendMessage(View view){
        EditText editText=(EditText) findViewById(R.id.editText);



        if(editText.getText().toString().length()==0){
            editText.setError("Name Please");
        }

        else {
            composeMessage();
            EditText editText1=(EditText) findViewById(R.id.alias);
            Intent newIntent = new Intent(this, MESSAGE.class);

            String message = editText.getText().toString();
            String nickName= editText1.getText().toString();
            String message1 = "Happy Birthday";
            newIntent.putExtra(EXTRA_MESSAGE, message);
            startActivity(newIntent);
        }
}

public void composeMessage(){
    EditText editText=(EditText) findViewById(R.id.editText);
    EditText editText1=(EditText) findViewById(R.id.alias);
    Intent i=new Intent(Intent.ACTION_SEND);
    i.setType("message/rfc822");
    String subject="From " + editText.getText().toString()+ " "+ (editText1.getText().toString());
    String text1="Happy New Year 2018 \n Feedback : ";
    i.putExtra(Intent.EXTRA_EMAIL, new String[]{"ishtdeep.hora@gmail.com"});
    i.putExtra(Intent.EXTRA_SUBJECT, subject);
    i.putExtra(Intent.EXTRA_TEXT,text1);
    startActivity(Intent.createChooser(i,"Give one feedback please"));

}



//public void uploadImage(){
//    Intent i=new Intent();
//    i.setType("images/*");
//    i.setAction(Intent.ACTION_GET_CONTENT);;
//    startActivityForResult(Intent.createChooser(i, "Select Picture"), PICK_IMAGE);
//
//}

    }