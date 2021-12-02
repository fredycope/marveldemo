package com.example.marveldemo.ui.detailfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marveldemo.domain.model.RequestMarvel
import com.example.marveldemo.domain.usecase.GetMarvelIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DetailViewModel @Inject constructor(private val getMarvelIdUseCase: GetMarvelIdUseCase): ViewModel() {
    var marvelId = MutableLiveData<RequestMarvel>()

    fun onCreate(characterId: Int, apikey: String, hash: String){
        viewModelScope.launch {
            marvelId.postValue(getMarvelIdUseCase.invoke(characterId, apikey, hash))
        }
    }
}