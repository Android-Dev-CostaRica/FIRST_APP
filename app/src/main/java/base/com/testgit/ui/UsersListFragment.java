package base.com.testgit.ui;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import base.com.testgit.R;
import base.com.testgit.adapters.UsersListAdapter;
import base.com.testgit.entities.User;
import base.com.testgit.managers.UsersListManager;
import okhttp3.ResponseBody;

public class UsersListFragment extends BaseRecyclerViewFragment<List<User>> {

    private UsersListAdapter mUsersListAdapter;

    public static UsersListFragment newInstance() {
        UsersListFragment fragment = new UsersListFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    private void loadData() {
        showProgressBar();
        UsersListManager.getList(this);
    }

    private void updateAdapter() {
        mUsersListAdapter = new UsersListAdapter(data, this, getActivity());
        recyclerView.setAdapter(mUsersListAdapter);
        hideProgressBar();
    }

    @Override
    protected void onSuccessResponse(List<User> response) {
        data = response;
        if (data.size() <= 0) {
            Toast.makeText(getContext(), R.string.no_data, Toast.LENGTH_LONG).show();
        }
        updateAdapter();
    }

    @Override
    protected void onFailureResponse(ResponseBody response) {
        super.onFailureResponse(response);
        hideProgressBar();
    }

    @Override
    public void onFailure(Throwable t) {
        super.onFailure(t);
        hideProgressBar();
    }
}