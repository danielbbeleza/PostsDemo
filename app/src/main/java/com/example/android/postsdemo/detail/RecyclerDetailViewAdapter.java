package com.example.android.postsdemo.detail;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.postsdemo.R;
import com.example.android.postsdemo.databinding.CardCommentsBinding;
import com.example.android.postsdemo.modelobjects.general.Comments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielbeleza on 22/10/2017.
 */

public class RecyclerDetailViewAdapter extends RecyclerView.Adapter<RecyclerDetailViewAdapter.ViewHolder>{

    private List<Comments> commentsList;

    RecyclerDetailViewAdapter(){
        commentsList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_comments, parent, false);
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Comment name
        holder.getBinding().commentTitleText.setText(commentsList.get(position).getmName());

        // Comment Body
        holder.getBinding().commentBodyText.setText(commentsList.get(position).getmBody());
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    public void updateView(List<Comments> commentsList){
        this.commentsList = commentsList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private CardCommentsBinding cardCommentsBinding;

        public ViewHolder(View view){
            super(view);
            cardCommentsBinding = DataBindingUtil.bind(view);
        }

        public CardCommentsBinding getBinding(){
            return cardCommentsBinding;
        }
    }
}
