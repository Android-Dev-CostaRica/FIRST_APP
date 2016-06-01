package base.com.testgit.ui;


import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import base.com.testgit.R;
import base.com.testgit.entities.User;
import butterknife.Bind;


public class InfoFragment extends BaseFragment {

    @Bind(R.id.person_name)
    TextView textLogin;
    @Bind(R.id.type)
    TextView textType;
    @Bind(R.id.avatar)
    public ImageView imageViewAvatar;
    private static final String ARG_USER = "user";
    private User mUser;

    public InfoFragment() { }

    public static InfoFragment newInstance(User user) {
        InfoFragment fragment = new InfoFragment();

        Bundle args = new Bundle();
        args.putParcelable(ARG_USER, (Parcelable) user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUser = (User)getArguments().getParcelable(ARG_USER);
        }
    }

    @Override
    public int getResourceViewId() {
        return R.layout.fragment_info;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fillUserInfo();
    }

    private void fillUserInfo(){
        textLogin.setText(mUser.getLogin());
        textType.setText(mUser.getType());
        Picasso.with(getActivity())
                .load(mUser.getAvatarUrl())
                .into(imageViewAvatar);
    }

}
