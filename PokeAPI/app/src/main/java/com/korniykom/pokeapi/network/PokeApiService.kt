package com.korniykom.pokeapi.network

import com.korniykom.pokeapi.model.PokemonResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://pokeapi.co/api/v2/"

private val retrofit =
    Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build()

interface PokeApiService {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") pokemonId: Int): PokemonResponse
}

object PokeApi {
    val retrofitService: PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }
}