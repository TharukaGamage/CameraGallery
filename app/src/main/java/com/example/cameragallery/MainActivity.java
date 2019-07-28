package com.example.cameragallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

   private static final int REQUEST_IMAGE_CAPTURE = 1;
   private static  final int GALLERY_REQUEST_CODE = 1;
   private static final int REQUEST_TAKE_PHOTO = 1;
   private Button openCam,openGallery;
   public int x;
   //Hellow World
   //dfg

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          openCam = (Button)findViewById(R.id.btnCam);
          openGallery = (Button)findViewById(R.id.btnGallery);
       openCam.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
          dispatchTakePictureIntent();
         }
       });

       openGallery.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               pickFromGallery();
           }
       });

    }

    private void dispatchTakePictureIntent() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            //dsd
            }
    }

    private void pickFromGallery(){
        //Create an Intent with action as ACTION_PICK
        Intent intent=new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
        // Launching the Intent
        startActivityForResult(intent,GALLERY_REQUEST_CODE);
    }
}
