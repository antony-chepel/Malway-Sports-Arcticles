package com.malwaysportsarticles.app.mlsportsapi

import com.walleyfreshnews.app.wnewsdata.MalwaysSportsResponse
import retrofit2.Call
import retrofit2.http.GET

interface MalwaysApi {

    @GET("top-headlines?sources=espn&apiKey=848d53bb52fa4bc38d62e0e17896a461")
    fun jfsfsdf() : Call<MalwaysSportsResponse>
}