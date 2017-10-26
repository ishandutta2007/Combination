package com.example.avadhesh.combination;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnmedia,btnyoutube,btnphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnmedia = (Button)findViewById(R.id.mediastream);
        btnyoutube = (Button)findViewById(R.id.youtubestream);
        btnphoto  =(Button)findViewById(R.id.photoview);
        btnmedia.setOnClickListener(this);
        btnyoutube.setOnClickListener(this);
        btnphoto.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.mediastream)
        {
            Intent intent = new Intent(MainActivity.this,MediaStream.class);
            startActivity(intent);

        }
        else if (v.getId()==R.id.youtubestream)
        {
            Intent intent = new Intent(MainActivity.this,YoutubeStream.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(MainActivity.this,PhotoView.class);
            startActivity(intent);
        }
    }
}
