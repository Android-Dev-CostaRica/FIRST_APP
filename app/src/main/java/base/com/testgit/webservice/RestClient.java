package base.com.testgit.webservice;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class RestClient {

    private static final String SERVER_END_POINT = "https://api.github.com/";

    private static RestClient sInstance;
    private RestInterface mRestInterface;
    private Retrofit retrofit;

    /**
     * It returns the singleton class instance
     * @return instance class
     */
    public static RestClient getsInstance() {
        if (sInstance == null) {
            sInstance = new RestClient();
        }
        return sInstance;
    }

    /**
     * Clear instance method
     */
    public static void clearInstance() {
        sInstance = null;
    }

    /**
     * Private default constructor
     * required for the singleton implementation
     */
    private RestClient() {
        setupRestClient();
    }

    /**
     * Set up RestInterface object
     */
    private void setupRestClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();
        mRestInterface = retrofit.create(RestInterface.class);

    }

    public OkHttpClient getOkHttpClient() {
        RequestInterceptor requestInterceptor = new RequestInterceptor();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build();
        return okHttpClient;
    }

    /**
     * It returns the RestInterface object initialized
     * @return the RestInterface
     */
    public RestInterface getService() {
        return mRestInterface;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}