package com.example.youtubecopy;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputLayout;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    public static boolean VIDEO_MODE = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextInputLayout textInputLayout = view.findViewById(R.id.editText_youtube_link);
        EditText editText = textInputLayout.getEditText();
        editText.setImeOptions(EditorInfo.IME_ACTION_GO);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_GO) {
                    String link = editText.getText().toString().trim();
                    if (VIDEO_MODE) {
                        if (! link.isEmpty()) {
                            YoutubeConfig.youtubeVideoID = link;
                        }
                        Intent intent = new Intent(getContext(), YoutubeActivity.class);
                        startActivity(intent);
                    } else {
                        if (! link.isEmpty()) {
                            YoutubeConfig.youtubePlaylistId = link;
                        }
                        Intent intent = new Intent(getContext(), YoutubePlaylistActivity.class);
                        startActivity(intent);
                    }
                }
                return true;
            }
        });
    }
}
