package com.example.android.dummyproductmanagement.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.dummyproductmanagement.MainRepository
import com.example.android.dummyproductmanagement.Resource
import com.example.android.dummyproductmanagement.model.ProductListResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository: MainRepository
): ViewModel() {

    private val _resource = MutableLiveData<Resource<ProductListResponse>>()

    val resource: LiveData<Resource<ProductListResponse>>
        get() = _resource

    init {
        getProductList()
    }

    private fun getProductList() {
        // CoroutineScope tied to this ViewModel.
        // This scope will be canceled when ViewModel will be cleared,
        // i.e ViewModel.onCleared is called
        viewModelScope.launch {
            _resource.postValue(Resource.loading(null))
            repository.getProductList().let {
                if (it.isSuccessful){
                    _resource.postValue(Resource.success(it.body()))
                }else{
                    _resource.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }
        }
    }
}