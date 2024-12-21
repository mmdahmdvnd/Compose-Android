package mmd.ahmad.pishcoapp

import okhttp3.Response
import retrofit2.http.GET

interface ApiService {
    @GET("login_.php")
    suspend fun getData(): MyResponseModel
}