package base.com.testgit.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import base.com.testgit.R;
import base.com.testgit.viewholders.BaseViewHolder;
import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class BaseRecyclerViewFragment<T> extends BaseFragment<T> implements BaseViewHolder.RecyclerViewCallback {

    @Bind(R.id.recycler_view)
    protected RecyclerView recyclerView;
    @Bind(R.id.progress_bar)
    protected ProgressBar progressBar;

    protected List<?> data;

    protected LinearLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this,view);
        layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public int getResourceViewId() {
        return R.layout.simple_recycler_view;
    }

    @Override
    public void onClickItem(View v, int position) {

    }

    protected void showProgressBar() {
        if (progressBar != null ) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    protected void hideProgressBar() {
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
    }
}