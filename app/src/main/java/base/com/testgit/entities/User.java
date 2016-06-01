package base.com.testgit.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import base.com.testgit.utils.Constants;

public class User implements Constants, Parcelable {

    @SerializedName(USER_LOGIN)
    private String mLogin;

    @SerializedName(USER_AVATAR_URL)
    private String mAvatarUrl;

    @SerializedName(USER_TYPE)
    private String mType;

    /**
     *
     * @return
     * The login
     */
    public String getLogin() {
        return mLogin;
    }

    /**
     *
     * @param login
     * The login
     */
    public void setLogin(String login) {
        this.mLogin = login;
    }

    /**
     *
     * @return
     * The avatarUrl
     */
    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    /**
     *
     * @param avatarUrl
     * The avatar_url
     */
    public void setAvatarUrl(String avatarUrl) {
        this.mAvatarUrl = avatarUrl;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return mType;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.mType = type;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mLogin);
        dest.writeString(this.mAvatarUrl);
        dest.writeString(this.mType);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.mLogin = in.readString();
        this.mAvatarUrl = in.readString();
        this.mType = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}