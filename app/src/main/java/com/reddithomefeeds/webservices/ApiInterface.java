package com.reddithomefeeds.webservices;

import com.reddithomefeeds.models.RedditHomeFeeds;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Admin on 01-12-2016.
 */

public interface ApiInterface {

    @GET(".json")
    Call<RedditHomeFeeds> getRedditHomeFeeds();
}