package com.example.marveldemo.ui.listfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marveldemo.domain.model.Results
import com.example.marveldemo.domain.usecase.GetMarvelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getMarvelUseCase: GetMarvelUseCase) : ViewModel(){
   var marvel = MutableLiveData<List<Results>>()
    fun onCreate(apikey: String, hash: String){
        viewModelScope.launch {
            val res = getMarvelUseCase.invoke(apikey, hash)
            if(res.code != 0){
                marvel.postValue(res.data.results)
            }
        }
    }
}