package com.example.superbotsdk2;

import com.example.superbotsdk2.Post;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataHolder {
    @GET("/api/mobile")
    Call<Post> getPost(@Query("account") String account,
                       @Query("secret") String secret);
}
