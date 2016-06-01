package base.com.testgit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import base.com.testgit.entities.User;
import base.com.testgit.ui.InfoFragment;

public class InfoActivity extends AppCompatActivity {

    User mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        mUser = (User)getIntent().getExtras().getParcelable("user");
        showFragmentInfo();
    }

    private void showFragmentInfo(){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, InfoFragment.newInstance(mUser)).commit();
    }
}
