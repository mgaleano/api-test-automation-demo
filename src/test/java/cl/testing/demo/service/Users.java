package cl.testing.demo.service;

import cl.testing.demo.entity.User;
import cl.testing.demo.entity.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Users {

    @POST("/api/users")
    Call<UserResponse> create(@Body User user);

    @GET("/api/users")
    Call<String> list(@Query("page") int page);
}
