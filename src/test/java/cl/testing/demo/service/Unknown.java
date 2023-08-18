package cl.testing.demo.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Unknown {

    @GET("/api/unknown/{id}")
    Call<String> resource(@Path("id") String id);
}
