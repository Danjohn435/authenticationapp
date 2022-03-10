package com.example.helloworld.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloworld.AuthService
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val service = AuthService.AuthServiceCreator.newService()
    val email = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData(String())
    val shouldShowRegisterScreen = MutableLiveData(false)
    val shouldShowHomeScreen = MutableLiveData(false)

    fun handleEmailChanged(e: String) {
        email.postValue(e)
    }

    fun handlePasswordChanged(p: String) {
        password.postValue(p)
    }

    fun handleLoginButtonClick() {
        viewModelScope.launch {
            val response = service.login(email.value!!, password.value!!)
            if (response.isSuccessful) {
                shouldShowHomeScreen.postValue(true)

            }
        }
    }

    fun handleRegisterButtonClick() {
        shouldShowRegisterScreen.postValue(true)

    }
    // TODO: Implement the ViewModel
}