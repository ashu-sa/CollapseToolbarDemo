package com.ashu.fooddeliverydemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashu.fooddeliverydemo.api.repository
import com.ashu.fooddeliverydemo.data.VendorsItem
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModel(private val repository: repository): ViewModel() {
    val response: MutableLiveData<Response<VendorsItem>> = MutableLiveData()
    fun getItem(){
        viewModelScope.launch {
            val myResponse = repository.getItem()
            response.value =myResponse

        }


    }
}