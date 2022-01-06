package com.example.helloworld.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.example.helloworld.R
import com.example.helloworld.VMFactory
import com.example.helloworld.register.RegisterFragment
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }
    lateinit var email: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var button: Button
    lateinit var registerButton: Button
    private val viewModel: LoginViewModel by viewModels { VMFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = view.findViewById(R.id.email)
        password =view.findViewById(R.id.password)
        button = view.findViewById(R.id.login_button)
        registerButton=view.findViewById(R.id.register_button)

        email.doOnTextChanged { text, start, before, count ->
            viewModel.handleEmailChanged(text.toString())
        }
        password.doOnTextChanged { text, start, before, count ->
            viewModel.handlePasswordChanged(text.toString())

        }
        button.setOnClickListener {

            viewModel.handleLoginButtonClick()
        }
        registerButton.setOnClickListener {
            viewModel.handleRegisterButtonClick()
            requireActivity().supportFragmentManager.beginTransaction().add(R.id.container, RegisterFragment.newInstance(),"register")
                .addToBackStack("register")
                .commit()
        }
    }



}