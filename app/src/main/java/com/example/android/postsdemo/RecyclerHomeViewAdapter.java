package com.example.android.postsdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.postsdemo.databinding.PostsCardBinding;
import com.example.android.postsdemo.modelobjects.general.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielbeleza on 19/10/2017.
 */

public class RecyclerHomeViewAdapter extends RecyclerView.Adapter<RecyclerHomeViewAdapter.ViewHolder> {

    private List<Post> mPostsList;

    public RecyclerHomeViewAdapter(onItemClickListener onItemClickListener) {
        mPostsList = new ArrayList<>();
    }

    public interface onItemClickListener{
        void onItemClick(View view, Post post);
    }

    @Override
    public RecyclerHomeViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_card, parent, false);
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(RecyclerHomeViewAdapter.ViewHolder holder, int position) {
        final Post currentPost = mPostsList.get(position);

        // SET TITLE TEXT
        holder.getBinding().postTitleTextView.setText(currentPost.getmTitle());

        // SET BODY TEXT
        holder.getBinding().postBodyTextView.setText(currentPost.getmBody());

        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mPostsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private PostsCardBinding postsCardBinding;

        public ViewHolder(View view){
            super(view);
            postsCardBinding = DataBindingUtil.bind(view);
        }

        public PostsCardBinding getBinding(){
            return postsCardBinding;
        }
    }

    public void updateView(List<Post> postList){
        this.mPostsList = postList;
        notifyDataSetChanged();
    }
}
