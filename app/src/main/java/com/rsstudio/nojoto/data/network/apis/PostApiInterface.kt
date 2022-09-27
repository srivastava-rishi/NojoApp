package com.rsstudio.nojoto.data.network.apis

import com.rsstudio.nojoto.data.network.model.Data
import retrofit2.http.Body
import retrofit2.http.POST

interface PostApiInterface {

    @POST("content.php?cid=7ec99b415af3e88205250e3514ce0fa7")
    suspend fun post(
        @Body data: Data
    )
}