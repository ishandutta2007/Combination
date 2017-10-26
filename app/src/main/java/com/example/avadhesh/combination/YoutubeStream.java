package com.example.avadhesh.combination;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeStream extends YouTubeBaseActivity implements View.OnClickListener {
    Button start, view;
    private YouTubePlayerView youTubePlayerView;
    protected YouTubePlayer.OnInitializedListener onInitializedListener;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_stream);
        start = (Button) findViewById(R.id.btnstart);
        view = (Button) findViewById(R.id.btnview);
        context = this;
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubeview);


        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo("RtU_mdL2vBM");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        start.setOnClickListener(this);
        view.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnstart) {
            Toast.makeText(context, R.string.message, Toast.LENGTH_LONG).show();

        } else if (v.getId() == R.id.btnview) {

            youTubePlayerView.initialize("AIzaSyDkHhN-lXGv1C7V_PJri7tGVedd6elX4Ck", onInitializedListener);
        }
    }
}

