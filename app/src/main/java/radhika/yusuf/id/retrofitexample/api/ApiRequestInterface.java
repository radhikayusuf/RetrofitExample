package radhika.yusuf.id.retrofitexample.api;

import radhika.yusuf.id.retrofitexample.dao.LoginResponse;
import radhika.yusuf.id.retrofitexample.dao.body.LoginBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Radhika Yusuf on 27/05/17.
 */

public interface ApiRequestInterface {

    @POST("post/user/login")
    Call<LoginResponse> loginUser(@Body LoginBody data);

}
