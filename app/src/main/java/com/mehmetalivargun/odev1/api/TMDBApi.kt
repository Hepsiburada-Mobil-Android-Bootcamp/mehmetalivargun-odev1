package com.mehmetalivargun.odev1.api

import com.mehmetalivargun.odev1.data.api.ActorResponse
import com.mehmetalivargun.odev1.data.api.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface TMDBApi {
    @GET("/3/movie/popular?api_key=66759c0f486b672b55c72aaa440fbc28&language=en-US&page=1")
    suspend fun listAllPopularMovies(): Response<MovieResponse>

    @GET("3/person/popular?api_key=66759c0f486b672b55c72aaa440fbc28&language=en-US&page=1")
    suspend fun listAllPopularActors(): Response<ActorResponse>
}