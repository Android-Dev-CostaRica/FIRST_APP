package base.com.testgit.webservice;

import java.util.List;
import base.com.testgit.entities.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInterface {

    @GET("users")
    Call<List<User>> getUsersGithub();
}