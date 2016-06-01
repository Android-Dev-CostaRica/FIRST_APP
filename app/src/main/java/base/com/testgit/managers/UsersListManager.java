package base.com.testgit.managers;


import java.util.List;

import base.com.testgit.entities.User;
import base.com.testgit.webservice.RestClient;
import retrofit2.Callback;

public class UsersListManager {

    public static void getList(Callback<List<User>> callback) {
        RestClient.getsInstance().getService().getUsersGithub().enqueue(callback);
    }

}