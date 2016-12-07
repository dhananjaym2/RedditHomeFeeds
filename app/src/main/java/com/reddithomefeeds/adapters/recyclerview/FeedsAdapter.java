package com.reddithomefeeds.adapters.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.reddithomefeeds.R;
import com.reddithomefeeds.models.Child;
import com.reddithomefeeds.utilities.AppLog;
import com.reddithomefeeds.utilities.AppUtil;
import com.reddithomefeeds.webservices.ApiClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 01-12-2016.
 */
public class FeedsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_ITEM = 1;
    private final int VIEW_PROGRESS = 0;

    private final String LOG_TAG = this.getClass().getSimpleName();
    private Context context;
    private List<Child> feeds_list;
    private int lastVisibleItem;
    private int totalItemCount;
    private int visibleThreshold = 2;
    private boolean loading;
    private OnLoadMoreListener onLoadMoreListener;

    public FeedsAdapter(Context context, List<Child> feeds_list, RecyclerView recyclerView) {
        this.context = context;
        this.feeds_list = feeds_list;
//        RecyclerView recyclerView1 = recyclerView;

        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {

            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        // End has been reached, load more data now
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                        }
                        loading = true;
                    }
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == VIEW_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, null);
            vh = new Feeds_ViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.progress_item, parent, false);

            vh = new ProgressViewHolder(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof FeedsAdapter.Feeds_ViewHolder) {
            if (position % 2 == 0)
                setBackgroundColorFor(((Feeds_ViewHolder) holder).parent_RelativeLayout, android.R.color.white);
            else
                setBackgroundColorFor(((Feeds_ViewHolder) holder).parent_RelativeLayout, R.color.grey_light);

            ((Feeds_ViewHolder) holder).parent_RelativeLayout.setTag(position);

            ((Feeds_ViewHolder) holder).parent_RelativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickedPosition = (int) v.getTag();
                    AppLog.v(LOG_TAG, "clickedPosition from Tag:" + clickedPosition + " link:" +
                            ApiClient.BASE_URL + feeds_list.get(clickedPosition).getData().getPermalink());

                    AppUtil.openURLLinkInBrowserIntent(context, ApiClient.BASE_URL +
                            feeds_list.get(clickedPosition).getData().getPermalink());
                }
            });

            ((Feeds_ViewHolder) holder).title_textView.setText(feeds_list.get(position).getData().getTitle());

            ((Feeds_ViewHolder) holder).votes_textView.setText(context.getString(R.string.votes_colon, feeds_list.get(position).getData().getUps()));

            ((Feeds_ViewHolder) holder).time_textView.setText(AppUtil.getFormattedDate(feeds_list.get(position).getData().
                    getCreatedUtc(), "MM/dd hh:mm"));//"dd/MM/yyyy hh:mm:ss.SSS"
        } else {
            ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return feeds_list.get(position) != null ? VIEW_ITEM : VIEW_PROGRESS;
    }

    private void setBackgroundColorFor(RelativeLayout relativeLayout, int idOfColor) {
        relativeLayout.setBackgroundColor(AppUtil.getColorAccordingToAndroidVersion(context, idOfColor));
    }

    @Override
    public int getItemCount() {
//        AppLog.v(LOG_TAG, "in getItemCount()");
        if (feeds_list != null) {
//            AppLog.v(LOG_TAG, "in getItemCount() feeds_list.size():" + feeds_list.size());
            return feeds_list.size();
        } else
            return 0;
    }

    public void setLoaded() {
        loading = false;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    static class ProgressViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.progressBar_list_item)
        ProgressBar progressBar;

        ProgressViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class Feeds_ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.parent_RelativeLayout)
        RelativeLayout parent_RelativeLayout;

        @BindView(R.id.title_textView)
        TextView title_textView;

        @BindView(R.id.text_textView)
        TextView text_textView;

        @BindView(R.id.votes_textView)
        TextView votes_textView;

        @BindView(R.id.time_textView)
        TextView time_textView;

        Feeds_ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}