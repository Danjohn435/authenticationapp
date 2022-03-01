package com.example.helloworld

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.helloworld.login.LoginViewModel
import com.example.helloworld.register.RegisterViewModel

class VMFactory() : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == LoginViewModel::class.java) {
            LoginViewModel() as T
        } else if (modelClass == RegisterViewModel::class.java) {
            RegisterViewModel() as T
        } else {
            super.create(modelClass)
        }
    }
}