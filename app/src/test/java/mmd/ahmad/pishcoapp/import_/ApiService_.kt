package mmd.ahmad.pishcoapp.import_

import retrofit2.http.GET

interface ApiService_ {
    @GET("login_.php")
    suspend fun getData(): MyResponseModel_
}