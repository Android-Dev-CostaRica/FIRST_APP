package base.com.testgit.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    protected RecyclerViewCallback mRecyclerViewCallback;
    protected Context context;

    public BaseViewHolder(View itemView, RecyclerViewCallback callback, Context mContext) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        context = mContext;
        mRecyclerViewCallback = callback;
    }

    @Override
    public void onClick(View v) {
        if (mRecyclerViewCallback != null) {
            mRecyclerViewCallback.onClickItem(v, getAdapterPosition());
        }
    }

    public abstract void bindHolder(Object object);

    public interface RecyclerViewCallback {
        void onClickItem(View v, int position);
    }
}