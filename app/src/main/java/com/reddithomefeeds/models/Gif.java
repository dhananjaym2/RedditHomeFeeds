
package com.reddithomefeeds.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Gif {

    @SerializedName("source")
    @Expose
    private Source_ source;
    @SerializedName("resolutions")
    @Expose
    private List<Resolution_> resolutions = new ArrayList<Resolution_>();

    /**
     * @return The source
     */
    public Source_ getSource() {
        return source;
    }

    /**
     * @param source The source
     */
    public void setSource(Source_ source) {
        this.source = source;
    }

    /**
     * @return The resolutions
     */
    public List<Resolution_> getResolutions() {
        return resolutions;
    }

    /**
     * @param resolutions The resolutions
     */
    public void setResolutions(List<Resolution_> resolutions) {
        this.resolutions = resolutions;
    }

}