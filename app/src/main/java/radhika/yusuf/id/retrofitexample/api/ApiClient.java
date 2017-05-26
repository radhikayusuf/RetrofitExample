package radhika.yusuf.id.retrofitexample.api;

import radhika.yusuf.id.retrofitexample.helper.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Radhika Yusuf on 27/05/17.
 */

public class ApiClient {

    public static ApiRequestInterface service(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();
        return retrofit.create(ApiRequestInterface.class);
    }
}
