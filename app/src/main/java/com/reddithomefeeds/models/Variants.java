package com.reddithomefeeds.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 01-12-2016.
 */

public class Variants {

    @SerializedName("gif")
    @Expose
    private Gif gif;
    @SerializedName("mp4")
    @Expose
    private Mp4 mp4;

    /**
     * @return The gif
     */
    public Gif getGif() {
        return gif;
    }

    /**
     * @param gif The gif
     */
    public void setGif(Gif gif) {
        this.gif = gif;
    }

    /**
     * @return The mp4
     */
    public Mp4 getMp4() {
        return mp4;
    }

    /**
     * @param mp4 The mp4
     */
    public void setMp4(Mp4 mp4) {
        this.mp4 = mp4;
    }
}