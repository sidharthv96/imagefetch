package com.sidharth.imagefetch

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by sidharthvinod on 24/05/17.
 */

interface WorldAPI {
    @GET("tutorial/jsonparsetutorial.txt")
    fun getPopulation(): Observable<World>
}