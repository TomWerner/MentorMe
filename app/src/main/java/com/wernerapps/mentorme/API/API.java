package com.wernerapps.mentorme.API;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Tom on 4/18/2015.
 */
public interface API {
    public static final String API_URL = "http://192.168.56.1:4567";

    @GET("/api.login")
    void login(@Query("username") String username, @Query("password") String password, Callback<Boolean> cb);

    @GET("/api.mentors")
    void getMentors(@Query("username") String username, Callback<List<Mentor>> cb);
}

