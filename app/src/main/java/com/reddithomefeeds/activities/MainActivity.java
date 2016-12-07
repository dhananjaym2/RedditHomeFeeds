package com.reddithomefeeds.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.reddithomefeeds.R;
import com.reddithomefeeds.adapters.recyclerview.FeedsAdapter;
import com.reddithomefeeds.interfaces.AlertDialog_OnClickInterface;
import com.reddithomefeeds.models.Child;
import com.reddithomefeeds.models.RedditHomeFeeds;
import com.reddithomefeeds.utilities.AppLog;
import com.reddithomefeeds.utilities.AppUtil;
import com.reddithomefeeds.webservices.ApiClient;
import com.reddithomefeeds.webservices.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AlertDialog_OnClickInterface {

    private final String LOG_TAG = this.getClass().getSimpleName();

    @BindView(R.id.feeds_recyclerView_MainActivity)
    RecyclerView feeds_recyclerView_MainActivity;
    private FeedsAdapter feedsAdapter;

    /**
     * value of the key "after" from the response is required to fetch list of next set of feeds
     */
    private String after;
    private List<Child> listOfFeeds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();

        getRedditHomeFeeds();
    }

    private void initializeView() {
        ButterKnife.bind(this);

        feeds_recyclerView_MainActivity.setLayoutManager(new LinearLayoutManager(this));
        feedsAdapter = new FeedsAdapter(this, listOfFeeds, feeds_recyclerView_MainActivity);

        feedsAdapter.setOnLoadMoreListener(new FeedsAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                getRedditHomeFeeds();
            }
        });
        feeds_recyclerView_MainActivity.setAdapter(feedsAdapter);
    }

    private void getRedditHomeFeeds() {
        AppLog.v(LOG_TAG, "getRedditHomeFeeds() after:" + after);

        ApiInterface apiService = ApiClient.getApiClient().create(ApiInterface.class);
        if (AppUtil.isInternetAvailable(this)) {

            Call<RedditHomeFeeds> call_apiResponse;

            if (after == null) {
                call_apiResponse = apiService.getRedditHomeFeeds();
            } else {
                call_apiResponse = apiService.getRedditHomeFeeds(after);
            }

            /**
             * show progress loading to user in the list itself
             */
            addProgressItemToRecyclerAdapter();

            call_apiResponse.enqueue(new Callback<RedditHomeFeeds>() {
                @Override
                public void onResponse(Call<RedditHomeFeeds> call, final Response<RedditHomeFeeds> response) {

                    if (response != null) {
                        if (response.body() != null) {
//                            AppLog.v(LOG_TAG, "onResponse() kind:" + response.body().getKind());

                            after = response.body().getData().getAfter();
                            if (listOfFeeds == null) {
                                listOfFeeds = response.body().getData().getChildren();
                            }
//                            AppLog.v(LOG_TAG, "listOfFeeds.size():" + listOfFeeds.size());

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    removeProgressItemFromRecyclerAdapter();

                                    //add newly fetched feed items to the list
                                    listOfFeeds.addAll(response.body().getData().getChildren());

//                                    AppLog.v(LOG_TAG, "before notifyItemInserted()");
                                    feedsAdapter.notifyItemInserted(listOfFeeds.size());

                                    feedsAdapter.setLoaded();
                                }
                            }, 2000);

                            return;
                        } else
                            AppLog.e(LOG_TAG, "response.body() null");
                    } else
                        AppLog.e(LOG_TAG, "response null");

                    AppUtil.showAlertDialogWith_TwoButtons(MainActivity.this, getString(R.string.
                            WhoopsThereWasAnErrorPleaseTryAgainLater), MainActivity.this, getString(R.string.Retry), null, LOG_TAG, false);
                }

                @Override
                public void onFailure(Call<RedditHomeFeeds> call, Throwable t) {
                    AppLog.e(LOG_TAG, "onFailure() t:" + t.getMessage());

                    removeProgressItemFromRecyclerAdapter();

                    feedsAdapter.setLoaded();

                    AppUtil.showAlertDialogWith_TwoButtons(MainActivity.this, getString(R.string.
                            WhoopsThereWasAnErrorWhileFetchingDataPleaseTryAgainLater, t.getMessage()), MainActivity.this, getString(R.string.Retry), null, LOG_TAG, false);
                }
            });
        } else {
            removeProgressItemFromRecyclerAdapter();
            AppUtil.showAlertDialogWith_TwoButtons(MainActivity.this, getString(R.string.
                    PleaseConnectToAWorkingInternetConnection), MainActivity.this, getString(R.string.Retry), null, LOG_TAG, false);
        }

    }

    private void addProgressItemToRecyclerAdapter() {

        if (listOfFeeds != null) {
            /**
             * add progress item to list
             */
            listOfFeeds.add(null);

            if (feedsAdapter != null) {
                feedsAdapter.notifyItemInserted(listOfFeeds.size() - 1);
            } else
                AppLog.e(LOG_TAG, "feedsAdapter is null");
        } else
            AppLog.e(LOG_TAG, "listOfFeeds is null");
    }

    private void removeProgressItemFromRecyclerAdapter() {
        if (listOfFeeds != null && listOfFeeds.size() != 0) {
            /**
             * remove progress item from list
             */
            listOfFeeds.remove(listOfFeeds.size() - 1);

            if (feedsAdapter != null) {
                feedsAdapter.notifyItemRemoved(listOfFeeds.size());
            } else
                AppLog.e(LOG_TAG, "feedsAdapter is null");
        } else
            AppLog.e(LOG_TAG, "listOfFeeds is null or listOfFeeds.size() is 0");
    }

    @Override
    public void onAlertDialogButtonClicked(String buttonText, String strTag) {

        if (strTag.equals(LOG_TAG)) {
            if (buttonText.equals(getString(R.string.Retry))) {
                getRedditHomeFeeds();
            } else
                AppLog.e(LOG_TAG, "in onAlertDialogButtonClicked() buttonText didn't match any of the mentioned cases");
        } else
            AppLog.e(LOG_TAG, "in onAlertDialogButtonClicked() strTag didn't match any of the mentioned cases");
    }
}