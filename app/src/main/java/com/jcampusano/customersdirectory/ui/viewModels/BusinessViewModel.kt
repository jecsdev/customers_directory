package com.jcampusano.customersdirectory.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcampusano.customersdirectory.data.database.entities.BusinessEntity
import com.jcampusano.customersdirectory.domain.UseCases.BusinessUseCases
import com.jcampusano.customersdirectory.domain.model.Business
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BusinessViewModel @Inject constructor(private val businessUseCases: BusinessUseCases) : ViewModel() {

    val businessModelList = MutableLiveData<MutableList<Business>>()

    fun getBusiness(){
        viewModelScope.launch {
            val list = businessUseCases.invoke()
            businessModelList.postValue(list as MutableList<Business>?)
        }
    }

    fun createBusiness(business: BusinessEntity){
        viewModelScope.launch {
            businessUseCases.insertBusiness(business)
        }
    }

    fun deleteBusiness(business: BusinessEntity){
        viewModelScope.launch {
            businessUseCases.deleteBusiness(business)
        }
    }


}