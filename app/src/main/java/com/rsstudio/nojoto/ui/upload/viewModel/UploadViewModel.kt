package com.rsstudio.nojoto.ui.upload.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rsstudio.nojoto.data.network.model.Data
import com.rsstudio.nojoto.data.network.repository.UploadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UploadViewModel
@Inject
constructor(
    private val repository: UploadRepository,
) : ViewModel() {

    var logTag = "@UploadViewModel"

    // the pattern that i usually follow
    private val _postData: MutableLiveData<Response<Data>> = MutableLiveData()
    val postData: LiveData<Response<Data>> get() = _postData



    fun saveData(data:Data) {
        viewModelScope.launch {
           var data = Data(
               data.type,
               data.image
           )
         val result = repository.postData(data)
            _postData.value = result
        }
    }


}