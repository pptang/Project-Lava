package com.money.lava.deal.api;

import com.money.lava.deal.model.Login.Auth;
import com.money.lava.deal.model.Login.User;
import com.money.lava.deal.model.account.UserAccount;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;

public interface CitiService {

    @POST("/retailbanking/v1/login")
    void userLogin(@Body User user, @Query("client_id") String clientId, Callback<Auth> cb);


    @GET("/retailbanking/v1/accounts")
    void getUserAccountInfo(@Header("Authorization") String token, @Query("client_id") String clientId,
                            Callback<UserAccount> cb);
}
