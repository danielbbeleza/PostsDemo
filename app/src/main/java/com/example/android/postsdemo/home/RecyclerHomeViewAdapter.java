package com.example.android.postsdemo.home;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.postsdemo.R;
import com.example.android.postsdemo.databinding.CardPostsBinding;
import com.example.android.postsdemo.modelobjects.general.CompletePost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielbeleza on 19/10/2017.
 */

public class RecyclerHomeViewAdapter extends RecyclerView.Adapter<RecyclerHomeViewAdapter.ViewHolder> {

    private OnItemClickListener mOnItemClickListener;

    private List<CompletePost> mPostsList;

    public RecyclerHomeViewAdapter(OnItemClickListener onItemClickListener) {
        mPostsList = new ArrayList<>();
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, CompletePost completePost);
    }

    @Override
    public RecyclerHomeViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_posts, parent, false);
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(RecyclerHomeViewAdapter.ViewHolder holder, int position) {
        final CompletePost currentPost = mPostsList.get(position);

        // SET TITLE TEXT
        holder.getBinding().postTitleTextView.setText(currentPost.getmPost().getmTitle());

        // SET BODY TEXT
        holder.getBinding().postBodyTextView.setText(currentPost.getmPost().getmBody());

        holder.getBinding().executePendingBindings();

        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v, currentPost);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPostsList.size();

    }

    public void updateView(List<CompletePost> postList){
        this.mPostsList = postList;
        notifyDataSetChanged();
    }

    /**VIEW HOLDER**/
    class ViewHolder extends RecyclerView.ViewHolder{
        private CardPostsBinding postsCardBinding;

        public ViewHolder(View view){
            super(view);
            postsCardBinding = DataBindingUtil.bind(view);
        }

        public CardPostsBinding getBinding(){
            return postsCardBinding;
        }
    }





}
