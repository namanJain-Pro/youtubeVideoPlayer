package com.example.youtubecopy;

public class YoutubeConfig {

    private static final String GOOGLE_API_KEY = "AIzaSyDJGO8-F33gul-RWyz32Tci4gRu04TbShs";
    public static String youtubeVideoID = "https://youtu.be/0njiAvyvvE8"; // Rick Roll default
    public static String youtubePlaylistId = "PLDHnEFiZUKKNVFlbQgzHv5GvL2hHwgew5";

    public YoutubeConfig() {
    }

    public static String getGoogleApiKey() {
        return GOOGLE_API_KEY;
    }

    // Reference: https://www.youtube.com/watch?v=R6o1UWEBVQA
    // Reference: https://youtu.be/H1HdZFgR-aA
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
