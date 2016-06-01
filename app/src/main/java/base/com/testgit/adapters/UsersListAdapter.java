package base.com.testgit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import base.com.testgit.R;
import base.com.testgit.entities.User;
import base.com.testgit.viewholders.BaseViewHolder;
import base.com.testgit.viewholders.UserViewHolder;

public class UsersListAdapter extends BaseRecyclerViewAdapter<UserViewHolder> {

    private View mVview;
    private Context mContext;
    public UsersListAdapter(List<?> data, BaseViewHolder.RecyclerViewCallback callback,
                            Context context) {
        super(data, callback);
        mContext = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        mVview = inflater.inflate(R.layout.row_user, null);
        if(viewType % 2 == 0){
            mVview.setBackgroundResource(R.drawable.row);
        }else{
            mVview.setBackgroundResource(R.drawable.row_dark);
        }
        UserViewHolder viewHolder = new UserViewHolder(mVview, mCallback, mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = (User) mData.get(position);
        holder.bindHolder(user);
    }

    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);
        return position;
    }

}