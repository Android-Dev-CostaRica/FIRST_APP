package base.com.testgit.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;



import java.util.List;

import base.com.testgit.viewholders.BaseViewHolder;

public class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    protected List<?> mData;
    protected BaseViewHolder.RecyclerViewCallback mCallback;

    public BaseRecyclerViewAdapter(List<?> data, BaseViewHolder.RecyclerViewCallback callback) {
        mData = data;
        mCallback = callback;
    }


    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(T holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }
}