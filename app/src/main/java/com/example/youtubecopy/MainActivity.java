package com.example.youtubecopy;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class MainActivity extends YouTubeBaseActivity implements View.OnClickListener{

    YouTubeThumbnailView youtubeVideoView;
    YouTubeThumbnailView youtubePlaylistView;
    YouTubeThumbnailView.OnInitializedListener thumbnailInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        youtubeVideoView = findViewById(R.id.youtubeVideoThumbnail);
        youtubePlaylistView = findViewById(R.id.youtubePlaylistThumbnail);

        thumbnailInitializedListener = new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
                switch (youTubeThumbnailView.getId()) {
                    case R.id.youtubeVideoThumbnail:
                        youTubeThumbnailLoader.setVideo(YoutubeConfig.getYoutubeVideoId());
                        break;
                    case R.id.youtubePlaylistThumbnail:
                        youTubeThumbnailLoader.setPlaylist(YoutubeConfig.getYoutubePlaylistId());
                        break;
                    default:

                }
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youtubeVideoView.initialize(YoutubeConfig.getGoogleApiKey(), thumbnailInitializedListener);
        youtubePlaylistView.initialize(YoutubeConfig.getGoogleApiKey(), thumbnailInitializedListener);
        youtubePlaylistView.setOnClickListener(this);
        youtubeVideoView.setOnClickListener(this);

    }

    @Override
    public ComponentName startService(Intent service) {
        return super.startService(service);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.youtubeVideoThumbnail:
                intent = new Intent(this, YoutubeActivity.class);
                break;
            case R.id.youtubePlaylistThumbnail:
                intent = new Intent(this, YoutubePlaylistActivity.class);
                break;
            default:

        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}