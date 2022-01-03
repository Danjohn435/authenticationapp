package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.example.helloworld.login.LoginFragment
import com.example.helloworld.register.RegisterFragment

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().add(R.id.container, LoginFragment.newInstance(),"login")
                .addToBackStack("login")
                .commit()
        }

    }
}