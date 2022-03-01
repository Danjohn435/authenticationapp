package com.example.helloworld.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloworld.AuthService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    val authservice = AuthService.AuthServiceCreator.newService()
    val shouldShowLoginScreen = MutableLiveData(false)

    fun register(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = authservice.registerNewUser(email, password)
            if (response.isSuccessful) {
                shouldShowLoginScreen.postValue(true)
            } else {
                shouldShowLoginScreen.postValue(false)
            }

        }
    }
}