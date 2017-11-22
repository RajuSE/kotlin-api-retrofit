package com.elyeproj.wikisearchcount

import com.example.kotlin_api_retrofit.Root
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

interface IGitApi {

    @GET("users")
    fun searchUser(@Query("q") srsearch: String): Observable<Root>

    companion object {
        fun create(): IGitApi {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.github.com/search/")
                    .build()

            return retrofit.create(IGitApi::class.java)
        }
    }

}