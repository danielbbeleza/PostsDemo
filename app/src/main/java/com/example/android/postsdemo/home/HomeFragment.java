package com.example.android.postsdemo.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.postsdemo.detail.DetailFragment;
import com.example.android.postsdemo.modelobjects.general.Post;
import com.example.android.postsdemo.R;
import com.example.android.postsdemo.RecyclerHomeViewAdapter;
import com.example.android.postsdemo.databinding.FragmentHomeBinding;

import java.util.List;

/**
 * Created by danielbeleza on 19/10/2017.
 */

public class HomeFragment extends Fragment implements HomeView{

    private FragmentHomeBinding mBinding;
    private RecyclerHomeViewAdapter recyclerHomeViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showPosts(List<Post> posts) {

    }

    @Override
    public void showErrorMessage() {

    }

    @Override
    public void showErrorMessageNoWifi() {

    }

    @Override
    public void showErrorMessageNoWifiNoData() {

    }

    private void recyclerViewConfig(){
        mBinding.postsRecyclerView.setHasFixedSize(true);

        recyclerHomeViewAdapter = new RecyclerHomeViewAdapter(new RecyclerHomeViewAdapter.onItemClickListener(){
            @Override
            public void onItemClick(View view, Post post) {
                Fragment fragment = new DetailFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout_home_activity, fragment)
                        .commit();
            }
        });
    }

}
