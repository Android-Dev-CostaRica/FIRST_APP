package base.com.testgit;

import android.app.Application;

import com.squareup.picasso.Picasso;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        Picasso.with(this)
                .setLoggingEnabled(true);
    }
}
