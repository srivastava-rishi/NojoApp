package com.rsstudio.nojoto.data.network.repository

import com.rsstudio.nojoto.data.network.apis.PostApiInterface
import com.rsstudio.nojoto.data.network.model.Data
import javax.inject.Inject

class UploadRepository
@Inject
constructor(private val api: PostApiInterface) {

    suspend fun postData(data: Data){
        api.post(data)
    }
}