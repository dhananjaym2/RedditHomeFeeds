package com.reddithomefeeds.adapters.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.reddithomefeeds.R;
import com.reddithomefeeds.interfaces.OnListItemClickListener;
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
public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.Feeds_ViewHolder> {

    private final String LOG_TAG = this.getClass().getSimpleName();
    private Context context;
    private List<Child> feeds_list;
    private OnListItemClickListener onListItemClickListener;

    public FeedsAdapter(Context context, List<Child> feeds_list, OnListItemClickListener onListItemClickListener) {
        this.context = context;
        this.feeds_list = feeds_list;
        this.onListItemClickListener = onListItemClickListener;
    }

    @Override
    public FeedsAdapter.Feeds_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Feeds_ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, null));
    }

    @Override
    public void onBindViewHolder(FeedsAdapter.Feeds_ViewHolder holder, int position) {
        if (position % 2 == 0)
            setBackgroundColorFor(holder.parent_RelativeLayout, android.R.color.white);
        else
            setBackgroundColorFor(holder.parent_RelativeLayout, R.color.grey_light);

        holder.parent_RelativeLayout.setTag(position);

        holder.parent_RelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = (int) v.getTag();
                AppLog.v(LOG_TAG, "clickedPosition from Tag:" + clickedPosition + " link:" +
                        ApiClient.BASE_URL + feeds_list.get(clickedPosition).getData().getPermalink());

                AppUtil.openURLLinkInBrowserIntent(context, ApiClient.BASE_URL +
                        feeds_list.get(clickedPosition).getData().getPermalink());
            }
        });

        holder.title_textView.setText(feeds_list.get(position).getData().getTitle());

        holder.votes_textView.setText(context.getString(R.string.votes_colon, feeds_list.get(position).getData().getUps()));

        holder.time_textView.setText(AppUtil.getFormattedDate(feeds_list.get(position).getData().
                getCreatedUtc(), "MM/dd hh:mm"));//"dd/MM/yyyy hh:mm:ss.SSS"
    }

    private void setBackgroundColorFor(RelativeLayout relativeLayout, int idOfColor) {
        relativeLayout.setBackgroundColor(AppUtil.getColorAccordingToAndroidVersion(context, idOfColor));
    }

    @Override
    public int getItemCount() {
        if (feeds_list != null)
            return feeds_list.size();
        else
            return 0;
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
//            title_textView = (TextView) itemView.findViewById(R.id.title_textView);
//            text_textView = (TextView) itemView.findViewById(R.id.text_textView);
//            votes_textView = (TextView) itemView.findViewById(R.id.votes_textView);
//            time_textView = (TextView) itemView.findViewById(R.id.time_textView);
//
//            parent_RelativeLayout = (RelativeLayout) itemView.findViewById(R.id.parent_RelativeLayout);
        }
    }
}