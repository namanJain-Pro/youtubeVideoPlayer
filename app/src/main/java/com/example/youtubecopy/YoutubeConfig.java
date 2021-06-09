package com.example.youtubecopy;

public class YoutubeConfig {

    private static final String GOOGLE_API_KEY = "AIzaSyDJGO8-F33gul-RWyz32Tci4gRu04TbShs";
    private static final String YOUTUBE_VIDEO_ID = "0njiAvyvvE8";
    private static final String YOUTUBE_PLAYLIST_ID = "PLDHnEFiZUKKNVFlbQgzHv5GvL2hHwgew5";

    public YoutubeConfig() {
    }

    public static String getGoogleApiKey() {
        return GOOGLE_API_KEY;
    }

    public static String getYoutubeVideoId() {
        return YOUTUBE_VIDEO_ID;
    }

    public static String getYoutubePlaylistId() {
        return YOUTUBE_PLAYLIST_ID;
    }
}
