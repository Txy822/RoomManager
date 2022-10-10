package com.tes.eat.anywhere.roommanager.model.remote.news

import com.tes.eat.anywhere.roommanager.model.data.news.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET(NewsApiDetails.Country) //to define type of request GET, POST, PUT
    suspend fun getNews(
        @Query("Country") country:String="GB",
        @Query("apiKey") apikey:String= NewsApiDetails.API_KEY
    ): Response<News>
}