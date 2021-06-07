package com.example.youtubecopy;

import android.os.Bundle;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {

    private static final String TAG = "YoutubeActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout layout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_youtube, null);
        setContentView(layout);

        YouTubePlayerView playerView = findViewById(R.id.videoPlayerView);
        playerView.initialize(YoutubeConfig.getGoogleApiKey(), this);
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {

        if(!wasRestored) {
            youTubePlayer.cueVideo(YoutubeConfig.getYoutubeVideoId());
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        final int REQUEST_CODE = 1;

        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show();
        } else {
            toastMsg("There is in an error in initializing in youtube player (%1$s)");
        }
    }

    /**
     * To print toast message
     */

    private void toastMsg(String msg) {
        Toast.makeText(YoutubeActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}