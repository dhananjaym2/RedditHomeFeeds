
package com.reddithomefeeds.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Mp4 {

    @SerializedName("source")
    @Expose
    private Source__ source;
    @SerializedName("resolutions")
    @Expose
    private List<Resolution__> resolutions = new ArrayList<Resolution__>();

    /**
     * @return The source
     */
    public Source__ getSource() {
        return source;
    }

    /**
     * @param source The source
     */
    public void setSource(Source__ source) {
        this.source = source;
    }

    /**
     * @return The resolutions
     */
    public List<Resolution__> getResolutions() {
        return resolutions;
    }

    /**
     * @param resolutions The resolutions
     */
    public void setResolutions(List<Resolution__> resolutions) {
        this.resolutions = resolutions;
    }

}