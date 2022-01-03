package com.example.helloworld.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.example.helloworld.R
import com.example.helloworld.register.RegisterFragment

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }
    lateinit var name: EditText
    lateinit var button: Button
    lateinit var registerButton: Button
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = view.findViewById(R.id.name)
        button = view.findViewById(R.id.login_button)
        registerButton=view.findViewById(R.id.register_button)

        var message =""
        name.doOnTextChanged { text, start, before, count ->
            message = text.toString()
        }
        button.setOnClickListener {
            Log.d("mainactivity", "hello i am a $message")
        }
        registerButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().add(R.id.container, RegisterFragment.newInstance(),"register")
                .addToBackStack("register")
                .commit()
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}