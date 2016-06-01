package base.com.testgit.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import base.com.testgit.R;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseFragment<T> extends Fragment implements Callback<T> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getResourceViewId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onFailure(Throwable t) {
        displayError();
    }

    private void displayError() {
        Toast.makeText(getContext(), R.string.error_loading_data, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(Response<T> response) {
        if (!response.isSuccess()) {
            onFailureResponse(response.errorBody());
        } else {
            onSuccessResponse(response.body());
        }
    }

    protected void onSuccessResponse(T response) {}

    protected void onFailureResponse(ResponseBody response) {
        displayError();
    }

    public abstract int getResourceViewId();
}