package com.example.geomob.Retrofit

import com.example.geomob.model.WikiArticle
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Wikipedia {

    @GET("/w/api.php?action=query&prop=extracts&format=json&exintro=1") fun getwiki(@Query("titles") id :String ): Call<JSONObject>
}