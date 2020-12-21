package cl.serlitoral.kotlinapi.api

import cl.serlitoral.kotlinapi.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface iRetrofitService {
    @GET("marvel")

    fun getMovieList() : Call<MutableList<Movie>>

}