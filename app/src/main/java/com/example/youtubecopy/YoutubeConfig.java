package com.example.youtubecopy;

public class YoutubeConfig {

    private static final String GOOGLE_API_KEY = "AIzaSyDJGO8-F33gul-RWyz32Tci4gRu04TbShs";
    public static String youtubeVideoID;
    public static String youtubePlaylistId;

    public YoutubeConfig() {
    }

    public static String getGoogleApiKey() {
        return GOOGLE_API_KEY;
    }

    public static String getYoutubeVideoId() {
        if (youtubeVideoID.contains("youtube.com")) {
            return youtubeVideoID.substring(32);
        } else {
            return youtubeVideoID.substring(17);
        }
    }

    public static String getYoutubePlaylistId() {
        return youtubePlaylistId.substring(34);
    }
}
