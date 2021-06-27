package com.example.youtubecopy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.youtubeVideo)).setOnClickListener(this);
        ((Button) findViewById(R.id.youtubePlaylist)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.youtubeVideo:
                BottomSheetDialog.VIDEO_MODE = true;
                break;
            case R.id.youtubePlaylist:
                BottomSheetDialog.VIDEO_MODE = false;
                break;
        }

        BottomSheetDialog bottomSheet = new BottomSheetDialog();
        bottomSheet.show(getSupportFragmentManager(), "MODAL");
    }
}