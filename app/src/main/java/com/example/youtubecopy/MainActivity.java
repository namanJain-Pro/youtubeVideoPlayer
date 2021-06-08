package com.example.youtubecopy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeThumbnailView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    YouTubeThumbnailView youtubeVideoView;
    YouTubeThumbnailView youtubePlaylistView;
    YouTubeThumbnailView.OnInitializedListener thumbnailInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.youtubeVideo)).setOnClickListener(this);
        ((Button) findViewById(R.id.youtubePlaylist)).setOnClickListener(this);
//        youtubeVideoView = findViewById(R.id.youtubeVideoThumbnail);
//        youtubePlaylistView = findViewById(R.id.youtubePlaylistThumbnail);
//
//        thumbnailInitializedListener = new YouTubeThumbnailView.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
//                switch (youTubeThumbnailView.getId()) {
//                    case R.id.youtubeVideoThumbnail:
//                        youTubeThumbnailLoader.setVideo(YoutubeConfig.getYoutubeVideoId());
//                        break;
//                    case R.id.youtubePlaylistThumbnail:
//                        youTubeThumbnailLoader.setPlaylist(YoutubeConfig.getYoutubePlaylistId());
//                        break;
//                    default:
//
//                }
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
//
//            }
//        };
//
//        youtubeVideoView.initialize(YoutubeConfig.getGoogleApiKey(), thumbnailInitializedListener);
//        youtubePlaylistView.initialize(YoutubeConfig.getGoogleApiKey(), thumbnailInitializedListener);
//        youtubePlaylistView.setOnClickListener(this);
//        youtubeVideoView.setOnClickListener(this);

    }

//    @Override
//    public ComponentName startService(Intent service) {
//        return super.startService(service);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.youtubeVideo:
                BottomSheetDialog.VIDEO_MODE = true;
                break;
            case R.id.youtubePlaylist:
//                intent = new Intent(this, YoutubePlaylistActivity.class);
                BottomSheetDialog.VIDEO_MODE = false;
                break;
        }

        BottomSheetDialog bottomSheet = new BottomSheetDialog();
        bottomSheet.show(getSupportFragmentManager(), "MODAL");
    }
}