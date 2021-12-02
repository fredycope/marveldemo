package com.example.marveldemo.ui.listfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marveldemo.data.network.RetrofitService
import com.example.marveldemo.data.repositoryImpl.MarvelRepository
import com.example.marveldemo.domain.model.RequestMarvel
import com.example.marveldemo.domain.usecase.GetMarvelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getMarvelUseCase: GetMarvelUseCase) : ViewModel(){
   var marvel = MutableLiveData<RequestMarvel>()
    fun onCreate(apikey: String, hash: String){
        viewModelScope.launch {
            marvel.postValue(getMarvelUseCase.invoke(apikey, hash))
        }
    }
}