package com.example.android.postsdemo.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.postsdemo.R;
import com.example.android.postsdemo.databinding.FragmentDetailBinding;
import com.example.android.postsdemo.home.HomeFragment;
import com.example.android.postsdemo.modelobjects.general.Comments;
import com.example.android.postsdemo.modelobjects.general.CompletePost;

import java.util.List;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public class DetailFragment extends Fragment implements DetailView {

    private FragmentDetailBinding mBinding;
    private DetailPresenter detailPresenter;

    private RecyclerDetailViewAdapter recyclerDetailViewAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CompletePost completePost = (CompletePost) getActivity().getIntent().getExtras().getParcelable(HomeFragment.COMPLETE_POST);

        bindViews(completePost);
        recyclerViewConfig();

//        detailPresenter = (DetailPresenter) PresenterManager.getInstance().restorePresenter(savedInstanceState);
//
//        if (detailPresenter == null) {
//            DetailModel detailModel = new DetailModelImpl();
//            detailPresenter = new DetailPresenterImpl(detailModel);
//        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void showComments(List<Comments> commentList) {
        recyclerDetailViewAdapter.updateView(commentList);
    }

    @Override
    public void onError() {
        Toast.makeText(getContext().getApplicationContext(),
                getResources().getString(R.string.error_retrieving_comments_data_text), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionError() {
        Toast.makeText(getContext().getApplicationContext(),
                getResources().getString(R.string.connection_error_retrieving_data_text), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionErrorNoData() {

    }

    private void recyclerViewConfig() {


        mBinding.detailRecyclerView.setHasFixedSize(true);

        mBinding.detailRecyclerView.setAdapter(new RecyclerDetailViewAdapter());
        mBinding.detailRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void bindViews(CompletePost completePost) {
        mBinding.titleTextDetailView.setText(completePost.getmPost().getmTitle());
        mBinding.bodyTextDetailTextView.setText(completePost.getmPost().getmBody());

        mBinding.authorTextView.setText(completePost.getmUser().getmName());

        String commentariesQuantity = recyclerDetailViewAdapter.getItemCount() +
                getResources().getString(R.string.commentary_num_text);

        mBinding.commentariesTextQuantity.setText(commentariesQuantity);

        //mBinding.authorTextView.setText();
    }
}
