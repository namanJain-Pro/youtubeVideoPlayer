package com.example.youtubecopy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayerActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {

    private static final String TAG = "PlayerActivity";
    private String linkType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout layout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_playerview, null);
        setContentView(layout);

        Intent intent = getIntent();
        linkType = intent.getStringExtra("link_type");

        YouTubePlayerView playerView = findViewById(R.id.videoPlayerView);
        playerView.initialize(YoutubeConfig.getGoogleApiKey(), this);
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Log.d(TAG, "onInitializationSuccess: PlayType status : " + linkType);

        if (linkType.equals("video")) {
            youTubePlayer.loadVideo(YoutubeConfig.getYoutubeVideoId());
        } else {
            youTubePlayer.loadPlaylist(YoutubeConfig.getYoutubePlaylistId());
        }

        youTubePlayer.play();

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

}