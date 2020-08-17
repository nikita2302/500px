package com.fivehunderedpx.challenge.apis

import com.fivehunderedpx.challenge.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    /**
    * Custom Interceptor to add headers to all requests
    * similarly can also add authentication and error handling interceptors
    */
    private val customHeaderInterceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            request = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()
            return chain.proceed(request)
        }
    }

    //default call timeout is 10 seconds but getting images from network might take time.
    private val okHttp = OkHttpClient.Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .callTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(customHeaderInterceptor)
        .addInterceptor(logger)

    val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
    }

    val photoAPIs: PhotoAPIService by lazy {
        retrofitBuilder.build().create(PhotoAPIService::class.java)
    }

    suspend fun <T : Any> safeApiCall(apiCall: suspend () -> retrofit2.Response<T>): Result<T> {
        return try {
            val myResp = apiCall.invoke()

            if(myResp.isSuccessful) {

                /**
                * As per the documentation the photos API will have response body. Hence this if condition is not required
                * Return format can be changed here from a String to a JSON Object.
                */
                if (myResp.code() == 204 || (myResp.code() == 201 && myResp.body() == null)) {
                    return Result.SuccessNoBody(" " + myResp.code() + " " + myResp.message())
                }

                return Result.Success(myResp.body()!!)
            } else {
                /**
                 * As per the documentation the photos API does not have an error.
                 * Hence the error handling is not required.
                 * There are multiple ways to handle errors. I would prefer enums over
                 * JSON objects and strings
                 */
                if (myResp.code() == 401) {
                    return Result.ErrorString(Constants.UNAUTHORIZED)
                }

                return Result.ErrorString(" " + myResp.code() + " " + myResp.message())
            }

        } catch (e: Exception) {
            Result.ErrorString(Constants.NETWORK_ERROR)
        }
    }
}