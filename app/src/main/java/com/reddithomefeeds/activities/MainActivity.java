package com.reddithomefeeds.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.reddithomefeeds.R;
import com.reddithomefeeds.adapters.recyclerview.FeedsAdapter;
import com.reddithomefeeds.interfaces.OnListItemClickListener;
import com.reddithomefeeds.models.RedditHomeFeeds;
import com.reddithomefeeds.utilities.AppLog;
import com.reddithomefeeds.utilities.AppUtil;
import com.reddithomefeeds.webservices.ApiClient;
import com.reddithomefeeds.webservices.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnListItemClickListener {

    private final String LOG_TAG = this.getClass().getSimpleName();

    @BindView(R.id.feeds_recyclerView_MainActivity)
    RecyclerView feeds_recyclerView_MainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();

        getRedditHomeFeeds();
    }

    private void getRedditHomeFeeds() {
        AppLog.d(LOG_TAG, "getRedditHomeFeeds()");

        ApiInterface apiService = ApiClient.getApiClient().create(ApiInterface.class);
        if (AppUtil.isInternetAvailable(this)) {
            final ProgressDialog progressDialog = AppUtil.showProgressDialog(this, null, false);

            Call<RedditHomeFeeds> call_appGenericApiResponse = apiService.getRedditHomeFeeds();
            call_appGenericApiResponse.enqueue(new Callback<RedditHomeFeeds>() {
                @Override
                public void onResponse(Call<RedditHomeFeeds> call, Response<RedditHomeFeeds> response) {

                    AppUtil.dismissProgressDialog(progressDialog);

                    if (response != null) {
                        if (response.body() != null) {
                            AppLog.v(LOG_TAG, "onResponse() kind:" + response.body().getKind());

                            setAdapter(response.body());

                            return;
                        } else
                            AppLog.e(LOG_TAG, "response.body() null");
                    } else
                        AppLog.e(LOG_TAG, "response null");
                    AppUtil.showAlertDialogWith1Button(MainActivity.this, getString(R.string.
                            WhoopsThereWasAnErrorPleaseTryAgainLater), null, null, LOG_TAG, true);
                }

                @Override
                public void onFailure(Call<RedditHomeFeeds> call, Throwable t) {
                    AppLog.v(LOG_TAG, "onFailure() t:" + t.getMessage());
                    AppUtil.dismissProgressDialog(progressDialog);
                    AppUtil.showAlertDialogWith1Button(MainActivity.this, getString(R.string.
                            WhoopsThereWasAnErrorPleaseTryAgainLater), null, null, LOG_TAG, true);
                }
            });
        } else {
            AppUtil.showAlertDialogWith1Button(this, getString(R.string.
                    PleaseConnectToAWorkingInternetConnection), null, null, LOG_TAG, true);
        }

    }

    private void setAdapter(RedditHomeFeeds result_RedditHomeFeeds) {
        AppLog.d(LOG_TAG, "setAdapter()");

        if (result_RedditHomeFeeds != null) {
            if (result_RedditHomeFeeds.getData() != null) {
                if (result_RedditHomeFeeds.getData().getChildren() != null) {

                    feeds_recyclerView_MainActivity.setAdapter(new FeedsAdapter(this,
                            result_RedditHomeFeeds.getData().getChildren(), this));
                    return;

                } else
                    AppLog.e(LOG_TAG, "result_RedditHomeFeeds.getData().getChildren() is null");
            } else
                AppLog.e(LOG_TAG, "result_RedditHomeFeeds.getData() is null");
        } else
            AppLog.e(LOG_TAG, "result_RedditHomeFeeds != null");
        AppUtil.showAlertDialogWith1Button(this, getString(R.string.SomethingIsNotOK), null, null, LOG_TAG, true);
    }

    private void initializeView() {
        AppLog.d(LOG_TAG, "initializeView()");
        ButterKnife.bind(this);
        feeds_recyclerView_MainActivity.setLayoutManager(new LinearLayoutManager(this));// = (RecyclerView)
    }

    @Override
    public void onListItemClicked() {
        AppLog.v(LOG_TAG, "onListItemClicked()");
    }
}