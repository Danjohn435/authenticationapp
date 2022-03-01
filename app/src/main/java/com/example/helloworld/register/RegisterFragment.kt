package com.example.helloworld.register

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import com.example.helloworld.R
import com.example.helloworld.VMFactory
import com.google.android.material.textfield.TextInputEditText

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private val viewModel: RegisterViewModel by viewModels{
        VMFactory()
    }
    private lateinit var email:TextInputEditText
    private lateinit var password:TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = view.findViewById(R.id.email_et)
        password = view.findViewById(R.id.password_et)
        view.findViewById<Button>(R.id.register_button).setOnClickListener {
            viewModel.register(email.text.toString(),password.text.toString())
        }

       viewModel.shouldShowLoginScreen.observe(viewLifecycleOwner) {
           if (it) {
               navigateToLoginScreen()
           }
       }
    }

    private fun navigateToLoginScreen() {
        requireActivity().supportFragmentManager.popBackStack()
    }

}