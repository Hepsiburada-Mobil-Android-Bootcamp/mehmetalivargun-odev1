package com.mehmetalivargun.odev1.ui.login


import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.mehmetalivargun.odev1.R
import com.mehmetalivargun.odev1.databinding.FragmentLoginPageBinding



class LoginPage : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentLoginPageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        loginViewModel =
            ViewModelProvider(this).get(LoginViewModel::class.java)
        _binding = FragmentLoginPageBinding.inflate(inflater, container, false)
        binding.loginButton.setOnClickListener { loginButton() }
        return binding.root

    }

    private fun loginButton() {


        requireActivity().findNavController(R.id.nav_host_fragment).navigate(R.id.action_loginPage_to_navigation_home)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}