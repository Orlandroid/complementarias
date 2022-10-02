package com.example.app_004_complementariasmx.presentacion.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_004_complementariasmx.data.api.FakeStoreService
import com.example.app_004_complementariasmx.domain.modelo.remote.LoginRequest
import com.example.app_004_complementariasmx.presentacion.util.ServiceBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MenuViewModel : ViewModel() {


    private val _login = MutableLiveData<Boolean>()
    val login: MutableLiveData<Boolean>
        get() = _login

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            val service = ServiceBuilder.buildService(FakeStoreService::class.java)
            try {
                val response = service.login(loginRequest)
                response.token?.let {
                    if (response.token.isNotEmpty()) {
                        login.postValue(true)
                        return@launch
                    }
                }
                login.postValue(false)
            } catch (e: Exception) {
                login.postValue(false)
            }
        }
    }
}