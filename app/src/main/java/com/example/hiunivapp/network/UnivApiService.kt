package com.example.hiunivapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "http://universities.hipolabs.com/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UnivApiService{
    @GET(value = "search?country=Indonesia")
    suspend fun getUniv() : List<Univ>
}

object UnivApi{
    val retrofitService : UnivApiService by lazy {
        retrofit.create(UnivApiService::class.java)
    }
}