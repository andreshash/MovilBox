package com.mobi.movilbox.movilbox.Networking;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Interfaces para conección a servicios de la rest
 */
public interface HttpService {

    @GET("report/redeemed_item/{user}")
    Call<ArrayList<Void>> getPrizes(
            @Path("user") String userId,
            @Query("password") String organization
    );

}