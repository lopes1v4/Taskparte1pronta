package com.example.task.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.task.R
import com.example.task.databinding.FragmentLoginBinding
import com.example.task.util.showBottomSheet

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListner()
    }
    private fun initListner(){
        binding.bntLogin.setOnClickListener {
            validateData()
        }

        binding.bntRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.bntRecover.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_fragment_Recover)
        }
    }

    private fun validateData(){
        val email = binding.inputEmail.text.toString().trim()
        val senha = binding.inputSenha.text.toString().trim()

        if (email.isNotBlank()){
            if(senha.isNotBlank()){
                // Comentário temporário somente para testar a validação dos dados
                findNavController().navigate(R.id.action_global_homeFragment)
            } else {
                showBottomSheet(message = getString((R.string.passwordEmpty)))
            }
        } else {
            showBottomSheet(message = getString(R.string.emailEmpty))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
