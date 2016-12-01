
package com.reddithomefeeds.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data_ {

    @SerializedName("contest_mode")
    @Expose
    private Boolean contestMode;
    @SerializedName("banned_by")
    @Expose
    private Object bannedBy;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("subreddit")
    @Expose
    private String subreddit;
    @SerializedName("selftext_html")
    @Expose
    private Object selftextHtml;
    @SerializedName("selftext")
    @Expose
    private String selftext;
    @SerializedName("likes")
    @Expose
    private Object likes;
    @SerializedName("suggested_sort")
    @Expose
    private Object suggestedSort;
    @SerializedName("user_reports")
    @Expose
    private List<Object> userReports = new ArrayList<Object>();
    @SerializedName("secure_media")
    @Expose
    private Object secureMedia;
    @SerializedName("saved")
    @Expose
    private Boolean saved;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("gilded")
    @Expose
    private Long gilded;
    @SerializedName("secure_media_embed")
    @Expose
    private SecureMediaEmbed secureMediaEmbed;
    @SerializedName("clicked")
    @Expose
    private Boolean clicked;
    @SerializedName("report_reasons")
    @Expose
    private Object reportReasons;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("media")
    @Expose
    private Object media;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("score")
    @Expose
    private Long score;
    @SerializedName("approved_by")
    @Expose
    private Object approvedBy;
    @SerializedName("over_18")
    @Expose
    private Boolean over18;
    @SerializedName("removal_reason")
    @Expose
    private Object removalReason;
    @SerializedName("hidden")
    @Expose
    private Boolean hidden;
    @SerializedName("preview")
    @Expose
    private Preview preview;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;
    //    @SerializedName("edited")
//    @Expose
//    private Boolean edited;
    @SerializedName("link_flair_css_class")
    @Expose
    private Object linkFlairCssClass;
    @SerializedName("author_flair_css_class")
    @Expose
    private Object authorFlairCssClass;
    @SerializedName("downs")
    @Expose
    private Long downs;
    @SerializedName("mod_reports")
    @Expose
    private List<Object> modReports = new ArrayList<Object>();
    @SerializedName("archived")
    @Expose
    private Boolean archived;
    @SerializedName("media_embed")
    @Expose
    private MediaEmbed mediaEmbed;
    @SerializedName("post_hint")
    @Expose
    private String postHint;
    @SerializedName("is_self")
    @Expose
    private Boolean isSelf;
    @SerializedName("hide_score")
    @Expose
    private Boolean hideScore;
    @SerializedName("spoiler")
    @Expose
    private Boolean spoiler;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("locked")
    @Expose
    private Boolean locked;
    @SerializedName("stickied")
    @Expose
    private Boolean stickied;
    @SerializedName("created")
    @Expose
    private Long created;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("author_flair_text")
    @Expose
    private Object authorFlairText;
    @SerializedName("quarantine")
    @Expose
    private Boolean quarantine;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("created_utc")
    @Expose
    private Long createdUtc;
    @SerializedName("link_flair_text")
    @Expose
    private Object linkFlairText;
    @SerializedName("distinguished")
    @Expose
    private Object distinguished;
    @SerializedName("num_comments")
    @Expose
    private Long numComments;
    @SerializedName("visited")
    @Expose
    private Boolean visited;
    @SerializedName("num_reports")
    @Expose
    private Object numReports;
    @SerializedName("ups")
    @Expose
    private Long ups;

    /**
     * @return The contestMode
     */
    public Boolean getContestMode() {
        return contestMode;
    }

    /**
     * @param contestMode The contest_mode
     */
    public void setContestMode(Boolean contestMode) {
        this.contestMode = contestMode;
    }

    /**
     * @return The bannedBy
     */
    public Object getBannedBy() {
        return bannedBy;
    }

    /**
     * @param bannedBy The banned_by
     */
    public void setBannedBy(Object bannedBy) {
        this.bannedBy = bannedBy;
    }

    /**
     * @return The domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * @param domain The domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * @return The subreddit
     */
    public String getSubreddit() {
        return subreddit;
    }

    /**
     * @param subreddit The subreddit
     */
    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    /**
     * @return The selftextHtml
     */
    public Object getSelftextHtml() {
        return selftextHtml;
    }

    /**
     * @param selftextHtml The selftext_html
     */
    public void setSelftextHtml(Object selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    /**
     * @return The selftext
     */
    public String getSelftext() {
        return selftext;
    }

    /**
     * @param selftext The selftext
     */
    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    /**
     * @return The likes
     */
    public Object getLikes() {
        return likes;
    }

    /**
     * @param likes The likes
     */
    public void setLikes(Object likes) {
        this.likes = likes;
    }

    /**
     * @return The suggestedSort
     */
    public Object getSuggestedSort() {
        return suggestedSort;
    }

    /**
     * @param suggestedSort The suggested_sort
     */
    public void setSuggestedSort(Object suggestedSort) {
        this.suggestedSort = suggestedSort;
    }

    /**
     * @return The userReports
     */
    public List<Object> getUserReports() {
        return userReports;
    }

    /**
     * @param userReports The user_reports
     */
    public void setUserReports(List<Object> userReports) {
        this.userReports = userReports;
    }

    /**
     * @return The secureMedia
     */
    public Object getSecureMedia() {
        return secureMedia;
    }

    /**
     * @param secureMedia The secure_media
     */
    public void setSecureMedia(Object secureMedia) {
        this.secureMedia = secureMedia;
    }

    /**
     * @return The saved
     */
    public Boolean getSaved() {
        return saved;
    }

    /**
     * @param saved The saved
     */
    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The gilded
     */
    public Long getGilded() {
        return gilded;
    }

    /**
     * @param gilded The gilded
     */
    public void setGilded(Long gilded) {
        this.gilded = gilded;
    }

    /**
     * @return The secureMediaEmbed
     */
    public SecureMediaEmbed getSecureMediaEmbed() {
        return secureMediaEmbed;
    }

    /**
     * @param secureMediaEmbed The secure_media_embed
     */
    public void setSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
        this.secureMediaEmbed = secureMediaEmbed;
    }

    /**
     * @return The clicked
     */
    public Boolean getClicked() {
        return clicked;
    }

    /**
     * @param clicked The clicked
     */
    public void setClicked(Boolean clicked) {
        this.clicked = clicked;
    }

    /**
     * @return The reportReasons
     */
    public Object getReportReasons() {
        return reportReasons;
    }

    /**
     * @param reportReasons The report_reasons
     */
    public void setReportReasons(Object reportReasons) {
        this.reportReasons = reportReasons;
    }

    /**
     * @return The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return The media
     */
    public Object getMedia() {
        return media;
    }

    /**
     * @param media The media
     */
    public void setMedia(Object media) {
        this.media = media;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The score
     */
    public Long getScore() {
        return score;
    }

    /**
     * @param score The score
     */
    public void setScore(Long score) {
        this.score = score;
    }

    /**
     * @return The approvedBy
     */
    public Object getApprovedBy() {
        return approvedBy;
    }

    /**
     * @param approvedBy The approved_by
     */
    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
    }

    /**
     * @return The over18
     */
    public Boolean getOver18() {
        return over18;
    }

    /**
     * @param over18 The over_18
     */
    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    /**
     * @return The removalReason
     */
    public Object getRemovalReason() {
        return removalReason;
    }

    /**
     * @param removalReason The removal_reason
     */
    public void setRemovalReason(Object removalReason) {
        this.removalReason = removalReason;
    }

    /**
     * @return The hidden
     */
    public Boolean getHidden() {
        return hidden;
    }

    /**
     * @param hidden The hidden
     */
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * @return The preview
     */
    public Preview getPreview() {
        return preview;
    }

    /**
     * @param preview The preview
     */
    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    /**
     * @return The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * @return The subredditId
     */
    public String getSubredditId() {
        return subredditId;
    }

    /**
     * @param subredditId The subreddit_id
     */
    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

//    /**
//     * @return The edited
//     */
//    public Boolean getEdited() {
//        return edited;
//    }
//
//    /**
//     * @param edited The edited
//     */
//    public void setEdited(Boolean edited) {
//        this.edited = edited;
//    }

    /**
     * @return The linkFlairCssClass
     */
    public Object getLinkFlairCssClass() {
        return linkFlairCssClass;
    }

    /**
     * @param linkFlairCssClass The link_flair_css_class
     */
    public void setLinkFlairCssClass(Object linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }

    /**
     * @return The authorFlairCssClass
     */
    public Object getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    /**
     * @param authorFlairCssClass The author_flair_css_class
     */
    public void setAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    /**
     * @return The downs
     */
    public Long getDowns() {
        return downs;
    }

    /**
     * @param downs The downs
     */
    public void setDowns(Long downs) {
        this.downs = downs;
    }

    /**
     * @return The modReports
     */
    public List<Object> getModReports() {
        return modReports;
    }

    /**
     * @param modReports The mod_reports
     */
    public void setModReports(List<Object> modReports) {
        this.modReports = modReports;
    }

    /**
     * @return The archived
     */
    public Boolean getArchived() {
        return archived;
    }

    /**
     * @param archived The archived
     */
    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    /**
     * @return The mediaEmbed
     */
    public MediaEmbed getMediaEmbed() {
        return mediaEmbed;
    }

    /**
     * @param mediaEmbed The media_embed
     */
    public void setMediaEmbed(MediaEmbed mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
    }

    /**
     * @return The postHint
     */
    public String getPostHint() {
        return postHint;
    }

    /**
     * @param postHint The post_hint
     */
    public void setPostHint(String postHint) {
        this.postHint = postHint;
    }

    /**
     * @return The isSelf
     */
    public Boolean getIsSelf() {
        return isSelf;
    }

    /**
     * @param isSelf The is_self
     */
    public void setIsSelf(Boolean isSelf) {
        this.isSelf = isSelf;
    }

    /**
     * @return The hideScore
     */
    public Boolean getHideScore() {
        return hideScore;
    }

    /**
     * @param hideScore The hide_score
     */
    public void setHideScore(Boolean hideScore) {
        this.hideScore = hideScore;
    }

    /**
     * @return The spoiler
     */
    public Boolean getSpoiler() {
        return spoiler;
    }

    /**
     * @param spoiler The spoiler
     */
    public void setSpoiler(Boolean spoiler) {
        this.spoiler = spoiler;
    }

    /**
     * @return The permalink
     */
    public String getPermalink() {
        return permalink;
    }

    /**
     * @param permalink The permalink
     */
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    /**
     * @return The locked
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * @param locked The locked
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * @return The stickied
     */
    public Boolean getStickied() {
        return stickied;
    }

    /**
     * @param stickied The stickied
     */
    public void setStickied(Boolean stickied) {
        this.stickied = stickied;
    }

    /**
     * @return The created
     */
    public Long getCreated() {
        return created;
    }

    /**
     * @param created The created
     */
    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The authorFlairText
     */
    public Object getAuthorFlairText() {
        return authorFlairText;
    }

    /**
     * @param authorFlairText The author_flair_text
     */
    public void setAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    /**
     * @return The quarantine
     */
    public Boolean getQuarantine() {
        return quarantine;
    }

    /**
     * @param quarantine The quarantine
     */
    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The createdUtc
     */
    public Long getCreatedUtc() {
        return createdUtc;
    }

    /**
     * @param createdUtc The created_utc
     */
    public void setCreatedUtc(Long createdUtc) {
        this.createdUtc = createdUtc;
    }

    /**
     * @return The linkFlairText
     */
    public Object getLinkFlairText() {
        return linkFlairText;
    }

    /**
     * @param linkFlairText The link_flair_text
     */
    public void setLinkFlairText(Object linkFlairText) {
        this.linkFlairText = linkFlairText;
    }

    /**
     * @return The distinguished
     */
    public Object getDistinguished() {
        return distinguished;
    }

    /**
     * @param distinguished The distinguished
     */
    public void setDistinguished(Object distinguished) {
        this.distinguished = distinguished;
    }

    /**
     * @return The numComments
     */
    public Long getNumComments() {
        return numComments;
    }

    /**
     * @param numComments The num_comments
     */
    public void setNumComments(Long numComments) {
        this.numComments = numComments;
    }

    /**
     * @return The visited
     */
    public Boolean getVisited() {
        return visited;
    }

    /**
     * @param visited The visited
     */
    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    /**
     * @return The numReports
     */
    public Object getNumReports() {
        return numReports;
    }

    /**
     * @param numReports The num_reports
     */
    public void setNumReports(Object numReports) {
        this.numReports = numReports;
    }

    /**
     * @return The ups
     */
    public Long getUps() {
        return ups;
    }

    /**
     * @param ups The ups
     */
    public void setUps(Long ups) {
        this.ups = ups;
    }

}