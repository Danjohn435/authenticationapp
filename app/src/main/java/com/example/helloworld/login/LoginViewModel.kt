package com.example.helloworld.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val email = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData(String())
    val shouldShowRegisterScreen = MutableLiveData(false)

    fun handleEmailChanged(e: String) {
        email.postValue(e)
    }

    fun handlePasswordChanged(p: String) {
        password.postValue(p)
    }

    fun handleLoginButtonClick() {
    }

    fun handleRegisterButtonClick() {
        shouldShowRegisterScreen.postValue(true)

    }
    // TODO: Implement the ViewModel
}