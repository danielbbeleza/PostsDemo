package com.example.android.postsdemo.home;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.postsdemo.PresenterManager;
import com.example.android.postsdemo.R;
import com.example.android.postsdemo.databinding.FragmentHomeBinding;
import com.example.android.postsdemo.detail.DetailActivity;
import com.example.android.postsdemo.modelobjects.general.CompletePost;

import java.util.List;

/**
 * Created by danielbeleza on 19/10/2017.
 */

public class HomeFragment extends Fragment implements HomeView {

    private FragmentHomeBinding mBinding;
    private RecyclerHomeViewAdapter mRecyclerHomeViewAdapter;

    private HomePresenter homePresenter;

    public static final String COMPLETE_POST = "post";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homePresenter = (HomePresenter) PresenterManager.getInstance().restorePresenter(savedInstanceState);

        if(homePresenter == null) {
            HomeModel homeModel = new HomeModelImpl();
            homePresenter = new HomePresenterImpl(homeModel);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewConfig();

        homePresenter.onAttach(this);

        // First time its initialized
        if (savedInstanceState == null) {
            homePresenter.getPosts();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterManager.getInstance().savePresenter(homePresenter, outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        homePresenter.onDetach();

        Activity activity = getActivity();
        if(activity==null || activity.isFinishing() || isRemoving()){
            PresenterManager.getInstance().removePresenter(homePresenter);
        }
    }

    @Override
    public void showPosts(List<CompletePost> posts) {
        mRecyclerHomeViewAdapter.updateView(posts);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getContext().getApplicationContext(),
                getResources().getString(R.string.error_retrieving_posts_data_text), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessageNoWifi() {
        Toast.makeText(getContext().getApplicationContext(),
                getResources().getString(R.string.connection_error_retrieving_data_text), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessageNoWifiNoData() {

    }

    @Override
    public void sendUserData() {

    }

    private void recyclerViewConfig() {
        mBinding.postsRecyclerView.setHasFixedSize(true);

        mRecyclerHomeViewAdapter = new RecyclerHomeViewAdapter(new RecyclerHomeViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, CompletePost completePost) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(COMPLETE_POST, completePost);
                getActivity().startActivity(intent);
            }
        });

        mBinding.postsRecyclerView.setAdapter(mRecyclerHomeViewAdapter);
        mBinding.postsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }



}
