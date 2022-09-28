package com.rsstudio.nojoto.data.network.repository

import com.rsstudio.nojoto.data.network.apis.PostApiInterface
import com.rsstudio.nojoto.data.network.model.Data
import retrofit2.Response
import javax.inject.Inject

class UploadRepository
@Inject
constructor(private val api: PostApiInterface) {

    suspend fun postData(data: Data): Response<Data>{
       return api.post(data)
    }
}