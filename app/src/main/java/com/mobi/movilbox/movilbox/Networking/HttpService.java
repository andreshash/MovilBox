package com.mobi.movilbox.movilbox.Networking;

import com.mobi.movilbox.movilbox.Models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Interfaces para conección a servicios de la rest
 */
public interface HttpService {

    @POST("login")
    Call<User> login (
            @Body User data
    );
}