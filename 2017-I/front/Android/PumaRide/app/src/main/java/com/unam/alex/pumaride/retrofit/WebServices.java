package com.unam.alex.pumaride.retrofit;

import com.unam.alex.pumaride.models.Match;
import com.unam.alex.pumaride.models.MatchServer;
import com.unam.alex.pumaride.models.MessageResult;
import com.unam.alex.pumaride.models.ReverseGeoCodeAddress;
import com.unam.alex.pumaride.models.ReverseGeoCodeResult;
import com.unam.alex.pumaride.models.Route;
import com.unam.alex.pumaride.models.Route2;
import com.unam.alex.pumaride.models.Route3;
import com.unam.alex.pumaride.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by alex on 30/10/16.
 */
public interface WebServices {
    @GET("pumaride/users/")
    Call<List<Match>> listMatches();
    @POST("pumaride/registro/")
    Call<User> createUser(@Body User user);
    @FormUrlEncoded
    @POST("pumaride/login/")
    Call<User> loginUser(@Field("email") String email, @Field("password") String password);
    @GET("pumaride/users/me")
    Call<User> getUserMe(@Header("Authorization") String authorization);
    @FormUrlEncoded
    @POST("pumaride/password/reset/")
    Call<User> resetPassword(@Field("email") String email);
    @FormUrlEncoded
    @POST("api/lines/")
    Call<Route2> getShortestPath(@Field("p_origen") String source, @Field("p_destino") String target,@Field("user_id") int User_id);

    @FormUrlEncoded
    @POST("api/lines/")
    Call<Route2> saveShortestPath(@Field("p_origen") String source, @Field("p_destino") String target,@Field("guardar") String guardar,@Field("user_id") int User_id);


    @GET("json")
    Call<ReverseGeoCodeResult> getAddressFromLoc(@Query("latlng") String latlng,@Query("key") String key);

    @GET("send_message_2.php")
    Call<MessageResult> sendMessage(@Query("id") int id,@Query("message") String message);

    @FormUrlEncoded
    @POST("register.php")
    Call<MessageResult> register(@Field("email") String email, @Field("name") String name, @Field("regId") String regId);


    @FormUrlEncoded
    @POST("api/matches/")
    Call<List<MatchServer>> getMatches(@Field("ruta_id") int id_route);

}