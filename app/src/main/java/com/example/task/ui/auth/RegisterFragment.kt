package com.example.task.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.task.R
import com.example.task.databinding.FragmentRegisterBinding
import com.example.task.util.initToolbar
import com.example.task.util.showBottomSheet
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get()  = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }

    private fun initListener(){
        binding.bntRegister.setOnClickListener{
            validateData()
        }
    }
    private fun validateData(){
        val email = binding.inputEmail.text.toString().trim()
        val senha = binding.inputSenha.text.toString().trim()

        if (email.isNotBlank()){
            if(senha.isNotBlank()){
                Toast.makeText(requireContext(), "Tudo OK!", Toast.LENGTH_SHORT).show()
            } else {
                showBottomSheet(message =  getString(R.string.passwordEmptyRegister))
            }
        } else {
            showBottomSheet(message =  getString(R.string.emailEmptyRegister))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}