package com.example.avadhesh.combination;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class MediaStream extends AppCompatActivity {
    VideoView videoview;
    ProgressDialog pg;

    String VideoURL = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_stream);
        videoview = (VideoView)findViewById(R.id.video1);
        pg = new ProgressDialog(MediaStream.this);
        pg.setTitle("Android Video Streaming");
        pg.setMessage("Buffering");
        pg.setIndeterminate(false);
        pg.setCancelable(false);
        pg.show();

        try
        {
            MediaController mediaController = new MediaController(MediaStream.this);
            mediaController.setAnchorView(videoview);
            Uri video = Uri.parse(VideoURL);
            videoview.setMediaController(mediaController);
            videoview.setVideoURI(video);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        videoview.requestFocus();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pg.dismiss();
                videoview.start();

            }
        });
    }
}