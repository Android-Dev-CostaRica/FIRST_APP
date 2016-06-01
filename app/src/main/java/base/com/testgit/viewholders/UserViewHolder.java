package base.com.testgit.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import base.com.testgit.R;
import base.com.testgit.entities.User;
import butterknife.Bind;

public class UserViewHolder extends BaseViewHolder {

    @Bind(R.id.person_name)
    TextView textLogin;
    @Bind(R.id.type)
    TextView textType;
    @Bind(R.id.avatar)
    public ImageView imageViewAvatar;

    public UserViewHolder(View itemView, RecyclerViewCallback callback, Context mContext) {
        super(itemView, callback, mContext);
    }

    @Override
    public void bindHolder(Object object) {
        User user = (User)object;
        textLogin.setText(user.getLogin());
        textType.setText(user.getType());

        Picasso.with(context)
                .load(user.getAvatarUrl())
                .into(imageViewAvatar);
    }
}