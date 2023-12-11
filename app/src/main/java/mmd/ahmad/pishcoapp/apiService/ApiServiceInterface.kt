package mmd.ahmad.pishcoapp.apiService

import mmd.ahmad.pishcoapp.model.MyResponseModel
import retrofit2.http.GET

interface ApiServiceInterface {
    @GET("login_.php")
    suspend fun getData(): MyResponseModel
}