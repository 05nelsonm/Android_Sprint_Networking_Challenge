package com.lambdaschool.pokemonapi.retrofit

import android.text.Editable
import com.google.gson.Gson
import com.lambdaschool.pokemonapi.model.Pokemon
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface PokemonAPI {

    @GET("pokemon")
    fun getPokemonByName(@Path("name") pokemonName: String): Call<Pokemon>

    @GET("pokemon/{id}")
    fun getPokemonById(@Path("id") pokemonId: Int): Call<Pokemon>

    class Factory {

        companion object {
            val BASE_URL = "https://pokeapi.co/api/v2/"
            val gson = Gson()
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
                level = HttpLoggingInterceptor.Level.BODY
            }


            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logger)
                .retryOnConnectionFailure(false)
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build()

            fun create(): PokemonAPI {

                return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(PokemonAPI::class.java)
            }
        }
    }

}