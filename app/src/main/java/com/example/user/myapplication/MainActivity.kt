package com.example.user.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.user.myapplication.network.okhttp.AuthenticationInterceptor
import com.example.user.myapplication.network.retrofit.RequestAuthModel
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class MainActivity : AppCompatActivity() {
    val TAG : String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        getUserToken(createLogin(), "").getToken(createModel())
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        {responseTokenModel: ResponseTokenModel -> Log.d(TAG, "getUserToken : responseTokenModel = ${responseTokenModel.accessToken}") },
//                        {throwable: Throwable? ->
//                            run {
//                                Log.d(TAG, "onError : error =" + throwable.toString() + " " + throwable?.localizedMessage)
//                                if (throwable is HttpException) {
//                                    Log.d(TAG, throwable.message)
//                                    Log.d(TAG, "" + throwable.code())
//                                    Log.d(TAG, "" + throwable.response().raw())
//                                    Log.d(TAG, "" + throwable.response().body())
//                                    Log.d(TAG, "" + throwable.response().headers())
//                                    Log.d(TAG, "" + throwable.response().errorBody())
//                                    Log.d(TAG, "" + throwable.response().message())
//                                }else{
//                                    Log.d(TAG, "" + throwable.toString())
//                                    Log.d(TAG, "${throwable?.message}" )
//                                }
//                            }
//                        })
////


//        getUserInfo().deleteAuthorization("162921392")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        {jsonElement: JsonElement? -> Log.d(TAG, "onCreate : jsonElement = $jsonElement") },
//                        {throwable: Throwable? ->
//                            run {
//                                Log.d(TAG, "onError : error =" + throwable.toString() + " " + throwable?.localizedMessage)
//                                if (throwable is HttpException) {
//                                    Log.d(TAG, throwable.message)
//                                    Log.d(TAG, "" + throwable.code())
//                                    Log.d(TAG, "" + throwable.response().raw())
//                                    Log.d(TAG, "" + throwable.response().body())
//                                    Log.d(TAG, "" + throwable.response().headers())
//                                    Log.d(TAG, "" + throwable.response().errorBody())
//                                    Log.d(TAG, "" + throwable.response().message())
//                                }
//                            }
//                        }
//                )



//        getUserInfo().getUserInfo()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        {jsonElement: JsonElement? -> Log.d(TAG, "onCreate : jsonElement = $jsonElement") },
//                        {throwable: Throwable? ->
//                            run {
//                                Log.d(TAG, "onError : error =" + throwable.toString() + " " + throwable?.localizedMessage)
//                                if (throwable is HttpException) {
//                                    Log.d(TAG, throwable.message)
//                                    Log.d(TAG, "" + throwable.code())
//                                    Log.d(TAG, "" + throwable.response().raw())
//                                    Log.d(TAG, "" + throwable.response().body())
//                                    Log.d(TAG, "" + throwable.response().headers())
//                                    Log.d(TAG, "" + throwable.response().errorBody())
//                                    Log.d(TAG, "" + throwable.response().message())
//                                }
//                            }
//                        }
//                )
//
//
//        getUserInfo1().checkAuth(BuildConfig.GITHUB_CLIENT_ID, "9f6087eba718c7584cd2976e5ff4aa5809236a572a5d144b99d5d340be92b056")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        {jsonElement: JsonElement? -> Log.d(TAG, "onCreate : jsonElement = $jsonElement") },
//                        {throwable: Throwable? ->
//                            run {
//                                Log.d(TAG, "onError : error =" + throwable.toString() + " " + throwable?.localizedMessage)
//                                if (throwable is HttpException) {
//                                    Log.d(TAG, throwable.message)
//                                    Log.d(TAG, "" + throwable.code())
//                                    Log.d(TAG, "" + throwable.response().raw())
//                                    Log.d(TAG, "" + throwable.response().body())
//                                    Log.d(TAG, "" + throwable.response().headers())
//                                    Log.d(TAG, "" + throwable.response().errorBody())
//                                    Log.d(TAG, "" + throwable.response().message())
//                                }
//                            }
//                        }
//                )
    }

    fun createModel(): RequestAuthModel =
        RequestAuthModel().apply {
            clientId = BuildConfig.GITHUB_CLIENT_ID
            clientSecret = BuildConfig.GITHUB_SECRET
            scopes = (listOf<String>("public_repo"))
            note = "lll3"
        }


//
//    fun getUserToken(userNamePassword: String, optCode: String?): IRetrofitApi{
//        Log.d(TAG, "getUserToken : userNamePassword = $userNamePassword")
//        return RetrofitCreator(provideOkHttpClient( provideInterceptor(userNamePassword, optCode)))
//                .createIRetrofitApi()
//    }
//
//    fun getUserInfo(): IRetrofitApi{
//        return RetrofitCreator(provideOkHttpClient( provideInterceptor(createLogin(), "")))
//                .createIRetrofitApi()
//    }
//
//    fun getUserInfo1(): IRetrofitApi{
//        return RetrofitCreator(provideOkHttpClient(Interceptor {
//            chain ->
//            chain.proceed(chain.request().newBuilder().addHeader("Authorization", create222()).build())
//        }))
//                .createIRetrofitApi()
//    }


    fun provideOkHttpClient(interceptor:Interceptor) : OkHttpClient =
        OkHttpClient().newBuilder()
                .addInterceptor(interceptor)
                .addInterceptor(loging())
                .build()

    fun provideOkHttpClient() : OkHttpClient =
            OkHttpClient().newBuilder()
                    .addInterceptor(loging())
                    .build()

    fun provideInterceptor(userNamePassword: String, optCode: String?) : Interceptor {
        return AuthenticationInterceptor(userNamePassword, optCode)
    }

    fun createLogin(): String{
        val name = "EvgeniyaKonobeeva"
        val password = "O2r3l4o5v6"
        return  Credentials.basic(name, password)
    }

    fun create222(): String{
        val rr2:String = BuildConfig.GITHUB_CLIENT_ID
        val rr3:String = BuildConfig.GITHUB_SECRET
        return Credentials.basic(rr2, rr3)
    }

    fun loging(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }



}
