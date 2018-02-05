package com.example.user.myapplication.network.retrofit

import android.support.annotation.NonNull
import com.google.gson.JsonElement
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by Evgeniya on 04.02.2018.
 */
interface IRetrofitApi {

    @POST("authorizations")
    fun getToken(@NonNull @Body body: RequestAuthModel): Observable<ResponseTokenModel>

    @GET("user")
    fun getUserInfo(): Observable<JsonElement>

    @DELETE("authorizations/{id}")
    fun deleteAuthorization(@Path("id") id:String) : Observable<JsonElement>

    @GET("/applications/{client_id}/tokens/{access_token}")
    fun checkAuth(@Path("client_id") client_id:String, @Path("access_token") access_token: String) : Observable<JsonElement>

}