package com.example.avadhesh.combination;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhotoView extends AppCompatActivity {
    Button button;
    ImageView imageview;
    Uri file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        button = (Button)findViewById(R.id.btnclick);
        imageview = (ImageView)findViewById(R.id.img);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            button.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);


        }

    }
    public void onRequestPermissionResult(int requestCode , String[] permission , int[] grantResult)
    {
        if(requestCode==0)
        {
            if (grantResult.length>0 && grantResult[0] == PackageManager.PERMISSION_GRANTED)
            {
                button.setEnabled(true);
            }
        }
    }
    public void takePicture(View view)
    {
        Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = Uri.fromFile(getOutputFile());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
        startActivityForResult(intent, 100);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 100)
            if (resultCode == RESULT_OK)
            {
                imageview.setImageURI(file);
            }
    }
    private static File getOutputFile()
    {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"CameraDemo");
        if(!mediaStorageDir.exists()){
            if(!mediaStorageDir.mkdir())
            {
                return null;
            }
        }
        String timeStamp = new SimpleDateFormat("yyyyMMDD_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
    }
}
