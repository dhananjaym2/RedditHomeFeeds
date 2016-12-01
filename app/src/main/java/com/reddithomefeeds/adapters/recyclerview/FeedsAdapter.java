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

import java.util.List;

/**
 * Created by Admin on 01-12-2016.
 */
public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.Feeds_ViewHolder> {

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
        holder.title_textView.setText(feeds_list.get(position).getData().getTitle());
    }

    @Override
    public int getItemCount() {
        if (feeds_list != null)
//            if (result_redditHomeFeeds.getData() != null)
//                if (result_redditHomeFeeds.getData().getChildren() != null)
            return feeds_list.size();
        return 0;
    }

    static class Feeds_ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout parent_RelativeLayout;
        private TextView title_textView, text_textView, votes_textView, time_textView;

        Feeds_ViewHolder(View itemView) {
            super(itemView);
            title_textView = (TextView) itemView.findViewById(R.id.title_textView);
        }
    }
}