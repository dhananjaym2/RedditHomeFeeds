package com.reddithomefeeds.webservices;

import com.reddithomefeeds.models.RedditHomeFeeds;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 01-12-2016.
 */

public interface ApiInterface {

    /**
     * used to fetch latest/fresh list of feeds for the first time(fresh)
     *
     * @return reddit feeds response data
     */
    @GET(".json")
    Call<RedditHomeFeeds> getRedditHomeFeeds();

    /**
     * used to fetch list of feeds after a particular item
     *
     * @param after value for the key named after, to fetch list of feeds after a particular item
     * @return reddit feeds response data
     */
    @GET(".json")
    Call<RedditHomeFeeds> getRedditHomeFeeds(@Query("after") String after);
}